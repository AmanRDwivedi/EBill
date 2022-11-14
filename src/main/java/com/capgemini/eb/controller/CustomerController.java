package com.capgemini.eb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.eb.entity.Customer;
import com.capgemini.eb.exceptions.DuplicateCustomerException;
import com.capgemini.eb.exceptions.NoSuchCustomerException;
import com.capgemini.eb.service.ICustomerService;

@RestController
public class CustomerController {
	@Autowired
	ICustomerService custServ;
	
	
	//add new customer
		@PostMapping("/register")
		ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) throws DuplicateCustomerException {
			Customer newCust = custServ.registerCustomer(customer);
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "Customer registered successfully.");
			return new ResponseEntity<>(newCust,headers,HttpStatus.CREATED); // status code 201;	
		}
	
		//get customer by mobile no
		@GetMapping("/searchByMobile/{mobile}")
		ResponseEntity<Customer> searchCustomerByMobile(@PathVariable Long mobile) throws NoSuchCustomerException {
			Customer cust = custServ.searchCustomerByMobile(mobile);
			return new ResponseEntity<>(cust,HttpStatus.OK); // status 200
		}
	
	
}
