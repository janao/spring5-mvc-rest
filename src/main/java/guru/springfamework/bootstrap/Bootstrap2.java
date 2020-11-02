package guru.springfamework.bootstrap;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Bootstrap2 implements ApplicationListener<ContextRefreshedEvent> {
	
	private CategoryRepository categoryRepository;

	public Bootstrap2(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Category fruits = new Category();
        fruits.setName("Fruits2");

        Category dried = new Category();
        dried.setName("Dried2");

        Category fresh = new Category();
        fresh.setName("Fresh2");

        Category exotic = new Category();
        exotic.setName("Exotic2");

        Category nuts = new Category();
        nuts.setName("Nuts2");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);


        log.info("Data Loaded = " + categoryRepository.count() );
		
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {
		log.info("Yaaah, I am running........");
	}

}
