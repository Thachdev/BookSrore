package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;

public class RegisterDAO {
	

	public static void addRegister(String user, int pass) {
	    	
		String query = "INSERT INTO `bookstore`.`users` (`username`, `password`) VALUES (?, ?)";
		try {
	    		Connection connection = null;
	    	    PreparedStatement ps = null;
	    	    
				connection =  DBContext.getConnection();
				ps = connection.prepareStatement(query);
				ps.setString(1, user);
			    ps.setInt(2, pass);
			    ps.executeUpdate();
				connection.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
			}
	    	
	}
	
	public static boolean exist(String username) {
	    boolean check = false;

	    String query = "SELECT * FROM bookstore.users WHERE username = ?";
	    try (Connection connection = DBContext.getConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {
	        ps.setString(1, username);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                check = true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return check;
	}

}
