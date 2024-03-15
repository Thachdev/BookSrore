package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Cart;

public class CartDAO {

	public static List<Cart> getAllCart(String username){
		List<Cart> list = new ArrayList<>();;
		String query = "SELECT * FROM `bookstore`.`cart` WHERE nameuser = '"+username+"'";
		
		try {
			Connection connection = DBContext.getConnection();
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Cart(
						rs.getString(1), 
						rs.getString(2), 
						rs.getString(3),
						rs.getDouble(4))
						);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
}
