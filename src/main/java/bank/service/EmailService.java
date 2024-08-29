package bank.service;

import bank.dto.EmailNotificationDto;

public interface EmailService {
    void sendEmail(final EmailNotificationDto dto);
}
