package com.js.controller;

import com.js.dao.CustomerCrud;
import com.js.dto.Customer;

public class GetCBI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerCrud cc=new CustomerCrud();
		Customer c=cc.getCBI(1);
		if(c!=null)
		{
			System.out.println(c);
		}
		else
		{
			System.out.println("No product with given id");
		}
		

	}

}
