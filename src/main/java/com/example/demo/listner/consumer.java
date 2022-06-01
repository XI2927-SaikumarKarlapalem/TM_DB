package com.example.demo.listner;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.repo.AccountRepository;
import com.example.demo.repo.BalanceDemo;
import com.example.demo.repo.DemoRepository;
import com.example.demo.repo.entity.Customer;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.example.demo.repo.entity.accounts;
import com.example.demo.repo.entity.balances;

@Service
public class consumer {
	@Autowired
	DemoRepository cs;
	@Autowired
	AccountRepository ar;
	
	
	@Autowired
	BalanceDemo bd;
	

	JSONObject json;

	@KafkaListener(topics = {
			"vault.api.v1.customers.customer.created" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void customer(String message)

	{

		System.out.println(message);
		JSONParser parser = new JSONParser();

		try {
			json = (JSONObject) parser.parse(message);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JSONObject customer = (JSONObject) json.get("customer");
		JSONObject customer_details = (JSONObject) customer.get("customer_details");
		JSONObject technical_metadata = (JSONObject) json.get("technical_metadata");

		String title = (String) customer_details.get("title");
		String first_name = (String) customer_details.get("first_name");
		String middle_name = (String) customer_details.get("middle_name");
		String last_name = (String) customer_details.get("last_name");
		String dob = (String) customer_details.get("dob");
		String gender = (String) customer_details.get("gender");
		String nationality = (String) customer_details.get("nationality");
		String email_address = (String) customer_details.get("email_address");
		String mobile_phone_number = (String) customer_details.get("mobile_phone_number");
		String home_phone_number = (String) customer_details.get("home_phone_number");
		String business_phone_number = (String) customer_details.get("business_phone_number");
		String contact_method = (String) customer_details.get("contact_method");
		String country_of_residence = (String) customer_details.get("country_of_residence");
		String country_of_taxation = (String) customer_details.get("country_of_taxation");
		String accessibility = (String) customer_details.get("accessibility");
		String external_customer_id = (String) customer_details.get("external_customer_id");

		String event_id = (String) technical_metadata.get("event_id");
		String capture_timestamp = (String) technical_metadata.get("capture_timestamp");
		String id = (String) customer.get("id");
		String status = (String) customer.get("status");

		Customer c = new Customer();
		c.setAccessibility(accessibility);
		c.setBusiness_phone_number(business_phone_number);
		c.setCapture_time_stamp(capture_timestamp);
		c.setContact_method(contact_method);
		c.setCountry_of_residence(country_of_residence);
		c.setCountry_of_taxation(country_of_taxation);
		c.setDob(dob);
		c.setEvent_id(event_id);
		c.setExternal_customer_id(external_customer_id);
		c.setFirst_name(first_name);
		c.setGender(gender);
		c.setHome_phone_number(home_phone_number);
		c.setId(id);
		c.setLast_name(last_name);
		c.setMiddle_name(middle_name);
		c.setMobile_phone_number(mobile_phone_number);
		c.setNationality(nationality);
		c.setStatus(status);
		c.setTitle(title);
		c.setEmail_address(email_address);
		 boolean isExists = cs.existsByIdIgnoreCase(c.getId());
	        if (!isExists) {
		cs.save(c);

	}
	        
	        
	        
}

	@KafkaListener(topics = {
			"vault.api.v1.accounts.account.created" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
	public void accounts(String message) throws ParseException

	{

		System.out.println(message);
		
		
		JSONParser parser = new JSONParser();
		JSONObject acc;
		 acc= (JSONObject) parser.parse(message);
		
		 JSONObject account=(JSONObject) acc.get("account");
		 JSONObject instance_param=(JSONObject) account.get("instance_param_vals");
		 System.out.println("here are the instance_param_vals"+instance_param);
		 JSONObject technical_metadata=(JSONObject) acc.get("technical_metadata");
		 JSONObject accounting=(JSONObject) account.get("accounting");
		 
		 String id=(String) account.get("id");
		    String account_name=(String) account.get("name");
		    String product_id=(String) account.get("product_id");
		  String  product_version_id=(String) account.get("product_version_id");
		  String status=(String) account.get("status");
		    String opening_timestamp=(String) account.get("opening_timestamp");
		    String closing_timestamp=(String) account.get("closing_timestamp");
//		String stakeholder_ids=(String) account.get("stakeholder_ids");
		    String arranged_overdraft_limit=(String) instance_param.get("arranged_overdraft_limit");
		      String autosave_savings_account=(String) instance_param.get("autosave_savings_account");
		      String daily_atm_withdrawal_limit=(String) instance_param.get("daily_atm_withdrawal_limit");
		      String interest_application_day=(String) instance_param.get("interest_application_day");
		      String unarranged_overdraft_limit=(String) instance_param.get("unarranged_overdraft_limit");
		      String tside=(String) accounting.get("tside");
		      String event_id=(String) technical_metadata.get("event_id");
		      String capture_timestamp=(String) technical_metadata.get("capture_timestamp");
		 
		 
		accounts act=new accounts();
		
		act.setAccount_name(account_name);
		act.setArranged_overdraft_limit(unarranged_overdraft_limit);
		act.setAutosave_savings_account(autosave_savings_account);
		act.setCapture_timestamp(capture_timestamp);
		act.setClosing_timestamp(closing_timestamp);
		act.setDaily_atm_withdrawal_limit(daily_atm_withdrawal_limit);
		act.setEvent_id(event_id);
		act.setId(id);
		act.setInterest_application_day(interest_application_day);
		act.setOpening_timestamp(opening_timestamp);
		act.setProduct_id(product_id);
		act.setProduct_version_id(product_version_id);
		act.setProduct_version_id(product_version_id);
//		act.setStakeholder_ids(stakeholder_ids);
		act.setStatus(status);
		act.setTside(tside);
		act.setUnarranged_overdraft_limit(unarranged_overdraft_limit);
		act.setArranged_overdraft_limit(arranged_overdraft_limit);
		
		
		 boolean isExists = ar.existsByIdIgnoreCase(act.getId());
	        if (!isExists) {
		
		ar.save(act);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	}
 
	   @KafkaListener(topics = {
				"vault.core_api.v1.balances.balance.events" }, groupId = "\"#{T(java.util.UUID).randomUUID().toString()}\"")
		public void balance(String message) throws ParseException

		{

			System.out.println(message);
			
			
			JSONParser parser = new JSONParser();
			JSONObject bal;
			 bal= (JSONObject) parser.parse(message);
			 
			 
			 
			 
			 JSONObject balance_created=(JSONObject) bal.get("balance_created");
			 JSONObject ba=(JSONObject) balance_created.get("balance");
			 
			 
			 
			 String id=(String) ba.get("id");
			    String account_id=(String) ba.get("account_id");
			    String account_address=(String) ba.get("account_address");
			    String phase=(String) ba.get("phase");
			    String asset=(String) ba.get("asset");
			    String denomination=(String) ba.get("denomination");
			    String posting_instruction_batch_id=(String) ba.get("posting_instruction_batch_id");
			    String update_posting_instruction_batch_id=(String) ba.get("update_posting_instruction_batch_id");
			   String value_time=(String) ba.get("value_time");
			    String amount=(String) ba.get("amount");
			    String total_debit=(String) ba.get("total_debit");
			    String total_credit=(String) ba.get("total_credit");
			    	String event_id=(String) bal.get("event_id");
			    	  String timestamp=(String) bal.get("timestamp");
			    	  
			    	  String change_id=(String) bal.get("change_id");
			 
			 
			 balances b=new balances();
			 b.setAccount_address(account_address);
			 b.setAccount_id(account_id);
			 b.setAmount(amount);
			 b.setAsset(asset);
			 b.setChange_id(change_id);
			 b.setDenomination(denomination);
			 b.setEvent_id(event_id);
			 b.setId(id);
			 b.setPhase(phase);
			 b.setPosting_instruction_batch_id(posting_instruction_batch_id);
			 b.setTimestamp(timestamp);
			 b.setTotal_credit(total_credit);
			 b.setTotal_debit(total_debit);
			 b.setUpdate_posting_instruction_batch_id(update_posting_instruction_batch_id);
			 b.setValue_time(value_time);
		
			 boolean isExists = bd.existsByIdIgnoreCase(b.getId());
		        if (!isExists) {
			bd.save(b);
			 
			 
		}
	
	
	
		}
	
	
	
}
