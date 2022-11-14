package com.capgemini.eb.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.capgemini.eb.entity.Connection;
import com.capgemini.eb.exceptions.*;
import com.capgemini.eb.repository.ConnectionRepository;

@Service
public class ConnectionServiceImp implements IConnectionService {


	@Autowired
	ConnectionRepository connectionRepo;

	Logger logger = LogManager.getLogger();
	
//----------------------------------------------------------------------------------------	
//--------------------Methods You can delete----------------------------------------------
	
	
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
	
//-------------------------------------------------------------------------------------------	

	@Override
	public Connection newConnectionRequest(Connection connection) throws NoSuchConnectionException {
//		if (customerRepository.existsById(connection.getCustomer().getCustomerId()))
		return connectionRepo.save(connection);
		// throw new NoSuchConnectionException(
		// "customer with customerId " + connection.getCustomer().getCustomerId() + "
		// does not exist.");
	}

//	  if (!connectionRepository.existsById(connection.getConnectionId())) {

//			if (connection.getCustomer() != null )
//				return connectionRepo.save(connection);
//			else if (connectionRepository.existsById(connection.getCustomer().getCustomerId()) )
//				return connectionRepo.save(connection);
//			else
//				throw new NoSuchConnectionException("customer with customerId " + connection.getCustomer().getCustomerId() + " does not exist.");
//		
//	  }
//  else
//			throw new NoSuchConnectionException("connection with connectionId " + connection.getConnectionId() + " already exists.");
//	  	  
//	}

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Connection> findActiveConnectionsByTaluka(String taluka) throws NoSuchConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*
	 * @Override
	public List<Employee> getEmployeeByName(String name) {
		return empRepo.findByEmpName(name);
	}
	 */
	@Override
	public List<Connection> findActiveConnectionsByDistrict(String districtName) throws NoSuchConnectionException {
	//	return connectionRepo.findByDistrict();
	return null;	
		
		}
	


	@Override
	public List<Connection> findInactiveConnectionsByVillage(String villageName) throws NoSuchConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Connection> findInactiveConnectionsByTaluka(String taluka) throws NoSuchConnectionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Connection> findInactiveConnectionsByDistrict(String districtName) throws NoSuchConnectionException {
		// TODO Auto-generated method stub
		return null;
	}
//	@Override
//	public List<Connection> findActiveConnectionsByPincode(long pincode) throws NoSuchConnectionException {
//		logger.info("getConnectionIdByPincode");
//		Optional<Connection> connection = connectionRepo.findById(pincode);
//		Connection con = null;
//		if (connection.isPresent()) {
//			// Logger.info("Connection is available.");
//			Connection con =connection.get();
//			return  con;
//		} else {
//			// Logger.error("connection is NOT available.");
//			throw new NoSuchConnectionException(pincode + " this connection is not found.");
//		}
//		
//		
//	}
	@Override
	public List<Connection> findActiveConnectionsByPincode(long pincode) throws NoSuchConnectionException {
		return null;
	}

	@Override
	public List<Connection> findInactiveConnectionsByPincode(String pincode) throws NoSuchConnectionException {

		return null;
	}

	@Override
	public Connection getConnectionById(Long consumerNumber) throws NoSuchConnectionException {
		// Logger.info("getConnectionIdById");
		Optional<Connection> connection = connectionRepo.findById(consumerNumber);
		if (connection.isPresent()) {
			// Logger.info("Connection is available.");
			return connection.get();
		} else {
			// Logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(consumerNumber + " this connection is not found.");
		}

	}




	
	

}