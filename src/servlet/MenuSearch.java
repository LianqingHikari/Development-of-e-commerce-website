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
 * Servlet implementation class MenuSearch
 */
@WebServlet("/MenuSearch")
public class MenuSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService service = new ProductService();
		try{
			String ProductName=request.getParameter("ProductName");
			Product product=service.FindProductByName(ProductName);
			if(product.getProductName()!=null)
			{
				request.getSession().setAttribute("ProductName",product.getProductName());
				request.getSession().setAttribute("ProductPrice",product.getProductPrice());
				request.getSession().setAttribute("ProductDescription",product.getProductDescription());
				request.getSession().setAttribute("ProductType",product.getProductType());
				request.getSession().setAttribute("ProductPictureName",product.getProductPictureName());
				request.getSession().setAttribute("ProductSale",product.getProductSale());
				request.getSession().setAttribute("search_message","");
				request.getSession().setAttribute("search_message","");
				response.sendRedirect("/AddBrowseLog");
			}
			else
			{
				request.getSession().setAttribute("search_message","商品不存在");
				response.sendRedirect(request.getContextPath() + "/client/index.jsp");
			}
		}catch (ServletException e){
			e.printStackTrace();
			request.getSession().setAttribute("search_message", e.getMessage());
			response.sendRedirect(request.getContextPath() + "/client/index.jsp");
		}
	}

}
