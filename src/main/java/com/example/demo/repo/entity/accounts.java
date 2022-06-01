package com.example.demo.repo.entity;

import java.lang.reflect.Array;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

import lombok.Data;

@Entity
@Service
@Data
@Table(name="vault.api.v1.accounts.account.created")
public class accounts {
	@Id
	 String id;
	    String account_name;
	    String product_id;
	  String  product_version_id;
	  String status;
	    String opening_timestamp;
	    String closing_timestamp;
	   String stakeholder_ids;
	    String arranged_overdraft_limit;
	      String autosave_savings_account;
	      String daily_atm_withdrawal_limit;
	      String interest_application_day;
	      String unarranged_overdraft_limit;
	      String tside;
	      String event_id;
	      String capture_timestamp;

}
