package utils;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Properties;
/**
 * 发送邮件的工具类
 */
public class SendEmailUtils {
    public static void SendEmail(String email, String emailMsg) throws AddressException, MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("lianqinghikari@163.com", "FRTRAAUPSNJWKOPO");
            }
        };
        Session session = Session.getInstance(props, auth);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("lianqinghikari@163.com")); // 设置发送者
        message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者
        message.setSubject("连清电商网发货通知");
        message.setContent(emailMsg, "text/html;charset=utf-8");
        Transport.send(message);
    }
}
