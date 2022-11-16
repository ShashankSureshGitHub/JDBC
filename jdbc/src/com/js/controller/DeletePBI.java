package com.js.controller;

import com.js.dao.ProductCrud;
import com.js.dto.Product;

public class DeletePBI {

	public static void main(String[] args) {
		ProductCrud pc=new ProductCrud();
		Product p=pc.getPBI(10);
		if(p!=null)
		{
			int a=pc.deletePBI(10);
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
