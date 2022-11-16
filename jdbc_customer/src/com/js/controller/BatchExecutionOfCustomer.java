package com.js.controller;

import java.util.ArrayList;

import com.js.dao.CustomerCrud;
import com.js.dto.Customer;

public class BatchExecutionOfCustomer {
	
	public static void main(String[] args) {
		ArrayList<Customer> customers=new ArrayList<>();
		
		Customer c=new Customer();
		c.setId(6);
		c.setName("shiv");
		c.setEmail("shivnadar@gmail.com");
		c.setPhone(9456325679l);
		c.setAge(89);
		
		Customer c1=new Customer();
		c1.setId(7);
		c1.setName("Mohan");
		c1.setEmail("mohanadargh@gmail.com");
		c1.setPhone(9456325679l);
		c1.setAge(19);
		
		customers.add(c);
		customers.add(c1);
		
		CustomerCrud cc=new CustomerCrud();
		int[] a=cc.batchExecution(customers);
		if(a.length>0)
		{
			for(int ar:a) {
				System.out.println(ar);
			}
			System.out.println("Insertion Successful");
		}
		else {
			System.out.println("Failed");
		}
	}
	

}
