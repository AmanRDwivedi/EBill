package com.capgemini.eb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	//Delete after Integration
	//Trial Function
	 @PostMapping("/addConnection")
	    ResponseEntity<Connection> addConnection(@RequestBody Connection connection) {
			System.out.println(connection);
		 logger.info(connection); //debug
	    Connection newCon = connectionServ.addConnection(connection);
	    System.out.println(newCon);
	  logger.info(newCon); //debug
	    ResponseEntity<Connection> response= new ResponseEntity<>(newCon,  HttpStatus.CREATED);  
	        return response; 
	    }

		@GetMapping("/all")
		public List<Connection> getAllConnection() {
		logger.info("getAllConnection"); // in normal block
		logger.debug("getAllConnection"); // in debug mode 
			return connectionServ.getAllConnection();
		}
	 
	 

//			@GetMapping("/getConnection/{customerId}")
//			public ResponseEntity<Connection>getConnectionByCustomerId(@PathVariable(name = "customerId")int customerId) throws NoSuchConnectionException{
//		  			//logger.info("getConnectionById");
//				Connection connection = connectionServ.getConnectionById(customerId); 
//					//logger.info(connection.toString());
//				
//				//logger.info("Connection is available in the database.");
//				ResponseEntity<Connection> response = new ResponseEntity<Connection>(connection,HttpStatus.OK);
//					return response;
//			}
			
	
	
	

    
	   @GetMapping("/id/{connectionId}")
		public ResponseEntity<Connection>getConnectionById(@PathVariable(name = "connectionId")Long connectionId) throws NoSuchConnectionException {
		logger.info("getConnectionById");
			Connection connection = connectionServ.getConnectionById(connectionId); 
			logger.info(connection.toString());
			
			logger.info("This connection is available in the database.");
			ResponseEntity<Connection> response = new ResponseEntity<Connection>(connection,HttpStatus.OK);
			return response;
		}
	   
		
	   @PutMapping("/modifyConnection")
	 	public Connection updateConnection(@RequestBody Connection connection) throws NoSuchConnectionException {
	 		System.out.println("Controller updateConnection");
	 		return connectionServ.modifyConnection(connection);
	 	}
	
	   @GetMapping("/getConnectionbypincode/{pincode}")
		public ResponseEntity<Connection> getConnectionsByPincode(@PathVariable(name = "pincode")long pincode) throws NoSuchConnectionException {
			logger.info("getConnectionByPincode");
			List<Connection> connection = connectionServ.findActiveConnectionsByPincode(pincode); 
			

			logger.info("This connections is available in the database.");
			ResponseEntity<Connection> response = new ResponseEntity<Connection>((Connection) connection,HttpStatus.OK);
			return response;
		}
	   

}
