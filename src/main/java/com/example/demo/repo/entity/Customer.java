package com.example.demo.repo.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name="vault.api.v1.customers.customer.created")
@Data
public class Customer {





@Id
public String id;	
public String status;
public String capture_time_stamp;


		
		   @Column(name="title")
	    public String title;
		   @Column(name="first_name")
	    public String first_name;
		   @Column(name="middle_name")
	    public String middle_name;
		   @Column(name="last_name")
	    public String last_name;
		   @Column(name="dob")
	    public String dob;
		   @Column(name="gender")
	    public String gender;
		   @Column(name="nationality")
	    public String nationality;
		   @Column(name="moboile_phone_number")
	    public String mobile_phone_number;
		   @Column(name="home_phone_number")
	    public String home_phone_number;
		   @Column(name="business_phone_number")
	    public String business_phone_number;
		   @Column(name="contact_method")
	    public String contact_method;
		   @Column(name="country_of_residence")
	    public String country_of_residence;
		   @Column(name="country_of_taxation")
	    public String country_of_taxation;
		   @Column(name="accessibility")
	    public String accessibility;
		   @Column(name="external_customer_id")
	    public String external_customer_id;
		   public String email_address;
	

	


		   @Column(name="event_id")
	    public String event_id;
	


}
