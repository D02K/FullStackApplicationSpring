package com.application.backend.CustomerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.backend.DTO.CustomerDTO;
import com.application.backend.DTO.CustomerSaveDTO;
import com.application.backend.Service.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(path="/save")
	public String saveCustomer(@RequestBody CustomerSaveDTO customerSaveDTO) 
	{
		String id = customerService.addCustomer(customerSaveDTO);
		return id;

	}
	
	@GetMapping(path="/getAllCustomer")
	public List<CustomerDTO> getAllCustomer()
	{
		List<CustomerDTO>allCustomers = customerService.getAllCustomer();
		return allCustomers;

	}

}
