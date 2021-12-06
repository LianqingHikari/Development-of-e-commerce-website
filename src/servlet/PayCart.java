package servlet;

import service.CartService;
import service.LogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/PayCart")
public class PayCart extends HttpServlet {
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
        CartService cartservice=new CartService();
        LogService logservice=new LogService();
        String useraccount=request.getSession().getAttribute("UserAccount").toString();
        Date date=new Date();
        try{
            logservice.AddBuyLog(useraccount,date.toString());
            cartservice.PayCart(useraccount);
            request.getRequestDispatcher("/SendEmail").forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("PayCart_message", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/client/Cart.jsp");
        }
    }
}