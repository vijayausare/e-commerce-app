package com.vijay.ecommerce.email;

import com.vijay.ecommerce.kafka.order.Product;
import com.vijay.ecommerce.kafka.payment.PaymentMethod;
import com.vijay.ecommerce.notification.NotificationRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.encoders.UTF8;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.Message;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Async
    public void sendPaymentSuccessEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(
                mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name()
        );

        messageHelper.setFrom("vijay.ausare.in@gmail.com");
        final String templateNama = EmailTemplate.PAYMENT_CONFIRMATION.getTemplate();

        Map<String,Object> var = new HashMap<>();
        var.put("customerName", customerName);
        var.put("amount", amount);
        var.put("orderReference", orderReference);

        Context context = new Context();
        context.setVariables(var);

        messageHelper.setSubject(EmailTemplate.PAYMENT_CONFIRMATION.getSubject());

        try{
            String html = templateEngine.process(templateNama,context);
            messageHelper.setText(html,true);

            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);

            log.info("Email has been sent successfully to %s with template %s", destinationEmail, templateNama);
        } catch (MessagingException e) {
            log.warn("Can not send email to {}", destinationEmail);
        }
    }

    @Async
    public void sendOrderConfirmationEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference,
            List<Product> products) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(
                mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name()
        );

        messageHelper.setFrom("vijay.ausare.in@gmail.com");
        final String templateNama = EmailTemplate.ORDER_CONFIRMATION.getTemplate();

        Map<String,Object> var = new HashMap<>();
        var.put("customerName", customerName);
        var.put("totalAmount", amount);
        var.put("orderReference", orderReference);
        var.put("products", products);

        Context context = new Context();
        context.setVariables(var);

        messageHelper.setSubject(EmailTemplate.ORDER_CONFIRMATION.getSubject());

        try{
            String html = templateEngine.process(templateNama,context);
            messageHelper.setText(html,true);

            messageHelper.setTo(destinationEmail);
            mailSender.send(mimeMessage);

            log.info("Email has been sent successfully to %s with template %s", destinationEmail, templateNama);
        } catch (MessagingException e) {
            log.warn("Can not send email to {}", destinationEmail);
        }
    }


}
