package com.capgemini.eb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;

import com.capgemini.eb.entity.Connection;
import com.capgemini.eb.entity.Customer;
import com.capgemini.eb.exceptions.*;
import com.capgemini.eb.repository.ConnectionRepository;

@Service
public class ConnectionServiceImp implements IConnectionService {

	@Autowired
	ConnectionRepository connectionRepo;

	Logger logger = LogManager.getLogger();

	@Override
	public List<Connection> getAllConnection() {
		System.out.println("Service getAllConnections");
		return connectionRepo.findAll();
	}

	@Override
	public Connection addConnection(Connection conn) {
		Connection newconn = connectionRepo.save(conn);
		return newconn;
	}

//same as add
	@Override
	public Connection newConnectionRequest(Connection connection) throws NoSuchConnectionException {
//		if (customerRepository.existsById(connection.getCustomer().getCustomerId()))
		return connectionRepo.save(connection);
	}


	public Customer searchCustomerByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Connection getConnectionById(Long consumerNumber){
		return connectionRepo.getById(consumerNumber);
	}

	public Connection modifyConnectionAddress(Connection connection) throws NoSuchConnectionException {
		if (connectionRepo.existsById(connection.getConnectionId())) {
			logger.info("Service update Connection ");
			return connectionRepo.save(connection);
		} else {
			logger.error("Connection Not Found");
			throw new NoSuchConnectionException("Connection not found");
		}
	}

	@Override
	public Connection modifyConnection(Connection connection) throws NoSuchConnectionException {
		logger.info("Service Modify Connection");
		if (connectionRepo.existsById(connection.getConnectionId())) {
			return connectionRepo.save(connection);
		} else {
			logger.error("Connection does not exist.");
			throw new NoSuchConnectionException(connection.getConnectionId() + "does not exits");
		}
	}

	@Override
	public List<Connection> findActiveConnectionsByVillage(String villageName) throws NoSuchConnectionException {
		logger.info("getConnectionIdByVillage");
		List<Connection> connection = connectionRepo.readConnectionByVillage(villageName);
		if (!connection.isEmpty()) {
			logger.info("Connection is available.");
			return connection;
		} else {
			logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(villageName + " this connection is not found.");
		}
	}

	@Override
	public List<Connection> findActiveConnectionsByTaluka(String taluka) throws NoSuchConnectionException {
		logger.info("getConnectionIdByVillage");
		List<Connection> connection = connectionRepo.readConnectionByTaluka(taluka);
		if (!connection.isEmpty()) {
			logger.info("Connection is available.");
			// List<Connection> con = (List<Connection>) connection;
			return connection;
		} else {
			logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(" this connection is not found. for" + taluka);
		}
	}

	@Override
	public List<Connection> findActiveConnectionsByDistrict(String districtName) throws NoSuchConnectionException {
		logger.info("getConnectionIdByVillage");
		List<Connection> connection = connectionRepo.readConnectionByDistrict(districtName);
		if (!connection.isEmpty()) {
			logger.info("Connection is available.");
			// List<Connection> con = (List<Connection>) connection;
			return connection;
		} else {
			logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(" connection is not found for " + districtName);
		}
	}

	@Override
	public List<Connection> findInactiveConnectionsByVillage(String villageName) throws NoSuchConnectionException {
		logger.info("getConnectionIdByVillage");
		List<Connection> connection = connectionRepo.readIConnectionByVillage(villageName);
		if (!connection.isEmpty()) {
			logger.info("Connection is available.");
			// List<Connection> con = (List<Connection>) connection;
			return connection;
		} else {
			logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(villageName + " this connection is not found.");
		}
	}
	
	@Override
	public List<Connection> findInactiveConnectionsByTaluka(String taluka) throws NoSuchConnectionException {
		logger.info("getConnectionIdByVillage");
		List<Connection> connection = connectionRepo.readIConnectionByTaluka(taluka);
		if (!connection.isEmpty()) {
			logger.info("Connection is available.");
			// List<Connection> con = (List<Connection>) connection;
			return connection;
		} else {
			logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(" this connection is not found. for" + taluka);
		}
	}

	@Override
	public List<Connection> findActiveConnectionsByPincode(long pincode) throws NoSuchConnectionException {
		logger.info("getConnectionIdByPincode");
		List<Connection> connection = connectionRepo.readConnectionByPincode(pincode);
		if (!connection.isEmpty()) {
			logger.info("Connection is available.");
			// List<Connection> con = (List<Connection>) connection;
			return connection;
		} else {
			logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(pincode + " this connection is not found.");
		}
	}

	@Override
	public List<Connection> findInactiveConnectionsByPincode(Long pincode) throws NoSuchConnectionException {
		logger.info("getConnectionIdByPincode");
		List<Connection> connection = connectionRepo.readIConnectionByPincode(pincode);
		if (!connection.isEmpty()) {
			logger.info("Connection is available.");
			// List<Connection> con = (List<Connection>) connection;
			return connection;
		} else {
			logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(pincode + " this connection is not found.");
		}
	}



	@Override
	public List<Connection> findInactiveConnectionsByDistrict(String districtName) throws NoSuchConnectionException {
		logger.info("getConnectionIdByVillage");
		List<Connection> connection = connectionRepo.readIConnectionByDistrict(districtName);
		if (!connection.isEmpty()) {
			logger.info("Connection is available.");
			// List<Connection> con = (List<Connection>) connection;
			return connection;
		} else {
			logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(" connection is not found for " + districtName);
		}
	}
	 @Override
		public List<Connection> getAllEmployeesInSortingOrder(String sortBy) {
			// Sorting in asc order
			List<Connection> connectionlist = connectionRepo.findAll(Sort.by(Direction.ASC, sortBy));

			// Sorting in desc order
			// List<Connection> employeeList = empRepo.findAll(Sort.by(Direction.DESC,
			// sortBy));

			return connectionlist;

		}
	
	
		@Override
		public Page<Connection> getAllConnectionWithPagination(int offset, int pageSize) {
			Page<Connection> connection = connectionRepo.findAll(PageRequest.of(offset, pageSize));
			return connection;
		}
	 
	 
	/*
	 * 
	 * // Pagination
	// ex : http://localhost:8080/employee/pagination/0/2 - 1st page, 2 records
	// http://localhost:8080/employee/pagination/1/2 - 2nd page, 2 records
	@Override
	public Page<Connection> getAllEmployeesWithPagination(int offset, int pageSize) {
		Page<Connection> connection = empRepo.findAll(PageRequest.of(offset, pageSize));
		return connection;
	}

	// Pagination & Sorting
	@Override
	public Page<Employee> getAllEmployeesWithPaginationAndSorting(int offset, int pageSize, String field) {
		Page<Employee> employees = empRepo
				.findAll(PageRequest.of(offset, pageSize).withSort(Sort.Direction.ASC, field));
		return employees;
	}
	
	/*
	 * @Override
	public List<Connection> getAllEmployeesInSortingOrder(String sortBy) {
		// Sorting in asc order
		List<Connection> connectionlist = connectionRepo.findAll(Sort.by(Direction.ASC, sortBy));

		// Sorting in desc order
		// List<Connection> employeeList = empRepo.findAll(Sort.by(Direction.DESC,
		// sortBy));

		return connectionlist;

	}
	 */
	
	
	
//	@Override
//	public List<Connection> findInactiveConnectionsByDistrict(String districtName) throws NoSuchConnectionException {
//		logger.info("getConnectionIdByVillage");
//		List<Connection> connectionList = connectionRepo.readConnectionByDistrict(districtName);
//		List<Connection> newconnect = new ArrayList<Connection>();
//		for(Connection c : connectionList ) {
//			if(c.isConnectionStatus() == true)
//				newconnect.add(c);
//		}
//		if (!newconnect.isEmpty()) {
//	
//			logger.info("Connection is available.");
//			// List<Connection> con = (List<Connection>) connection;
//			return newconnect;
//		} else {
//			logger.error("connection is NOT available.");
//			throw new NoSuchConnectionException(" connection is not found for " + districtName);
//		}
	}

