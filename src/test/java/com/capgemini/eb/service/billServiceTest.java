package com.capgemini.eb.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.eb.entity.Bill;
import com.capgemini.eb.exceptions.NoSuchConnectionException;
import com.capgemini.eb.exceptions.NoSuchCustomerException;
import com.capgemini.eb.exceptions.NoSuchEmailException;


@SpringBootTest
class billServiceTest {
	
	@Autowired
	BillServiceImp billserv;
	
	
	/*
	 * 	@Test
	@Order(3)
	void getAllemployee() {
		List<Employee> empl = empserv.getAllEmployees();
		int noEmp =empl.size()	;
		assertEquals(4, noEmp);
	}
	 */
	@Test
	void getAllBillIdTest() {
		List<Bill> bill = billserv.getAllBill();
		int noofEnntries = bill.size();
		assertEquals(6, noofEnntries);	
	}
	
	@Test
	@Tag("get")
	void getBillByIdTest() throws NoSuchConnectionException {	
		Bill bill = billserv.getBillById(19);
		assertEquals(456, bill.getBillAmount());
		assertEquals(2022-11-14, bill.getBillDueDate());
		assertEquals("Aman", bill.getReading().getConnection().getCustomer().getFirstName());
	}

	
	@Test
	@Tag("get")
	void getBillByEmailTest() throws NoSuchCustomerException, NoSuchEmailException {
		Bill bill = billserv.viewBillByEmail("aman@hmail.com");
		assertEquals(19, bill.getBillId());
		assertEquals("2022-11-14", bill.getBillDate());
		assertEquals("Aman", bill.getReading().getConnection().getCustomer().getFirstName());
		
	}
	
	@Test
	void hhhTest() throws NoSuchCustomerException{
		Bill bill = billserv.viewBillByMobileNumber((long) 987654321);
		assertEquals(19, bill.getBillId());
	}
	


	
	
	
}
