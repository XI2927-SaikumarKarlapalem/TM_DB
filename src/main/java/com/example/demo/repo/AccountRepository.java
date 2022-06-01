package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repo.entity.accounts;

public interface AccountRepository extends JpaRepository<accounts,Integer> {

	boolean existsByIdIgnoreCase(String id);



}
