package com.application.backend.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.backend.CustomerRepo.CustomerRepo;
import com.application.backend.DTO.CustomerDTO;
import com.application.backend.DTO.CustomerSaveDTO;
import com.application.backend.Entity.Customer;

@Service
public class CustomerServiceIMPL implements CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public String addCustomer(CustomerSaveDTO customerSaveDTO) {
		
		Customer customer = new Customer(
				
		customerSaveDTO.getCustomername(),
		customerSaveDTO.getCustomeraddress(),
		customerSaveDTO.getMobile()
		);
				
		customerRepo.save(customer);
		return customer.getCustomername();
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		
		List<Customer> getCustomers = customerRepo.findAll();
		List<CustomerDTO> customerDTOList = new ArrayList<>();
		
		for(Customer a:getCustomers) {
			CustomerDTO customerDTO = new CustomerDTO(
			a.getCustomerid(),
			a.getCustomername(),
			a.getCustomeraddress(),
			a.getMobile()
		);
			customerDTOList.add(customerDTO);
		}
		return customerDTOList;
	}

}
