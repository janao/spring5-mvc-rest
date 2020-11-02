package guru.springfamework.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;

public class CategoryServiceTest {
	
	public static final Long ID = 2L;
    public static final String NAME = "Jimmy";
    CategoryService categoryService;
    
    @Mock
    CategoryRepository categoryRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

        categoryService = new CategoryServiceImpl(CategoryMapper.INSTANCE, categoryRepository);
	}

	@Test
	public void testGetAllCategories() {
		List<Category> categories = Arrays.asList(new Category(),new Category(),new Category());
		when(categoryRepository.findAll()).thenReturn(categories);
		
		List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();
		
		assertEquals(3, categoryDTOS.size());
	}

	@Test
	public void testGetCategoryByName() {
		Category category = new Category();
		category.setId(ID);
		category.setName(NAME);
		
		when(categoryRepository.findByName(NAME)).thenReturn(category);
		
		CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);
		
		assertEquals(ID, categoryDTO.getId());
		assertEquals(NAME, categoryDTO.getName());
		
	}

}
