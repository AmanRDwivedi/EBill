package com.capgemini.eb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.capgemini.eb.entity.Connection;
import com.capgemini.eb.exceptions.NoSuchConnectionException;
import com.capgemini.eb.service.IConnectionService;

@RestController
public class ConnectionController {

	Logger logger = LogManager.getLogger();

	@Autowired
	IConnectionService connectionServ;

	// Delete after Integration
	// Trial Function
	@PostMapping("/addConnection")
	ResponseEntity<Connection> addConnection(@RequestBody Connection connection) {
		System.out.println(connection);
		logger.info(connection); // debug
		Connection newCon = connectionServ.addConnection(connection);
		System.out.println(newCon);
		logger.info(newCon); // debug
		ResponseEntity<Connection> response = new ResponseEntity<>(newCon, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("getConnection/all")
	public List<Connection> getAllConnection() {
		logger.info("getAllConnection"); // in normal block
		logger.debug("getAllConnection"); // in debug mode
		return connectionServ.getAllConnection();
	}

	@GetMapping("/id/{connectionId}")
	public ResponseEntity<Connection> getConnectionById(@PathVariable(name = "connectionId") Long connectionId)
			throws NoSuchConnectionException {
		logger.info("getConnectionById");
		Connection connection = connectionServ.getConnectionById(connectionId);
		logger.info(connection.toString());

		logger.info("This connection is available in the database.");
		ResponseEntity<Connection> response = new ResponseEntity<Connection>(connection, HttpStatus.OK);
		return response;
	}

	@PutMapping("/modifyConnection")
	public Connection updateConnection(@RequestBody Connection connection) throws NoSuchConnectionException {
		System.out.println("Controller updateConnection");
		return connectionServ.modifyConnection(connection);
	}

	@GetMapping("/getActiveConnectionbypincode/{pincode}")
	public ResponseEntity<List<Connection>> getConnectionsByPincode(@PathVariable(name = "pincode") long pincode)
			throws NoSuchConnectionException {
		logger.info("getConnectionByPincode");
		List<Connection> connection = connectionServ.findActiveConnectionsByPincode(pincode);
		logger.info("This connections is available in the database.");
		ResponseEntity<List<Connection>> response = new ResponseEntity<List<Connection>>((List<Connection>) connection,
				HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getInActiveConnectionbypincode/{pincode}")
	public ResponseEntity<List<Connection>> getInactiveConnectionsByPincode(@PathVariable(name = "pincode") long pincode)
			throws NoSuchConnectionException {
		logger.info("getConnectionByPincode");
		List<Connection> connection = connectionServ.findInactiveConnectionsByPincode(pincode);
		logger.info("This connections is available in the database.");
		ResponseEntity<List<Connection>> response = new ResponseEntity<List<Connection>>((List<Connection>) connection,
				HttpStatus.OK);
		return response;
	}

	@GetMapping("/getActiveConnectionbyVillage/{village}")
	public ResponseEntity<List<Connection>> getAConnectionByVillage(@PathVariable(name = "village") String village)
			throws NoSuchConnectionException {
		logger.info("getConnectionByVillagee");
		List<Connection> connection = connectionServ.findActiveConnectionsByVillage(village);
		logger.info("This connections is available in the database.");
		ResponseEntity<List<Connection>> response = new ResponseEntity<List<Connection>>((List<Connection>) connection,
				HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getInactiveConnectionbyVillage/{village}")
	public ResponseEntity<List<Connection>> getIConnectionByVillage(@PathVariable(name = "village") String village)
			throws NoSuchConnectionException {
		logger.info("getConnectionByVillagee");
		List<Connection> connection = connectionServ.findInactiveConnectionsByVillage(village);
		logger.info("This connections is available in the database.");
		ResponseEntity<List<Connection>> response = new ResponseEntity<List<Connection>>((List<Connection>) connection,
				HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping("/getActiveConnectionbyTaluka/{taluka}")
	public ResponseEntity<List<Connection>> getConnectionByTaluka(@PathVariable(name = "taluka") String taluka)
			throws NoSuchConnectionException {
		logger.info("getConnectionByVillagee");
		List<Connection> connection = connectionServ.findActiveConnectionsByTaluka(taluka);
		logger.info("This connections is available in the database.");
		ResponseEntity<List<Connection>> response = new ResponseEntity<List<Connection>>((List<Connection>) connection,
				HttpStatus.OK);
		return response;
	}
	@GetMapping("/getInactiveConnectionbyTaluka/{taluka}")
	public ResponseEntity<List<Connection>> getIConnectionByTaluka(@PathVariable(name = "taluka") String taluka)
			throws NoSuchConnectionException {
		logger.info("getConnectionByVillagee");
		List<Connection> connection = connectionServ.findInactiveConnectionsByTaluka(taluka);
		logger.info("This connections is available in the database.");
		ResponseEntity<List<Connection>> response = new ResponseEntity<List<Connection>>((List<Connection>) connection,
				HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getActiveConnectionbyDistrict/{district}")
	public ResponseEntity<List<Connection>> getConnectionByDistrict(@PathVariable(name = "district") String district)
			throws NoSuchConnectionException {
		logger.info("getConnectionByVillagee");
		List<Connection> connection = connectionServ.findActiveConnectionsByDistrict(district);
		logger.info("This connections is available in the database.");
		ResponseEntity<List<Connection>> response = new ResponseEntity<List<Connection>>((List<Connection>) connection,
				HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getInactiveConnectionbyDistrict/{district}")
	public ResponseEntity<List<Connection>> getInactiveConnectionByDistrict(@PathVariable(name = "district") String district)
			throws NoSuchConnectionException {
		logger.info("getConnectionByVillagee");
		List<Connection> connection = connectionServ.findInactiveConnectionsByDistrict(district);
		logger.info("This connections is available in the database.");
		ResponseEntity<List<Connection>> response = new ResponseEntity<List<Connection>>((List<Connection>) connection,
				HttpStatus.OK);
		return response;
	}
	
	//Sortoing
	@GetMapping("/Connection/sort/{sortBy}")
 	ResponseEntity<List<Connection>> getAllConnectionInSortingOrder(@PathVariable("sortBy") String sortBy) {
 		List<Connection> connection = connectionServ.getAllEmployeesInSortingOrder(sortBy);
 		return new ResponseEntity<>(connection, HttpStatus.OK);
 	}
	
	// Pagination
	 	@GetMapping("/connection/pagination/{offset}/{pageSize}")
	 	ResponseEntity<Page<Connection>> getAllConnectionWithPagination(@PathVariable("offset") int offset,
	 			@PathVariable("pageSize") int pageSize) {
	 		Page<Connection> connection =connectionServ.getAllConnectionWithPagination(offset, pageSize);
	 		return new ResponseEntity<>(connection, HttpStatus.OK);
	 	}
	
	/*
	 *

 	// Pagination & Sorting
 	// ex: http://localhost:8080/employees/paginationAndSort/0/3/empId
 	@GetMapping("/employee/paginationAndSort/{offset}/{pageSize}/{field}")
 	ResponseEntity<Page<Employee>> getAllEmployeesWithPaginationAndSorting(@PathVariable("offset") int offset,
 			@PathVariable("pageSize") int pageSize, @PathVariable("field") String field) {
 		Page<Employee> employees = empServ.getAllEmployeesWithPaginationAndSorting(offset, pageSize, field);
 		return new ResponseEntity<>(employees, HttpStatus.OK);
 	}
	
}
	 */

}
