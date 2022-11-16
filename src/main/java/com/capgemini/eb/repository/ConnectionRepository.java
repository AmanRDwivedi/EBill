package com.capgemini.eb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.eb.entity.Connection;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {

	// "SELECT b FROM Connection b WHERE b.address.pincode = ?
	// @Query(value="SELECT * FROM connection c join address a on c.conn_add_fk =
	// a.address_id WHERE a.pincode", nativeQuery=true)
	@Query(value = "SELECT b FROM Connection b WHERE b.address.pincode = ?1")
	public List<Connection> readConnectionByPincode(Long pincode);

	// read/get
	@Query(value = "SELECT b FROM Connection b WHERE b.address.village = ?1")
	public List<Connection> readConnectionByVillage(String village);

	@Query(value = "SELECT b FROM Connection b WHERE b.address.taluka = ?1")
	public List<Connection> readConnectionByTaluka(String taluka);

	@Query(value = "SELECT b FROM Connection b WHERE b.address.district = ?1")
	public List<Connection> readConnectionByDistrict(String district);

	@Query(value = "SELECT b FROM Connection b WHERE b.connectionStatus = false AND b.address.district = ?1")
	public List<Connection> readIConnectionByDistrict(String district);

	@Query(value = "SELECT b FROM Connection b WHERE b.connectionStatus = false AND b.address.village = ?1")
	public List<Connection> readIConnectionByVillage(String village);

	@Query(value = "SELECT b FROM Connection b WHERE b.connectionStatus = false AND b.address.taluka = ?1")
	public List<Connection> readIConnectionByTaluka(String taluka);

	@Query(value = "SELECT b FROM Connection b WHERE b.connectionStatus = false AND b.address.pincode = ?1")
	public List<Connection> readIConnectionByPincode(Long pincode);

}
