package com.js.controller;

import java.util.ArrayList;

import com.js.dao.ProductCrud;
import com.js.dto.Product;

public class BtachExecutionOfProduct {

	public static void main(String[] args) {
		ArrayList<Product> products=new ArrayList<>();
		
		Product p=new Product();
		p.setId(5);
		p.setName("Pen");
		p.setBrand("Cello");
		p.setQuantity(9);
		p.setPrice(879);
		
		Product p2=new Product();
		p2.setId(6);
		p2.setName("Pencil");
		p2.setBrand("Cello");
		p2.setQuantity(9);
		p2.setPrice(79);
		
		Product p3=new Product();
		p3.setId(7);
		p3.setName("Eraser");
		p3.setBrand("Cello");
		p3.setQuantity(3);
		p3.setPrice(999);
		
		Product p4=new Product();
		p4.setId(8);
		p4.setName("Pen");
		p4.setBrand("Cello");
		p4.setQuantity(9);
		p4.setPrice(879);
		
		Product p5=new Product();
		p5.setId(9);
		p5.setName("Pen");
		p5.setBrand("Cello");
		p5.setQuantity(9);
		p5.setPrice(879);
		
		Product p6=new Product();
		p6.setId(10);
		p6.setName("Pen");
		p6.setBrand("Cello");
		p6.setQuantity(9);
		p6.setPrice(879);
		
		products.add(p);
		products.add(p2);
		products.add(p3);
		products.add(p4);
		products.add(p5);
		products.add(p6);
		
		ProductCrud pc=new ProductCrud();
		int[] a=pc.batchExecution(products);
		if(a.length>0)
		{
			for(int ar:a) {
				System.out.println(ar);
			}
			System.out.println("Insertion Successful");
		}
		else {
			System.out.println("Failed");
		}
	}

}
