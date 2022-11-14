package com.capgemini.eb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.eb.dto.CustomerInputDto;
import com.capgemini.eb.dto.CustomerOutputDto;
import com.capgemini.eb.entity.Customer;
import com.capgemini.eb.exceptions.DuplicateCustomerException;
import com.capgemini.eb.repository.ICustomerRepository;

@Service
public class CustomerServiceImp implements ICustomerService  {

	@Autowired
	ICustomerRepository custRepo ;
	


	@Override
	public CustomerOutputDto viewCustomerProfile(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerOutputDto editCustomerProfile(int customerId, CustomerInputDto customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer searchCustomerByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer searchCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer searchCustomerByAadhar(Long aadharNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer searchCustomerByMobile(Long mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> searchCustomerByName(String customerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer registerCustomer(Customer customer) throws DuplicateCustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
