package com.capgemini.eb.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class Bill {
	@Id
	@GeneratedValue
	private Long billId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bill_read_fk")
	private Reading reading;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "bill_conn_fk")
//	private Connection connection;
//	
	private LocalDate billDate;
	private LocalDate billDueDate;
	@NotEmpty
	private int unitsConsumed;
	private int billAmount;

}
