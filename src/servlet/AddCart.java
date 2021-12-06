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
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
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
        if(request.getParameter("ProductNumber").equals("请输入需要购买的数量"))
        {
            request.setAttribute("AddCart_message", "未输入商品数量");
            response.sendRedirect(request.getContextPath() + "/client/SearchResult.jsp");
            return;
        }
        try{
            cart.setUserAccount((request.getSession().getAttribute("UserAccount")).toString());
            cart.setProductName((request.getSession().getAttribute("ProductName")).toString());
            cart.setProductPrice(Double.parseDouble(request.getSession().getAttribute("ProductPrice").toString()));
            cart.setProductNumber(Integer.parseInt(request.getParameter("ProductNumber")));

            cartservice.AddCart(cart);
            response.sendRedirect(request.getContextPath() + "/client/OperateSuccess.jsp");
        }catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("AddCart_message", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/client/SearchResult.jsp");
        }
    }

}
