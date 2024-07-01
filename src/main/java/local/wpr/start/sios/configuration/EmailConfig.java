package local.wpr.start.sios.configuration;

import local.wpr.start.sios.model.MailProperties;
import local.wpr.start.sios.repository.MailPropertiesRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {
    public MailPropertiesRepository mailPropertiesRepository;

    public EmailConfig(MailPropertiesRepository mailPropertiesRepository) {
        this.mailPropertiesRepository = mailPropertiesRepository;
    }

    @Bean
    public JavaMailSender getJavaMailSender(){
        MailProperties mailProperties = mailPropertiesRepository.getProperties();
        String host = mailProperties.getHost();
        String password = mailProperties.getPassword();
        String userName = mailProperties.getUserName();
        int port = mailProperties.getPort();
        System.out.println("Mail properties : " + mailProperties);
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(host);
        mailSender.setPassword(password);
        mailSender.setUsername(userName);
        mailSender.setPort(port);
        Properties properties = mailSender.getJavaMailProperties();
        properties.put("spring.mail.protocol", "smtp");
        properties.put("spring.mail.properties.mail.smtp.auth", "true");
        return mailSender;
    }
}
