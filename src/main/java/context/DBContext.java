package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	
	public static Connection getConnection()throws Exception{
		Connection c = null;
		
		String url = "jdbc:mysql://localhost:3306/bookstore";
        String username = "root";
        String password = "1234";
        c = DriverManager.getConnection(url, username, password);
        
		return c;
	}
	
	public static void main(String[] args) {
        Connection connection = null;
		try {
			connection = DBContext.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (connection != null) {
		    System.out.println("Kết nối đến cơ sở dữ liệu thành công.");
		} else {
		    System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
		}
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

}
