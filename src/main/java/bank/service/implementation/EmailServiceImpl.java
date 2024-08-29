package bank.service.implementation;

import bank.config.EmailProperties;
import bank.dto.CustomerDto;
import bank.dto.EmailNotificationDto;
import bank.kafka.consumer.EmailNotificationKafkaConsumer;
import bank.service.CustomerService;
import bank.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private static final Logger logger = LogManager.getLogger(EmailServiceImpl.class);
    private final JavaMailSender emailSender;
    private final EmailProperties emailProperties;
    private final CustomerService customerService;

    @Override
    public void sendEmail(final EmailNotificationDto dto) {
        logger.info("Sending Email.");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailProperties.getUsername());
        message.setTo(getCustomerInformation(dto).getEmail());
        message.setSubject(dto.getSubject());
        message.setText(dto.getBody());
        emailSender.send(message);
        logger.info("Email Sent Successfully.");
    }

    private CustomerDto getCustomerInformation(final EmailNotificationDto dto) {
        return customerService.findById(dto.getCustomerId());
    }
}
