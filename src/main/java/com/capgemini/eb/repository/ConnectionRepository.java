package com.capgemini.eb.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.eb.entity.Connection;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {


}
