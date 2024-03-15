package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDAO;
import entity.Account;

/**
 * Servlet implementation class LoginControl
 */
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		String username = request.getParameter("username"); //name of input
		int password = Integer.parseInt(request.getParameter("password")); //name of input
		
		LoginDAO log = new LoginDAO();
		Account a = log.checkLogin(username, password);
		
		if(a!=null && username.equals("admin")) {
			
			response.sendRedirect("./admin");
			
		}else {
			if(a!=null) {
				request.setAttribute("username", username);
	            // Chuyển hướng yêu cầu đến servlet ./user
	            RequestDispatcher dispatcher = request.getRequestDispatcher("./user");
	            dispatcher.forward(request, response);
			}else {
				request.setAttribute("errorMessage", "Đăng nhập thất bại! Tên tài khoản hoặc mật khẩu không chính xác!");
			    request.getRequestDispatcher("user/login.jsp").forward(request, response);
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
