package com.js.controller;

import com.js.dao.ProductCrud;
import com.js.dto.Product;

public class GetProductById {


	public static void main(String args[])
	{
		ProductCrud pc=new ProductCrud();
		Product p=pc.getPBI(1);
		if(p!=null)
		{
			System.out.println(p);
		}
		else
		{
			System.out.println("No product with given id");
		}
		
	}
}
