package service;

import dao.CartDao;
import domain.Cart;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.List;

public class CartService {
    public List<Cart> GetAllCart(String UserAccount) throws ServletException
    {
        CartDao dao=new CartDao();
        try{
            return dao.GetAllCart(UserAccount);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("错误");
        }
    }

    public void AddCart(Cart cart) throws ServletException {
        CartDao dao=new CartDao();
        try{
            dao.AddCart(cart);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("商品信息有误");
        }
    }

    public void DeleteCart(String useraccount,String productname) throws ServletException {
        CartDao dao=new CartDao();
        try{
            dao.DeleteCart(useraccount,productname);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("商品信息有误");
        }
    }

    public void PayCart(String useraccount) throws ServletException {
        CartDao dao=new CartDao();
        try{
            dao.PayCart(useraccount);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("商品信息有误");
        }
    }
}
