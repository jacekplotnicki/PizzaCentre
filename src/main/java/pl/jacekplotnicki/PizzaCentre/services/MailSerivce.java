package pl.jacekplotnicki.PizzaCentre.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.jacekplotnicki.PizzaCentre.models.PizzaInBasket;
import pl.jacekplotnicki.PizzaCentre.models.UserForm;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailSerivce {
    private final JavaMailSender javaMailSender;


    public void sendMail(UserForm userForm, List<PizzaInBasket> order, BigDecimal sum, boolean isHtmlContent) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(userForm.getEmail());
        String subject = "Thank you for your purchase " + userForm.getName();
        String text = createMailContent(order, sum, userForm);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, isHtmlContent);
        javaMailSender.send(mimeMessage);
    }

    private String createMailContent(List<PizzaInBasket> order, BigDecimal sum, UserForm userForm) {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Thank you for your order!</h1>");
        sb.append("<p>Dear, ").append(userForm.getName()).append("</p>");
        sb.append("<p>Your order: </p>").append("<hr>");

        for (PizzaInBasket element : order) {
            sb.append("<h4>").append(element.getName()).append(" x ").append(element.getQuantity()).append("</h4>");
        }
        sb.append("<hr><p>Total Amount To Pay: ").append(sum).append(" PLN</p>");
        sb.append("<p>Delivery Adress entered: ").append(userForm.getAddress()).append("</p>");
        log.info("{}", sb);
        return sb.toString();
    }
}