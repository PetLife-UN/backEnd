package com.petlife.backend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject,String token){
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("noreply@baeldung.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(
                    "<h1> Welcome to petday <h1>"+
                            "<h4>Please insert the next code to verify your email account</h4>"+ "<br>" +
                            token+ "<br>" +
                            "<img src='cid:Logo'>"
                    , true
            );
            helper.addInline("Logo", new ClassPathResource("public/petlife.jpg"));

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
