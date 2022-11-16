package com.capgemini.eb.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.eb.entity.Bill;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Long> {

	List<Bill> findByUnitsConsumed(int unitsConsumed);

	@Query(value = "SELECT b FROM Bill b WHERE b.billDate BETWEEN :from AND :to")
	public List<Bill> readBillForDateRange(@Param("from") LocalDate from, @Param("to") LocalDate to);

	@Query(value = "SELECT b FROM Bill b WHERE b.reading.connection.consumerNumber = ?1")
	public List<Bill> readBillByConsumerNumber(Long consumerNumber);

	@Query(value = "SELECT b FROM Bill b WHERE b.reading.connection.customer.mobileNumber = ?1")
	public Bill readBillByMobileNumber(Long mobileNumber);

	@Query(value = "SELECT b FROM Bill b WHERE b.reading.connection.customer.email = ?1")
	public Bill readBillByEmail(String email);

//	List<Bill> readBillForDateRange(LocalDate from, LocalDate to);

//	@Query(value = "SELECT b FROM Bill b WHERE b.reading.connection.consumerNumber = ?1")
//	public List<Bill> findBillByConsumerNumber(Long consumerNumber);
//

}
