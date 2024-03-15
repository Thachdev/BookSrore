package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import context.DBContext;

/**
 * Servlet implementation class DeleteItemControl
 */
@WebServlet("/DeleteItemControl")
public class DeleteItemControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItemControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String name = request.getParameter("itemName");
		System.out.print(user +"\n" + name);
		String query = "DELETE FROM `bookstore`.`cart` WHERE `nameuser` = ? and `bookname` = ?";
	    
	    try {
	        Connection connection = DBContext.getConnection();
	        PreparedStatement ps = connection.prepareStatement(query);
	        ps.setString(1, user);
	        ps.setString(2,name);
	        ps.executeUpdate();
	        connection.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        // Xử lý ngoại lệ
	    }
	    request.setAttribute("username", user);
		request.getRequestDispatcher("./WellcomCart").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
