package io.github.tpalucki.grammati.resource;

import io.github.tpalucki.grammati.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping(path = "/api/mail")
public class MailResource {

    @Autowired
    MailService mailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void sendMail() throws MessagingException {
        mailService.sendSimpleMail();
    }
}
