package com.js.controller;

import java.util.ArrayList;

import com.js.dao.ProductCrud;
import com.js.dto.Product;

public class GetAllProduct {

	public class getAllProducts {

		public static void main(String[] args) {
			ProductCrud pc=new ProductCrud();
			ArrayList<Product> p2 =pc.getAllProducts();
			if(p2.size()>0) //size method of ArrayList
			{
				for(Product p:p2)
				{
					System.out.println(p);
				}
			}
			else
			{
				System.out.println("No products");
			}

		}
}
}
