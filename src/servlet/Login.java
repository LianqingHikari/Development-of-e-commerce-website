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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Account=request.getParameter("UserAccount");
		String Password=request.getParameter("UserPassword");

		UserService service = new UserService();
		try {
			User user = service.login(Account, Password);
			request.getSession().setAttribute("UserAccount", user.getUserAccount());
			request.getSession().setAttribute("UserPassword", user.getUserPassword());
			request.getSession().setAttribute("UserEmail", user.getUserEmail());
			request.getSession().setAttribute("login_message","");
			if(request.getSession().getAttribute("UserAccount").equals("hikari"))
			{
				response.sendRedirect(request.getContextPath() + "/client/AdminCenter.jsp");
			}
			else
			{
				response.sendRedirect("/SearchAllProduct");
			}
		} catch (ServletException e) {
			request.getSession().setAttribute("login_message", e.getMessage());
			response.sendRedirect(request.getContextPath() + "/client/login.jsp");
		}
	}

}
