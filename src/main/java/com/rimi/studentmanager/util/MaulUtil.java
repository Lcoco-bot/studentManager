package com.rimi.studentmanager.util;
import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author admin
 * @date 2019/9/29 9:58
 */
public class MaulUtil implements Runnable {
    private String fromemail;
    private String code;


    public MaulUtil(String fromemail, String code) {
        this.fromemail = fromemail;
        this.code = code;
    }

    @Override
    public void run() {
        String from = "2659573462@qq.com";
        String host = "smtp.qq.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");

        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.ssl.socketFactory", sf);
            Session session = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("2659573462@qq.com", "flcxaxeommmxeafi"); // 发件人邮箱账号、授权码
                }
            });
            Message message = new MimeMessage(session);
            // 2.1设置发件人
            message.setFrom(new InternetAddress(from));
            // 2.2设置接收人
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(fromemail));
            //内容
            message.setSubject("账号激活");
            String content = "<a href='http://10.1.0.119:80/loginsuccess.jsp'>点击登录</a>";
            message.setContent(content,"text/html;charset=UTF-8");

            Transport.send(message);
            System.out.println("邮件成功发送!");
        } catch (GeneralSecurityException | MessagingException e) {
            e.printStackTrace();
        }


    }
}
