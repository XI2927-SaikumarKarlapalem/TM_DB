package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.repo.entity.balances;

public interface BalanceDemo extends JpaRepository<balances,String> {

	boolean existsByIdIgnoreCase(String id);

}
