package com.js.controller;

import com.js.dao.ProductCrud;
import com.js.dto.Product;

public class InsertProduct {
	
	public static void main(String [] args)
	{
		Product p=new Product();
		p.setId(5);
		p.setName("Pen");
		p.setBrand("Cello");
		p.setQuantity(9);
		p.setPrice(879);
		
		ProductCrud pc=new ProductCrud();
		int a=pc.insert(p);
		if(a>0)
		{
			System.out.println("Inserted Successfully");
		}
		else
		{
			System.out.println("Failed");
		}
		
	}

}
