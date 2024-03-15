package context;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Book;

/**
 * Servlet implementation class Wellcome
 */
@WebServlet("/user")
public class WellComeUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WellComeUser() {
        super();
        // TODO Auto-generated constructor stub
		String url = "jdbc:mysql://localhost:3306/bookstore";
        String username = "root";
        String password = "1234";
        try {
			DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection c= null;
		String url = "jdbc:mysql://localhost:3306/bookstore";
        String username = "root";
        String password = "1234";
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT * FROM bookstore.books";
        List<Book> list = new ArrayList<Book>();
        try {
			c = DriverManager.getConnection(url, username, password);
			ps = c.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Book(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getDouble(3),
						rs.getString(4))
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
        request.setAttribute("listP", list);
        request.getRequestDispatcher("user/WellcomeUser.jsp").forward(request, response);
        
        if(c!=null) {
        	try {
				c.close();
			} catch (SQLException e) {
			}
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
