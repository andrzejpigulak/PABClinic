package com.pabclinic.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendSimpleMessage(String from, String subject, String to, String text, String name) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setSubject(subject);
        message.setTo(to);
        message.setText("Wiadomość od: " + from + "\n\n" + text + "\n\nPodzrawiam i kocham Was bardzo,\n" + name);
        emailSender.send(message);

    }

    public void sendMessageAfterRegistration(String to, String name, String login, String password) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Rejestracja w PAB CLINICA");
        message.setTo(to);
        message.setText("Witamy w PAB CLINCA " + name + "!\nUdało Ci się zarejestrować!\nTwój login: " + login + "\nHasło: " + password);
        emailSender.send(message);
    }

    public void sendMessageAfterRegistrationToAVisit(String to, String name, String lastName, String date, String dateTime) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Rejstracja wizyty w PABClinica");
        message.setTo(to);
        message.setText("Brawo, udało Ci się zarejestrować na wizytę do lekarza:\nImię lekarza: " + name + "\nNazwisko lekarza: " +
                lastName + "\nData: "+ date + "\nGodzina: " + dateTime + "\nW przypadku odwołania rezerwacji prosimy kontaktować się telefonicznie");
        emailSender.send(message);
    }

}