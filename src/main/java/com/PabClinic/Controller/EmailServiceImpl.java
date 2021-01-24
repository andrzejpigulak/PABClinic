package com.PabClinic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(String from, String subject, String to, String text, String name) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setSubject(subject);
        message.setTo(to);
        message.setText("Wiadomość od: " + from + "\n\n" + text + "\n\nPozrawiam i kocham Was bardzo,\n" + name);
        System.out.println("wysylam sobie wiadomosc");
        emailSender.send(message);

    }

}