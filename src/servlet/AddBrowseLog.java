package servlet;

import domain.BrowseLog;
import service.LogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/AddBrowseLog")
public class AddBrowseLog extends HttpServlet {
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
        Date date=new Date();
        BrowseLog browselog=new BrowseLog();
        browselog.setUserAccount(request.getSession().getAttribute("UserAccount").toString());
        browselog.setProductName(request.getSession().getAttribute("ProductName").toString());
        browselog.setBrowseTime(date.toString());
        LogService logservice=new LogService();
        try{
            logservice.AddBrowseLog(browselog);
            response.sendRedirect(request.getContextPath() + "/client/SearchResult.jsp");
        }catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("AddBrowseLog_message", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/client/Index.jsp");
        }
    }

}
