package guru.springfamework.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerMapper customerMapper;
	private final CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
		super();
		this.customerMapper = customerMapper;
		this.customerRepository = customerRepository;
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(c -> {
			CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(c);
			customerDTO.setCustomerUrl("/api/v1/customers/" + c.getId());
			return customerDTO;
			}).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		return customerRepository.findById(id).map(c -> customerMapper.customerToCustomerDTO(c)).orElseThrow(() -> new RuntimeException());
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
		Customer savedCustomer = customerRepository.save(customerMapper.customerDTOToCustomer(customerDTO));
		CustomerDTO returnDto = customerMapper.customerToCustomerDTO(savedCustomer);

        returnDto.setCustomerUrl("/api/v1/customer/" + savedCustomer.getId());

        return returnDto;
	}

}