package com.application.backend.Service;

import java.util.List;

import com.application.backend.DTO.CustomerDTO;
import com.application.backend.DTO.CustomerSaveDTO;

public interface CustomerService {

	String addCustomer(CustomerSaveDTO customerSaveDTO);

	List<CustomerDTO> getAllCustomer();

}
