package local.wpr.start.sios.service;

import local.wpr.start.sios.repository.MailPropertiesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailService {
    private static final Logger LOG = LoggerFactory.getLogger(MailService.class);
    private JavaMailSender javaMailSender;
    private MailPropertiesRepository mailPropertiesRepository;

    public MailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
    public void sandNew(String[] to, String subject, String content){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setFrom("Informacja@wpr.slask.eu");
        msg.setSubject(subject);
        msg.setText(content);
        javaMailSender.send(msg);
    }
    public void SenDefaultMessage(String to, String subject, String content) throws Exception{
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject(subject);
        helper.setFrom("Informacja@wcpr.slask.eu");
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setContent(content, "text/html");
        message.setDataHandler(new DataHandler(content, "text/html; charset=UTF-8"));
        System.out.println("Wysyłam default");
        javaMailSender.send(message);
    }
}
