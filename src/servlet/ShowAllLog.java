package servlet;

import domain.BrowseLog;
import domain.BuyLog;
import service.LogService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/ShowAllLog")
public class ShowAllLog extends HttpServlet {
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
        String useraccount=request.getParameter("UserAccount");
        LogService logservice=new LogService();
        try{
            List<BrowseLog> browselog=logservice.SearchBrowseLog(useraccount);
            List<BuyLog> buylog=logservice.SearchBuyLog(useraccount);
            request.getSession().setAttribute("lbrowselog",browselog);
            request.getSession().setAttribute("lbuylog",buylog);
            request.getSession().setAttribute("ShowAllLog_message", "");
            response.sendRedirect(request.getContextPath() + "/client/ShowAllLog.jsp");
        }catch (ServletException e) {
            request.getSession().setAttribute("ShowAllLog_message", e.getMessage());
            response.sendRedirect(request.getContextPath() + "/client/AdminCenter.jsp");
        }
    }
}
