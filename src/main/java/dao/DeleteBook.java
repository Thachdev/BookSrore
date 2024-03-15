package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import context.DBContext;

public class DeleteBook {
	public static void deleteBook(String name) {
		
	    String query = "DELETE FROM `bookstore`.`books` WHERE `bookname` = ?";
	    
	    try {
	        Connection connection = DBContext.getConnection();
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setString(1, name);
	        ps.executeUpdate();
	        connection.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Xử lý ngoại lệ
	    }
	}


}
