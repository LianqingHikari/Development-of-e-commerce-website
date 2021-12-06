package servlet;

import domain.Cart;
import service.CartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/FindCart")
public class FindCart extends HttpServlet {
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
        double TotalPrice=0;
        String useraccount=String.valueOf(request.getSession().getAttribute("UserAccount"));
        try{
            List<Cart> Lcart= cartservice.GetAllCart(useraccount);
            request.getSession().setAttribute("lcart",Lcart);
            for(int i=0;i<Lcart.size();i++){
                TotalPrice+= Lcart.get(i).getProductPrice()*Lcart.get(i).getProductNumber();
            }
            request.getSession().setAttribute("TotalPrice",TotalPrice);
            response.sendRedirect(request.getContextPath() + "/client/Cart.jsp");
        }catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("AddCart_message", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/client/Cart.jsp");
        }
    }

}
