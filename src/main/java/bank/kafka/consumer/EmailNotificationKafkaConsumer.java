package bank.kafka.consumer;

import bank.config.EmailProperties;
import bank.dto.EmailNotificationDto;
import bank.service.CustomerService;
import bank.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailNotificationKafkaConsumer {
    private static final Logger logger = LogManager.getLogger(EmailNotificationKafkaConsumer.class);
    private final EmailService service;

    @KafkaListener(topics = "email_notifications", groupId = "customer-service", containerFactory = "kafkaListenerContainerFactory")
    public void consume(EmailNotificationDto message) {
        logger.info("Received message: {}", message);
        service.sendEmail(message);
    }
}
