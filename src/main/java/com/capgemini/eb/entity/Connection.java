package com.capgemini.eb.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Connection {
	
	
	@Id
	@GeneratedValue
	private Long connectionId;
	// should be auto-generated
	private Long consumerNumber;
	
	//One to one connection
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conn_cust_fk")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conn_add_fk")
	private Address address;
	
	@Enumerated(EnumType.STRING)
	private ConnectionType connectionType;
	
	private LocalDate applicationDate;
	private LocalDate connectionDate;
	// connectionStatus will be active or inactive
	private boolean connectionStatus;
	
	
}
