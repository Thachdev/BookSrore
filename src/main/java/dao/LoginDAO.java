package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import context.DBContext;
import entity.Account;

public class LoginDAO {
	
    
    
    public Account checkLogin(String user, int pass) {
    	
    	String query = "select * from bookstore.users where username = ? and password = ?";
    	try {
    		Connection connection = null;
    	    PreparedStatement ps = null;
    	    ResultSet rs = null;
    	    
			connection =  DBContext.getConnection();
			ps = connection.prepareStatement(query);
			ps.setString(1, user);
			ps.setInt(2, pass);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Account a = new Account(rs.getString(1),rs.getString(2));
				return a;
			}
			connection.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
    	
    	return null;
    }
}
