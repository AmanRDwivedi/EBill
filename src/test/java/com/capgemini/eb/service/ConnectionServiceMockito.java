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

import com.capgemini.eb.entity.Connection;
import com.capgemini.eb.entity.Customer;
import com.capgemini.eb.repository.ConnectionRepository;

@ExtendWith(SpringExtension.class)
class ConnectionServiceMockito {
	
	@InjectMocks
	ConnectionServiceImp conServ;
	
	@MockBean
	ConnectionRepository conRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void addConnection() {
	Customer cust = new Customer();
	cust.setFirstName("Aman");
		Connection con = new Connection();
		con.setConsumerNumber(333l);
		con.setConnectionId(322l);
		con.setConnectionStatus(true);
		con.setCustomer(cust);
		Mockito.when(conRepo.save(con)).thenReturn(con);
		Connection newConn = conServ.addConnection(con);
	
		assertEquals(333, newConn.getConsumerNumber());
		assertEquals(322, newConn.getConnectionId());
		assertEquals("Aman", newConn.getCustomer().getFirstName());
	
	}
	

	@Test
	void getConnection() {
		
		Connection con = new Connection();
		con.setConsumerNumber(333l);
		con.setConnectionId(322l);
		con.setConnectionStatus(true);
	
		Mockito.when(conRepo.findById(322l)).thenReturn(Optional.of(con));
		Connection newConn = conServ.getConnectionById(322l);
	
		assertEquals(333, newConn.getConsumerNumber());
		assertEquals(322, newConn.getConnectionId());
		assertEquals(true, newConn.isConnectionStatus());
	}
	
	
	
	
	
	
	
	


}
