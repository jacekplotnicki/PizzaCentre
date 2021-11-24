package pl.jacekplotnicki.PizzaCentre.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.jacekplotnicki.PizzaCentre.models.PizzaInBasket;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailSerivce {
    private final JavaMailSender javaMailSender;



    public void sendMail(String to, List<PizzaInBasket> order, BigDecimal sum, boolean isHtmlContent) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        String subject="Test Mail";
        String text="Success";
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, isHtmlContent);
        javaMailSender.send(mimeMessage);
    }
}
