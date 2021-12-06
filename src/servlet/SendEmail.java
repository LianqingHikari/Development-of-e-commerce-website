package servlet;

// 文件名 SendEmail.java

import utils.SendEmailUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username=request.getSession().getAttribute("UserAccount").toString();
        String email=request.getSession().getAttribute("UserEmail").toString();
        String msg="尊敬的用户："+username+",您购买的商品已经发货，请注意查收";
        SendEmailUtils sendemail=new SendEmailUtils();
        try {
            sendemail.SendEmail(email,msg);
            response.sendRedirect("/FindCart");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
