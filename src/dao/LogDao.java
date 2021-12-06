package dao;

import domain.BrowseLog;
import domain.BuyLog;

import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.DataSourceUtils.getDataSource;

public class LogDao {
    public void AddBrowseLog(BrowseLog browseLog)throws SQLException {
        DataSource dataSource=getDataSource();
        Connection connection=dataSource.getConnection();
        String sql = "insert into browselogs values(?,?,?)";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,browseLog.getUserAccount());
        statement.setString(2,browseLog.getProductName());
        statement.setString(3,browseLog.getBrowseTime());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public void AddBuyLog(String useraccount,String date)throws SQLException {
        DataSource dataSource=getDataSource();
        Connection connection=dataSource.getConnection();
        String sql1 = "INSERT INTO buylogs(ProductName,ProductNumber) SELECT ProductName,ProductNumber FROM carts WHERE UserAccount=?";
        PreparedStatement statement=connection.prepareStatement(sql1);
        statement.setString(1,useraccount);
        statement.executeUpdate();

        String sql2 = "UPDATE buylogs set UserAccount=?,BrowseTime=? where UserAccount=''";
        statement=connection.prepareStatement(sql2);
        statement.setString(1,useraccount);
        statement.setString(2,date);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    public List<BrowseLog> SearchBrowseLog(String useraccount) throws SQLException, ServletException {
        DataSource dataSource=getDataSource();
        Connection connection=dataSource.getConnection();
        String sql = "SELECT * FROM browselogs WHERE UserAccount=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,useraccount);
        ResultSet resultset=statement.executeQuery();
        List<BrowseLog> Lbrowselog= new ArrayList<>();
        if(resultset==null)
        {
            throw new ServletException("用户不存在");
        }
        while(resultset.next())
        {
            String account=resultset.getString(1);
            String productname=resultset.getString(2);
            String browsetime=resultset.getString(3);
            Lbrowselog.add(new BrowseLog(account,productname,browsetime));
        }
        statement.close();
        connection.close();
        return Lbrowselog;
    }

    public List<BuyLog> SearchBuyLog(String useraccount) throws SQLException, ServletException {
        DataSource dataSource=getDataSource();
        Connection connection=dataSource.getConnection();
        String sql = "SELECT * FROM buylogs WHERE UserAccount=?";
        PreparedStatement statement=connection.prepareStatement(sql);
        statement.setString(1,useraccount);
        ResultSet resultset=statement.executeQuery();
        List<BuyLog> Lbuylog= new ArrayList<>();
        if(resultset==null)
        {
            throw new ServletException("用户不存在");
        }
        while(resultset.next())
        {
            String account=resultset.getString(1);
            String productname=resultset.getString(2);
            int productnumber=resultset.getInt(3);
            String browsetime=resultset.getString(4);
            Lbuylog.add(new BuyLog(account,productname,productnumber,browsetime));
        }
        statement.close();
        connection.close();
        return Lbuylog;
    }
}
