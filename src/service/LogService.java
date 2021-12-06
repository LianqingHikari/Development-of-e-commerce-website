package service;

import dao.LogDao;
import domain.BrowseLog;
import domain.BuyLog;

import javax.servlet.ServletException;
import java.sql.SQLException;
import java.util.List;

public class LogService {
    private LogDao dao = new LogDao();

    public void AddBrowseLog(BrowseLog browseLog)throws ServletException {
        try {
            dao.AddBrowseLog(browseLog);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("错误");
        }
    }

    public void AddBuyLog(String useraccount,String date)throws ServletException {
        try {
            dao.AddBuyLog(useraccount,date);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("错误");
        }
    }
    public List<BrowseLog> SearchBrowseLog(String useraccount)throws ServletException {
        try {
            return dao.SearchBrowseLog(useraccount);
        } catch (ServletException | SQLException e) {
            throw new ServletException("用户不存在");
        }
    }
    public List<BuyLog> SearchBuyLog(String useraccount)throws ServletException {
        try {
            return dao.SearchBuyLog(useraccount);
        } catch (ServletException | SQLException e) {
            throw new ServletException("用户不存在");
        }
    }
}
