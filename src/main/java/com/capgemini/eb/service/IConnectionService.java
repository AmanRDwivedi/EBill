package com.capgemini.eb.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.eb.entity.Connection;
import com.capgemini.eb.entity.Customer;
import com.capgemini.eb.exceptions.*;

public interface IConnectionService {
	public Connection newConnectionRequest(Connection newConnection) throws NoSuchConnectionException;
	public Customer searchCustomerByConsumerNumber(Long consumerNumber)throws NoSuchCustomerException;
	public Connection modifyConnectionAddress(Connection connection) throws NoSuchConnectionException;
	// suspend or activate connection
	public Connection modifyConnection(Connection connection) throws NoSuchConnectionException;
	public List<Connection> findActiveConnectionsByVillage(String villageName)throws NoSuchConnectionException;
	public List<Connection> findActiveConnectionsByTaluka(String taluka)throws NoSuchConnectionException;
	public List<Connection> findActiveConnectionsByDistrict(String districtName)throws NoSuchConnectionException;
	public List<Connection> findActiveConnectionsByPincode(long pincode)throws NoSuchConnectionException;
	
	public List<Connection> findInactiveConnectionsByVillage(String villageName)throws NoSuchConnectionException;
	public List<Connection> findInactiveConnectionsByTaluka(String taluka)throws NoSuchConnectionException;
	public List<Connection> findInactiveConnectionsByDistrict(String districtName)throws NoSuchConnectionException;
	public List<Connection> findInactiveConnectionsByPincode(Long pincode)throws NoSuchConnectionException;
	
	
	public Connection getConnectionById(Long connectionId);
	List<Connection> getAllConnection();
	
	public Connection addConnection(Connection conn);
	List<Connection> getAllEmployeesInSortingOrder(String sortBy);
	
	Page<Connection> getAllConnectionWithPagination(int offset, int pageSize);
	
	

}
