package service;

import dao.UserDao;
import domain.User;

import javax.servlet.ServletException;
import java.sql.SQLException;

public class UserService {
	private UserDao dao = new UserDao();
	public void register(User user) throws ServletException{
        try {
		    dao.addUser(user);
		} catch (Exception e) {
			throw new ServletException("账号已存在！");
		}
	}
	public User login(String UserAccount, String UserPassword) throws ServletException {

		User user = new User();
		try {
			user = dao.findUserByUserAccountAndUserPassword(UserAccount, UserPassword);
			if (user.getUserAccount()!=null) {
				return user;
			}
			else{
				throw new ServletException("密码或者用户名错误");
			}
		} catch (SQLException e) {
			throw new ServletException("SQL语句错误");
		}
	}
}
