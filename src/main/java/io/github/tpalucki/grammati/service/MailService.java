package io.github.tpalucki.grammati.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    void sendSubscriptionConfirmationl(String email, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@grammati.com");
        message.setTo(email);
        message.setSubject("Confirm your subscription for Gramilka");
        message.setText(
                "Hi " + name + "!\n" +
                        "Thanks for subscribing to Gramilka.\n" +
                        "From now on you will be receiving daily english questions.\n" +
                        "To confirm this subscription please click below:\n" +
                        "Confirm\n" +
                        "\n" +
                        "Gramilka Team");

        mailSender.send(message);
    }

    public boolean isOn() {
        return false;
    }

    public void sendDailyQuiz(String to, String quizId) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("daily-quiz@grammati.com");
        message.setTo(to);
        message.setSubject("Your daily quiz");
        message.setText("Your daily quiz http://localhost:8080/exercises/" + quizId);

        mailSender.send(message);
    }

    public void sendSimpleMail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        helper.setFrom("tomasz@gramilka.com");
        helper.setSubject("Welcome");
        helper.setTo("tpalucki@protonmail.com");
        helper.setBcc("tpalucki@gmail.com");
        helper.setValidateAddresses(true);
        helper.setText("Jak się masz? to jest pierwszy email.\nTomek");

        mailSender.send(mimeMessage);
    }
}
