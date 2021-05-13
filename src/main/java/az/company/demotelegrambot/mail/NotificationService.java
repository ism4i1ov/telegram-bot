package az.company.demotelegrambot.mail;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:telegram.properties")
public class NotificationService {

    private final JavaMailSender javaMailSender;

    public NotificationService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Value("${bot.mail.subject}")
    private String emailSubject;

    @Value("${bot.mail.from}")
    private String emailFrom;

    @Value("${bot.mail.text}")
    private String text;


    private void sendEmail(String emailTo, String accountName) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        String format = String.format(emailTo, accountName);
        simpleMailMessage.setTo(format);
        simpleMailMessage.setFrom(emailFrom);
        simpleMailMessage.setSubject(emailSubject);
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);
    }
}
