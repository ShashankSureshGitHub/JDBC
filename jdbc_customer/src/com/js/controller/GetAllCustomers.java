package com.js.controller;

import java.util.ArrayList;

import com.js.dao.CustomerCrud;
import com.js.dto.Customer;

public class GetAllCustomers {

		public class getAllCustomers {

			public static void main(String[] args) {
				CustomerCrud cc=new CustomerCrud();
				ArrayList<Customer> c2 =cc.getAllCustomers();
				if(c2.size()>0) //size method of ArrayList
				{
					for(Customer c:c2)
					{
						System.out.println(c);
					}
				}
				else
				{
					System.out.println("No products");
				}

			}
		}
}
