package servlet;

import domain.Product;
import service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
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
        Product product=new Product();
        ProductService productservice=new ProductService();
        String productname=request.getParameter("ProductName");
        try{
            productservice.DeleteProduct(productname);
            response.sendRedirect(request.getContextPath() + "/client/OperateSuccess.jsp");
        }catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("DeleteProduct_message", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/client/DeleteProduct.jsp");
        }
    }

}
