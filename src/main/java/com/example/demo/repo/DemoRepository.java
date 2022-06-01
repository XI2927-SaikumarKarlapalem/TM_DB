package com.example.demo.repo;


import java.util.UUID;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.repo.entity.Customer;


@Repository
public interface DemoRepository extends JpaRepository<Customer,String>{

	boolean existsByIdIgnoreCase(String id);


	


}
