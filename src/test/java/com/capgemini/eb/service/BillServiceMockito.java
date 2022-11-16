package com.capgemini.eb.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.eb.entity.Bill;
import com.capgemini.eb.exceptions.NoSuchConnectionException;
import com.capgemini.eb.exceptions.NoSuchCustomerException;
import com.capgemini.eb.exceptions.NoSuchEmailException;
import com.capgemini.eb.repository.IBillRepository;

@ExtendWith(SpringExtension.class)
class BillServiceMockito {

	@InjectMocks
	BillServiceImp billserv;
	@MockBean
	IBillRepository billRepo;
	
	// Initialization of mock objects
		@BeforeEach
		void init() {
			MockitoAnnotations.openMocks(this);
		}
	
	
		@Test
	
		void getBillByIdTest() throws NoSuchConnectionException {
			
			Bill bill =new Bill();
			bill.setBillAmount(3000);
		//	bill.setBillDate(2022/11/11);
			bill.setBillId(33L);
			bill.setUnitsConsumed(33);
			
			Mockito.when(billRepo.findById((long) 44)).thenReturn(Optional.of(bill));
			Bill response  = billserv.getBillById(44);
			
			assertEquals(33, response.getBillId());
			assertEquals(33, response.getUnitsConsumed());
			assertEquals(3000, response.getBillAmount());
			
		}
	
	/*
	 * ic class CustomerServiceMockitoTest {
	
	@InjectMocks
	CustomerServiceImpl custServ;
		
	// @MockBean - Creates Mock of a class or interface
	@MockBean
	ICustomerRepository custRepo;
		
	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	/*
	@Test
	void registerCustomerTest() {
		Bill bill = new Bill();
		bill.setCustomerId(5);
		bill.setFirstName("Keerti");
		cust.setAddharNumber(000011112222L);
		cust.setEmail("keerti@gmail.com");
		
		//Mockito.when//(custRepo.save(cust)).thenReturn(cust);
		//Customer testNewCust = custServ.registerCustomer(cust);
	
		assertEquals(5, testNewCust.getCustomerId());
		assertEquals("Keerti", testNewCust.getFirstName());
		assertEquals(000011112222L, testNewCust.getAddharNumber());
		assertEquals("keerti@gmail.com", testNewCust.getEmail());
	}
	 */

}
