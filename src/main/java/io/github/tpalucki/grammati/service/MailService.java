package io.github.tpalucki.grammati.service;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender mailSender;
    private final Parser markdownParser;
    private final HtmlRenderer markdownHtmlRenderer;

    public void sendSubscriptionConfirmation(String email, String name, String confirmUrl) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setFrom("noreply@grammati.com");
            helper.setSubject("Confirm your subscription for Gramilka");
            helper.setTo(email);
            helper.setValidateAddresses(true);

            String htmlMessage = provideHtmlMessage("./templates/subscriptionConfirmation.md", name, confirmUrl);
            helper.setText(htmlMessage, true);

            mailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            log.error("Cannot sent subscription confirmation email");
        }
    }

    // TODO refactor - extract common code to a separate method
    public void sendDailyQuiz(String email, String name, String quizUrl) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

        try {
            helper.setFrom("noreply@gramilka.com");
            helper.setSubject("You daily quiz for practice.");
            helper.setTo(email);
            helper.setValidateAddresses(true);

            String htmlMessage = provideHtmlMessage("./templates/dailyQuiz.md", name, quizUrl);
            helper.setText(htmlMessage, true);

            mailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            log.error("Cannot sent subscription confirmation email");
        }
    }

    private String provideHtmlMessage(String template, String name, String link) throws IOException {
        String tempalate = this.getClass().getClassLoader().getResource(template).getFile();

        String templateContent = Files.readString(Paths.get(tempalate));
        templateContent = templateContent.replace("{{name}}", name).replace("{{link}}", link);

        Node document = markdownParser.parse(templateContent);
        return markdownHtmlRenderer.render(document);
    }

}
