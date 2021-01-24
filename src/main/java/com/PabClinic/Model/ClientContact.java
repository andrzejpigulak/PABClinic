package com.PabClinic.Model;

public class ClientContact {

    private String firstName;
    private String email;
    private String textMessage;


    public ClientContact() {
    }

    public ClientContact(String firstName, String email, String textMessage) {
        this.firstName = firstName;
        this.email = email;
        this.textMessage = textMessage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
