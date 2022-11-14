package com.capgemini.eb.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Reading {
	
	@Id
	@GeneratedValue
	private Long readingId;
	private int unitsConsumed;
	private String readingPhoto;
	private LocalDate readingDate;
	private int pricePerUnits;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reading_conn_fk")
	private Connection connection;

	public Connection getConnection() {
		return connection;
	
	}

}
