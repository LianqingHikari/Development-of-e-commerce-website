package dao;

import domain.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utils.DataSourceUtils.getDataSource;

public class UserDao {
	// 添加用户
	public void addUser(User user) throws SQLException{
		DataSource dataSource=getDataSource();
		Connection connection=dataSource.getConnection();
		String sql = "insert into users values(?,?,?)";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1,user.getUserAccount());
		statement.setString(2,user.getUserPassword());
		statement.setString(3,user.getUserEmail());
		statement.executeUpdate();
		statement.close();
		connection.close();
	}
	
	//根据用户名与密码查找用户
	public User findUserByUserAccountAndUserPassword(String UserAccount, String UserPassword) throws SQLException{
		DataSource dataSource=getDataSource();
		Connection connection=dataSource.getConnection();
		String sql = "select * from Users where UserAccount=? and UserPassword=?";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1,UserAccount);
		statement.setString(2,UserPassword);
		ResultSet resultset=statement.executeQuery();

		User user=new User();
		while(resultset.next())
		{
			user.setUserAccount(resultset.getString(1));
			user.setUserPassword(resultset.getString(2));
			user.setUserEmail(resultset.getString(3));
		}
		resultset.close();
		statement.close();
		connection.close();
		return user;
	}

}
