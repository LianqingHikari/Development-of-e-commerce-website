package service;

import dao.ProductDao;
import domain.Product;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.List;

public class ProductService {
    public Product FindProductByName(String ProductName) throws ServletException
    {
        ProductDao dao=new ProductDao();
        try{
            return dao.FindBookByName(ProductName);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("SQL语句错误");
        }
    }

    public void AddProduct(Product product) throws ServletException {
        ProductDao dao=new ProductDao();
        try{
            dao.AddProduct(product);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("商品信息有误");
        }
    }

    public void DeleteProduct(String productname) throws ServletException {
        ProductDao dao=new ProductDao();
        try{
            dao.DeleteProduct(productname);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("商品信息有误");
        }
    }

    public void UpdateProduct(Product product) throws ServletException {
        ProductDao dao=new ProductDao();
        try{
            dao.UpdateProduct(product);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("商品信息有误");
        }
    }
    public List<Product> ShowSale() throws ServletException
    {
        ProductDao dao=new ProductDao();
        try{
            return dao.ShowSale();
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("未查找到商品");
        }
    }
}
