package com.js.controller;

import com.js.dao.CustomerCrud;
import com.js.dto.Customer;

public class Insert {

	public static void main(String[] args) {
		CustomerCrud cc=new CustomerCrud();
		Customer c=new Customer();
		c.setId(5);
		c.setName("Alia");
		c.setEmail("aliabhattr@gmail.com");
		c.setPhone(8967094123l);
		c.setAge(32);
		int a=cc.insert(c);
		if(a>0)
		{
			System.out.println("Insertion successful");
		}
		else
		{
			System.out.println("Failed");
		}

	}

}
