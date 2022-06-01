package com.example.demo.repo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="vault.core_api.v1.balances.balance.events")
@Data
public class balances {
	
	
	@Id
	String id;
    String account_id;
    String account_address;
    String phase;
    String asset;
    String denomination;
    String posting_instruction_batch_id;
    String update_posting_instruction_batch_id;
   String value_time;
    String amount;
    String total_debit;
    String total_credit;
    	String event_id;
    	  String timestamp;
    	  String change_id;

}
