package com.js.controller;

import com.js.dao.CustomerCrud;
import com.js.dto.Customer;

public class UpdateCustomerByID {
	public static void main(String[] args) {
		Customer c=new Customer();
		c.setName("Mohit");
		c.setEmail("Mohitarora@gmail.com");
		c.setPhone(9876543212l);
		c.setAge(27);
		
		CustomerCrud pc=new CustomerCrud();
		int a=pc.updateCBI(5, c);
		if(a>0)
		{
			System.out.println("Updated Successfully");
			
		}else{
			System.out.println("Failed");
		}

}
}
