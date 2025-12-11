package com.vijay.ecommerce.kafka;

import com.vijay.ecommerce.email.EmailService;
import com.vijay.ecommerce.kafka.order.OrderConfirmation;
import com.vijay.ecommerce.kafka.payment.PaymentConfirmation;
import com.vijay.ecommerce.notification.Notification;
import com.vijay.ecommerce.notification.NotificationRepository;
import com.vijay.ecommerce.notification.NotificationType;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationRepository repository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(
            PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info("Received Payment Confirmation for payment {}", paymentConfirmation);

        repository.save(
                Notification.builder()
                        .type(NotificationType.PAYMENT_CONFIRMATION)
                        .paymentConfirmation(paymentConfirmation)
                        .notificationTime(LocalDateTime.now())
                        .build()
        );

        var customerName = paymentConfirmation.customerFirstName()+ " "+ paymentConfirmation.customerLastName();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmail(),
                customerName,
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference()
        );

    }
    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(
            OrderConfirmation orderConfirmation) throws MessagingException {
        log.info("Received Payment Confirmation for order {}", orderConfirmation);

        repository.save(
                Notification.builder()
                        .type(NotificationType.ORDER_CONFIRMATION)
                        .orderConfirmation(orderConfirmation)
                        .notificationTime(LocalDateTime.now())
                        .build()
        );

        var customerName = orderConfirmation.customer().firstName()+ " "+ orderConfirmation.customer().lastName();
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.customer().email(),
                customerName,
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()
        );

    }
}
