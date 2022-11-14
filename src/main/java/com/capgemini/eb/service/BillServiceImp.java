package com.capgemini.eb.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.eb.entity.Bill;
import com.capgemini.eb.entity.ConnectionType;
import com.capgemini.eb.exceptions.NoSuchConnectionException;
import com.capgemini.eb.exceptions.NoSuchCustomerException;
import com.capgemini.eb.exceptions.NoSuchDateRangeException;
import com.capgemini.eb.exceptions.NoSuchEmailException;
import com.capgemini.eb.repository.IBillRepository;

@Service
public class BillServiceImp implements IBillService {

	@Autowired
	IBillRepository billRepo;

	Logger logger = LogManager.getLogger();

	@Override
	public Bill addBill(Bill bill) {

		// for adding in db
		Bill newBill = billRepo.save(bill);
		return newBill;
	}

	@Override
	public Bill viewBillByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill viewBillByEmail(String email) throws NoSuchEmailException {
		logger.info("viewBillByEmail");
		Bill billopt = billRepo.readBillByEmail(email);
		if (billopt != null) {
			logger.info("Bill is available");

			// ConnectionType connType =
			// billopt.getReading().getConnection().getConnectionType();
			// double units = billopt.getReading().getUnitsConsumed();
			// billopt.setBillAmount(enrgyBillCalculator(connType, units));
			billopt.setBillAmount(enrgyBillCalculator(billopt));

			return billopt;
		} else {
			logger.info("Bill is not available");
			throw new NoSuchEmailException(email + " This bill is not found");
		}
	}

	@Override
	public void emailBillToCustomer(Long consumerNumber, String email) throws NoSuchCustomerException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Bill> getAllBill() {
		System.out.println("Service getAllBills");
		return billRepo.findAll();
	}

	@Override
	public Bill getBillById(Long billId) throws NoSuchConnectionException {
		logger.info("getConnectionIdById");
		Optional<Bill> bill = billRepo.findById(billId);
		if (bill.isPresent()) {
			logger.info("Connection is available.");
			ConnectionType connType = bill.get().getReading().getConnection().getConnectionType();
			double units = bill.get().getReading().getUnitsConsumed();
			bill.get().setBillAmount(enrgyBillCalculator(bill.get()));

			return bill.get();
		} else {
			logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(billId + " this connection is not found.");
		}

	}

	public int enrgyBillCalculator(Bill bill) {
		//
		ConnectionType connType = bill.getReading().getConnection().getConnectionType();
		double units = bill.getReading().getUnitsConsumed();

		String connection = connType.name();
		int unit = (int) units;
		int calculatedBill = 0;

		switch (connection.toUpperCase()) {
		case "NON_INDUSTRIAL":
			calculatedBill = 4 * unit;
			break;

		case "INDUSTRIAL":
			calculatedBill = 7 * unit;

		case "AGRICULTURAL":
			calculatedBill = 2 * unit;

		}

		return calculatedBill;
	}

	@Override
	public double energyBillCalculator(ConnectionType type, double unitsConsumed) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Bill> viewBillForDateRange(LocalDate from, LocalDate to) throws NoSuchDateRangeException {
		logger.info("viewBillForDateRange");
		List<Bill> billopt = billRepo.readBillForDateRange(from, to);
		if (!billopt.isEmpty()) {
			logger.info("Bill is available.");
			return billopt;
		} else {
			logger.info("Bill is NOT available.");
			throw new NoSuchDateRangeException("There is no bill data from: " + from + " to: " + to);
		}
	}

	@Override
	public Bill viewBillByMobileNumber(Long mobileNumber) throws NoSuchCustomerException {
		logger.info("viewBillByMobileNumber");
		Bill billopt = billRepo.readBillByMobileNumber(mobileNumber);
		if (billopt != null) {
			logger.info("Bill is available.");
			return billopt;
		} else {
			logger.info("Bill is NOT available.");

			throw new NoSuchCustomerException(" This bill with mobile number : " + mobileNumber + "is not found");
		}
	}

}
