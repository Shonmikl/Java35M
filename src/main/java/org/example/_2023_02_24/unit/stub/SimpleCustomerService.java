package org.example._2023_02_24.unit.stub;

public class SimpleCustomerService implements CustomerService {

	CustomerRepository customerRepository;

	public SimpleCustomerService(CustomerRepository customerRepository){
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerRepository.getCustomerById(id);
		
	}
}