package com.practice.mailservice.kafka;

import com.practice.common.dto.EmailVerificationEvent;
import com.practice.mailservice.dto.Email;
import com.practice.mailservice.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final EmailService emailService;

    @KafkaListener(
            topics = "email-verification-topic",
            groupId = "mail-service",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(EmailVerificationEvent event) {
        String link = "https://localhost:8443/verify?token=" + event.token();
        String body = "Click to verify: " + link;

        Email email = new Email();
        email.setTo(event.email());
        email.setSubject("Verify your email");
        email.setBody(body);

        emailService.sendSimpleEmail(email);
    }

}