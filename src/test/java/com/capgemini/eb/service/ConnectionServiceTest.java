package com.capgemini.eb.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.eb.entity.Connection;
import com.capgemini.eb.exceptions.NoSuchConnectionException;
@SpringBootTest
class ConnectionServiceTest {

	@Autowired
	ConnectionServiceImp conserv;
	
	@Test
	@Tag("get")
	void getConnectionTest() throws NoSuchConnectionException {
		Connection con  = (Connection) conserv.findActiveConnectionsByPincode(400706);
		
		assertEquals(33, con.getConnectionId());
		assertEquals(2022-11-14,con.getApplicationDate() );
		assertEquals(true,con.isConnectionStatus() );
		assertEquals("Aman",con.getCustomer().getFirstName());
		
	}

}
