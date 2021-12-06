package dao;

import domain.Cart;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.DataSourceUtils.getDataSource;

public class CartDao {
    // 添加用户
    public void AddCart(Cart cart) throws SQLException{
        DataSource dataSource=getDataSource();
        Connection connection=dataSource.getConnection();
        String sql = "insert into carts values(?,?,?,?)";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,cart.getUserAccount());
        statement.setString(2,cart.getProductName());
        statement.setDouble(3,cart.getProductPrice());
        statement.setInt(4,cart.getProductNumber());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public List<Cart> GetAllCart(String UserAccount) throws SQLException{
        DataSource dataSource=getDataSource();
        Connection connection=dataSource.getConnection();
        String sql = "select * from Carts where UserAccount=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,UserAccount);
        ResultSet resultset=statement.executeQuery();
        List<Cart> Lcart= new ArrayList<>();
        while(resultset.next())
        {
            String useraccount=resultset.getString(1);
            String productname=resultset.getString(2);
            Double productprice=resultset.getDouble(3);
            Integer productnumber=resultset.getInt(4);
            Lcart.add(new Cart(useraccount,productname,productprice,productnumber));
        }
        resultset.close();
        statement.close();
        connection.close();
        return Lcart;
    }

    public void DeleteCart(String useraccount,String productname) throws SQLException{
        DataSource dataSource=getDataSource();
        Connection connection=dataSource.getConnection();
        String sql = "DELETE from carts where UserAccount=? and ProductName=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,useraccount);
        statement.setString(2,productname);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void PayCart(String useraccount) throws SQLException{
        DataSource dataSource=getDataSource();
        Connection connection=dataSource.getConnection();
        String sql = "UPDATE products,carts SET products.ProductSale=products.ProductSale+carts.ProductNumber WHERE products.ProductName=carts.ProductName And UserAccount=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,useraccount);
        statement.executeUpdate();

        String sql2="DELETE from carts where UserAccount=?";
        statement=connection.prepareStatement(sql2);
        statement.setString(1,useraccount);
        statement.executeUpdate();

        statement.close();
        connection.close();
    }
}