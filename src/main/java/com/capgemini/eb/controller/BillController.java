package com.capgemini.eb.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.eb.entity.Bill;
import com.capgemini.eb.exceptions.*;
import com.capgemini.eb.service.BillServiceImp;


@RestController
public class BillController {
	
	@Autowired
	BillServiceImp billServ;
	
	Logger logger = LogManager.getLogger();
	
	
	
	@PostMapping("/bill/addBill")
	ResponseEntity<Bill> addBill(@Valid @RequestBody Bill bill) {
		System.out.println(bill);
		logger.debug(bill);
		Bill newBill = billServ.addBill(bill);
		System.out.println(newBill);
		logger.debug(newBill);
		ResponseEntity<Bill> response = new ResponseEntity<>(newBill, HttpStatus.CREATED); // 201 Created
		return response;
	};
	
	
	
	@GetMapping("/getAllbill")
	public List<Bill> getAllBill() {
		logger.info("getAllBill"); // in normal block
//		LOG.debug("getAllEmps"); // in debug mode 
		return billServ.getAllBill();
	}
	
	@GetMapping("/getBillbyId/{billId}")
	public ResponseEntity<Bill>getBillById(@PathVariable(name = "billId")Long billId) throws NoSuchConnectionException {
		logger.info("getBillById");
		Bill bill = billServ.getBillById(billId); 
		logger.info(bill.toString());

		logger.info("Bill available in DB");
		ResponseEntity<Bill> response = new ResponseEntity<Bill>(bill,HttpStatus.OK);
		return response;
	}
	
	@GetMapping(path = "/viewBillByConsumerNumber/{consumerNumber}")
	public ResponseEntity<Bill> viewBillByConsumerNumber(@PathVariable(name = "consumerNumber")Long consumerNumber) throws NoSuchConnectionException {
		logger.info("viewBillByConsumerNumber");
		List<Bill> bill= billServ.viewBillByConsumerNumber(consumerNumber); 

		logger.info("This bill is available in the database ");
		ResponseEntity<Bill> response = new ResponseEntity<Bill>((Bill) bill.get(0), HttpStatus.OK);
		return response;
	}

	

	@GetMapping("/viewBillByMobileNumber/{mobileNumber}")
	public ResponseEntity<Bill> viewBillByMobileNumber(@PathVariable(name = "mobileNumber")long mobileNumber) throws NoSuchCustomerException {
		logger.info("viewBillByMobileNumber");
		Bill bill = billServ.viewBillByMobileNumber(mobileNumber);
		logger.info("Bill DB");
		ResponseEntity<Bill> response = new ResponseEntity<Bill>(bill, HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping("/viewBillByEmail/{email}")
	public ResponseEntity<Bill> viewBillByEmail(@PathVariable(name = "email")String email) throws NoSuchCustomerException, NoSuchEmailException {
		logger.info("viewBillByEmail");
		Bill bill = billServ.viewBillByEmail(email);
		logger.info("Bill in DB");
		ResponseEntity<Bill> response = new ResponseEntity<Bill>(bill, HttpStatus.OK);
		return response;
	}
	
	
	
	@GetMapping(path = "/getbydate/from:{from}/to:{to}")
	public ResponseEntity<List<Bill>> readBillForDateRange(@PathVariable("from") String from,
			@PathVariable("to") String to) throws NoSuchDateRangeException {
		logger.info("readBillForDateRange");
		  
	        LocalDate fromDate = LocalDate.parse(from, DateTimeFormatter.ISO_DATE);
	        LocalDate toDate = LocalDate.parse(to, DateTimeFormatter.ISO_DATE);		  
		  
		ResponseEntity<List<Bill>> response = null;
		//List<Bill> list = billServ.viewBillForDateRange(from, to);
		List<Bill> list = billServ.viewBillForDateRange(fromDate, toDate);
		response = new ResponseEntity<List<Bill>>(list, HttpStatus.OK);
		return response;
		
	}
}
