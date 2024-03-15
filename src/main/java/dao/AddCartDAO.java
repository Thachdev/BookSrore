package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import context.DBContext;

public class AddCartDAO {
	
	public static void addToCart(String user, String image, String name, double price) {
		String query = "INSERT INTO `bookstore`.`cart` (`nameuser`, `bookimage`, `bookname`, `bookprice`) VALUES (?,?,?,?)";
		
		try {
			Connection connection = DBContext.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, image);
			ps.setString(3, name);
			ps.setDouble(4, price);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
