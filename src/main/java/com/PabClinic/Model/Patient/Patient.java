package com.PabClinic.Model.Patient;

import com.PabClinic.Model.Visit.VisitHistory;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Patient {

    private int user_id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;
    private int telephoneNumber;
    private long pesel;
    private String address;
    private String postCode;
    private String city;

    private String opis;

    private ArrayList<VisitHistory> visitHistory = new ArrayList<>();

    public Patient() {
    }

    public Patient(int user_id, String firstName, String lastName, String password, long pesel, String login, String email, int telephoneNumber, String address, String postCode, String city) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.pesel = pesel;
        this.login = login;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
    }

}
