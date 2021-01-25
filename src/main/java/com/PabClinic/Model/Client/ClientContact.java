package com.PabClinic.Model.Client;

public class ClientContact {

    private String name;
    private String email;
    private String textMessage;
    private String subject;


    public ClientContact() {
    }

    public ClientContact(String name, String email, String textMessage, String subject) {
        this.name = name;
        this.email = email;
        this.textMessage = textMessage;
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }
}
