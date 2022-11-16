package com.js.controller;

import com.js.dao.CustomerCrud;
import com.js.dto.Customer;

public class DeleteCBI {
	public static void main(String[] args) {
		CustomerCrud cc=new CustomerCrud();
		Customer c=cc.getCBI(5);
		if(c!=null)
		{
			int a=cc.deleteCBI(5);
			if(a>0) {
				System.out.println("Deleted Successfully");
			}
			else {
				System.out.println("Deletion Failed");
			}
		}
		else
		{
			System.out.println("Product not present for the given id");
		}
		

	}


}
