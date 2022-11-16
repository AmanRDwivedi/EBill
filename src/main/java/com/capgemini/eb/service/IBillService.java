package com.capgemini.eb.service;

import java.time.LocalDate;
import java.util.List;

import com.capgemini.eb.entity.Bill;
import com.capgemini.eb.entity.ConnectionType;
import com.capgemini.eb.exceptions.*;

public interface IBillService {

	public List<Bill> getAllBill();

	public Bill getBillById(int i) throws NoSuchConnectionException;

	public List<Bill> viewBillByConsumerNumber(Long consumerNumber)
			throws NoSuchCustomerException, NoSuchConnectionException;

	public Bill viewBillByEmail(String email) throws NoSuchCustomerException, NoSuchEmailException;

	public List<Bill> viewBillForDateRange(LocalDate from, LocalDate to) throws NoSuchDateRangeException;

	public double energyBillCalculator(ConnectionType type, double unitsConsumed);

	public void emailBillToCustomer(Long consumerNumber, String email) throws NoSuchCustomerException;

	Bill addBill(Bill bill);

	Bill viewBillByMobileNumber(Long mobileNumber) throws NoSuchCustomerException;

	Bill getBillById(Long billId) throws NoSuchConnectionException;

}
