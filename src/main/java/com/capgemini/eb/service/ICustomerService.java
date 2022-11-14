package com.capgemini.eb.service;

import java.util.List;

import com.capgemini.eb.dto.CustomerInputDto;
import com.capgemini.eb.dto.CustomerOutputDto;
import com.capgemini.eb.entity.Customer;
import com.capgemini.eb.exceptions.DuplicateCustomerException;
import com.capgemini.eb.exceptions.NoSuchCustomerException;

public interface ICustomerService {
	//Abstract methods
		// all methods listed below throws NoSuchCustomerException
		public Customer registerCustomer(Customer customer) throws DuplicateCustomerException; //done
		public CustomerOutputDto viewCustomerProfile(int customerId) throws NoSuchCustomerException; //done
		//partially done (password getting reset)
		public CustomerOutputDto editCustomerProfile(int customerId,CustomerInputDto customer) throws NoSuchCustomerException;
		public Customer searchCustomerByCustomerId(int customerId) throws NoSuchCustomerException; //done
		public Customer searchCustomerByEmail(String email);	//done
		public Customer searchCustomerByAadhar(Long aadharNumber);	//done 
		public Customer searchCustomerByMobile(Long mobile) throws NoSuchCustomerException;	//done 
		public List<Customer> searchCustomerByName(String customerName) throws NoSuchCustomerException; //done 
}
