package io.github.tpalucki.grammati.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
//@RequiredArgsConstructor
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendConfirmationEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@grammati.com");
        message.setTo(email);
        message.setSubject("Grammati: Please confirm your subscription");
        message.setText("Thanks for subscribing to Grammati. From now you will be receiving daily english questions. To confirm this subscription please click below:\nConfirm\nGrammati Team");

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

        mailSender.send(mimeMessage);
    }
}
