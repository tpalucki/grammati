package io.github.tpalucki.grammati.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    // TODO fill the email properly
    public void sendConfirmationEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@grammati.com");
        message.setTo(email);
        message.setSubject("Confirm your email");
        message.setText("This is the test email template for your email:\n%s\n");

        mailSender.send(message);
    }
}
