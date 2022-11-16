package com.js.controller;

import com.js.dao.ProductCrud;
import com.js.dto.Product;

public class UpdatePBI {

	public static void main(String[] args) {
		Product p=new Product();
		p.setBrand("Realme");
		p.setName("Phone");
		p.setQuantity(67);
		p.setPrice(23999);
		
		ProductCrud pc=new ProductCrud();
		int a=pc.updatePBI(5, p);
		if(a>0)
		{
			System.out.println("Updated Successfully");
			
		}else{
			System.out.println("Failed");
		}
	}
}
