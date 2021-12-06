package servlet;

import domain.Product;
import service.ProductService;

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
@WebServlet("/SearchAllProduct")
public class SearchAllProduct extends HttpServlet {
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
        ProductService productservice=new ProductService();
        try{
            List<Product> LProduct= productservice.ShowSale();
            request.getSession().setAttribute("allproduct",LProduct);
            response.sendRedirect(request.getContextPath() + "/client/index.jsp");
        }catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("SearchAllProduct_message", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/client/index.jsp");
        }
    }

}
