package com.nlbg.store.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailSenderImplementation implements EmailSender {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmailSenderImplementation.class);
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email.");
            helper.setFrom("hello@nlbg.store");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException ex) {
            LOGGER.error("Failed to send email.", ex);
            throw new IllegalStateException("Failed to send email.");
        }
    }
}
