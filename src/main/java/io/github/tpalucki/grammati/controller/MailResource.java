package io.github.tpalucki.grammati.controller;

import io.github.tpalucki.grammati.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequiredArgsConstructor
public class MailResource {

    private final MailService mailService;

    @PostMapping("/api/mail/confirm")
    @ResponseStatus(HttpStatus.OK)
    public void sendConfirmMail() throws MessagingException {
        mailService.sendSubscriptionConfirmation("tpalucki@gmail.com", "Tom", "https://onet.pl");
    }

    @PostMapping("/api/mail/daily")
    @ResponseStatus(HttpStatus.OK)
    public void sendMail() throws MessagingException {
        mailService.sendDailyQuiz("tpalucki@gmail.com", "Tom", "https://onet.pl");
    }
}
