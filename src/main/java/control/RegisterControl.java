package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

/**
 * Servlet implementation class RegisterControl
 */
@WebServlet("/RegisterControl")
public class RegisterControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username"); //name of input
		int password1 = Integer.parseInt(request.getParameter("password1")); //name of input

	    
		if (!RegisterDAO.exist(username)) {
		    RegisterDAO.addRegister(username, password1);
		    request.setAttribute("successMessage", "Đăng ký thành công!");
		    request.getRequestDispatcher("user/register.jsp").forward(request, response);
		} else {
		    request.setAttribute("errorMessage", "Đăng ký thất bại! Tên đăng nhập đã tồn tại.");
		    request.getRequestDispatcher("user/register.jsp").forward(request, response);
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
