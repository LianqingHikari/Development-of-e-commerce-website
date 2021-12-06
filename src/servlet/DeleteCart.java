package servlet;

import domain.Cart;
import service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {
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
        Cart cart=new Cart();
        CartService cartservice=new CartService();
        String productname=request.getParameter("ProductName");
        String useraccount=request.getSession().getAttribute("UserAccount").toString();
        try{
            cartservice.DeleteCart(useraccount,productname);
            request.getRequestDispatcher("/FindCart").forward(request,response);
        }catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("DeleteCart_message", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/client/Cart.jsp");
        }
    }

}