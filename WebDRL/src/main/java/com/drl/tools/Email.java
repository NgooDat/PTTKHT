package com.drl.tools;

import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    static final String from = "datngongodat0@gmail.com";
    static final String password = "hpru jyex xiud tibz";

    public static boolean sendEmail(String to, String code) {
        // Properties : khai báo các thuộc tính
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST
        props.put("mail.smtp.port", "587"); // TLS 587 SSL 465
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        // Phiên làm việc
        Session session = Session.getInstance(props, auth);

        // Tạo một tin nhắn
        MimeMessage msg = new MimeMessage(session);

        try {
            // Kiểu nội dung
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

            // Người gửi
            msg.setFrom(from);
            //msg.set
            // Người nhận
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            // Tiêu đề email
            msg.setSubject(code + " là mã khôi phục tài khoản của bạn");

            // Quy đinh ngày gửi
            msg.setSentDate(new Date());

            // Quy định email nhận phản hồi
            // msg.setReplyTo(InternetAddress.parse(from, false))
            // Nội dung
            msg.setContent(code + " là mã khôi phục tài khoản của bạn", "text/HTML; charset=UTF-8");

            // Gửi email
            Transport.send(msg);
            //System.out.println("Gửi email thành công");
            return true;
        } catch (MessagingException e) {
            //System.out.println("Gặp lỗi trong quá trình gửi email");
            return false;
        }
    }

    public static String getRandomCode() {
        // Tạo một đối tượng Random
        Random random = new Random();

        // StringBuilder để xây dựng chuỗi
        StringBuilder sb = new StringBuilder();

        // Tạo chuỗi có 6 chữ số
        for (int i = 0; i < 6; i++) {
            // Sinh một số ngẫu nhiên từ 0 đến 9 và thêm vào chuỗi
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

}
