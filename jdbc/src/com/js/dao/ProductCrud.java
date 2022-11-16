package com.js.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.js.dto.Product;

public class ProductCrud {

	static String url = "jdbc:mysql://localhost:3306/productdatabase";
	static String user = "root";
	static String password = "root1234";
	static Connection connection;

	public int insert(Product p) {
		try {
			String query = "insert into product values(?,?,?,?,?)";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, p.getId());
			preparedStatement.setString(2, p.getName());
			preparedStatement.setString(3, p.getBrand());
			preparedStatement.setInt(4, p.getQuantity());
			preparedStatement.setDouble(5, p.getPrice());
			return preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public Product getPBI(int id)
	{
		String query="select * from product where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setBrand(rs.getString(3));
				p.setQuantity(rs.getInt(4));
				p.setPrice(rs.getDouble(5));
				return p;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return null;
	}
	public int deletePBI(int id)
	{
		String query="delete from product where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Properties p=new Properties();
			FileInputStream fis=new FileInputStream("productdatabaseinfo.properties");
			p.load(fis);
			connection=DriverManager.getConnection(url,p);// Third way of setting connection, that is by using properties;
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setInt(1, id);
			return ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			}catch(SQLException e)
			{
				System.out.println(e);
			}
		}
		return 0;
	}
	
	

	public int updatePBI(int id, Product p) // id to known the row to change, product to be replaced
	{
		String query = "update product set name=?,brand=?,quantity=?,price=? where id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, p.getName());
			ps.setString(2, p.getBrand());
			ps.setInt(3, p.getQuantity());
			ps.setDouble(4, p.getPrice());
			ps.setInt(5, id);
			return ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public ArrayList<Product> getAllProducts() {
		ArrayList<Product> products = new ArrayList<>();
		String query = "select * from product";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setBrand(rs.getString(3));
				p.setQuantity(rs.getInt(4));
				p.setPrice(rs.getDouble(5));
				products.add(p);
			}
			return products;

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public int[] batchExecution(ArrayList<Product> products)
	{
		String query = "insert into product values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=connection.prepareStatement(query);
			for(Product p:products)
			{
				ps.setInt(1, p.getId());
				ps.setString(2, p.getName());
				ps.setString(3, p.getBrand());
				ps.setInt(4,p.getQuantity());
				ps.setDouble(5,p.getPrice());
				ps.addBatch();
			}
			return ps.executeBatch();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		return null;
		
	}
}
