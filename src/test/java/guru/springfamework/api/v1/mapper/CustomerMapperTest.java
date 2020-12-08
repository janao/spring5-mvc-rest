package guru.springfamework.api.v1.mapper;

import static org.junit.Assert.*;

import org.junit.Test;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;

public class CustomerMapperTest {

	public static final String FIRSTNAME = "Jimmy";
    public static final String LASTNAME = "Fallon";
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

	@Test
	public void customerToCustomerDTO() {
		Customer customer = new Customer();
		customer.setFirstname(FIRSTNAME);
		customer.setLastname(LASTNAME);
		
		CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
		
		assertEquals(LASTNAME, customerDTO.getLastname());
		assertEquals(FIRSTNAME, customerDTO.getFirstname());
	}
}