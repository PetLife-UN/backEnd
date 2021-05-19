package com.petlife.backend.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(SendEmailService.class);

    public void sendEmail(String to, String subject,String token, String url){
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("noreply@baeldung.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(
                        "<table style=\"max-width: 600px; padding: 10px; margin:0 auto; border-collapse: collapse;\">"+
                            "<tr><td style=\"padding: 0\"><img style=\"padding: 0; display: block\" src=\"https://i.postimg.cc/pV3qdkj2/petlife.jpg\" width=\"100%\"></td></tr>"+
                            "<div><h3>Activación de Cuenta</h3>" +
                            "<h4>¡Hola!</h4><p>Para continuar con el proceso de registro por favor hacer click en el boton que se presenta a continuación" +
                            "</p><a class=\"button\" href=\""+ url +"/"+ token +"\" style=\"color:white; box-shadow:inset 0px -3px 7px 0px #29bbff;background:linear-gradient(to bottom, #2dabf9 5%, #0688fa 100%);background-color:#2dabf9;border-radius:3px;border:1px solid #0b0e07;display:inline-block;cursor:pointer;color:#ffffff;font-family:Arial;font-size:15px;padding:9px 23px;text-decoration:none;text-shadow:0px 1px 0px #263666;\">" +
                            "Haga clic aquí para abrir el formulario</a></div></div>"
                    , true
            );

            javaMailSender.send(message);
        } catch (MessagingException e) {
            logger.error(e.getMessage());
        }

    }

    public void sendEmailPasswordRecovery(String to, String subject,String text){
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom("noreply@baeldung.com");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text
                    , true
            );
            helper.addInline("Logo", new ClassPathResource("public/petlife.jpg"));

            javaMailSender.send(message);
        } catch (MessagingException e) {
            logger.error(e.getMessage());
        }

    }
}
