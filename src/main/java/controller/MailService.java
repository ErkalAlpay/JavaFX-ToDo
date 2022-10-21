package controller;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailService {
    //fhmyvdeyugdzygtx

    private JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    private Properties props = mailSender.getJavaMailProperties();
    public  MailService() {
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("*************@gmail.com");
        mailSender.setPassword("**************");
        // ------------------------------------------------------
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
    }

    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("erkaljavamailsender@gmail.com");
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }

}
