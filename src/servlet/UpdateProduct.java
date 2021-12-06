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
@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
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
        try{
            product.setProductName(request.getParameter("ProductName"));
            product.setProductPrice(Double.parseDouble(request.getParameter("ProductPrice")));
            product.setProductDescription(request.getParameter("ProductDescription"));
            product.setProductType(request.getParameter("ProductType"));
            product.setProductPictureName(request.getParameter("ProductPictureName"));
            productservice.UpdateProduct(product);
            response.sendRedirect(request.getContextPath() + "/client/OperateSuccess.jsp");
        }catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("UpdateProduct_message", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/client/UpdateProduct.jsp");
        }
    }

}