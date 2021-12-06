package servlet;

import domain.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*创建一个user对象用于存储输入的信息并对信息进行设置*/
		
		User user = new User();
		String Account=request.getParameter("UserAccount");
		String Password=request.getParameter("UserPassword");
		String Email=request.getParameter("UserEmail");
		user.setUserAccount(Account);
		user.setUserPassword(Password);
		user.setUserEmail(Email);

		UserService service = new UserService();
		try {
			service.register(user);
			request.getSession().setAttribute("UserAccount", user.getUserAccount());
			request.getSession().setAttribute("UserPassword", user.getUserPassword());
			request.getSession().setAttribute("UserEmail", user.getUserEmail());
			response.sendRedirect("/SearchAllProduct");
			request.getSession().setAttribute("register_message","");
		} catch (ServletException e) {
			request.getSession().setAttribute("register_message",e.getMessage());
			response.sendRedirect(request.getContextPath() + "/client/register.jsp");
		}
	}
}
