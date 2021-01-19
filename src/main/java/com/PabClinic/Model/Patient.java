package com.PabClinic.Model;

public class Patient {

    private String firstName;
    private String lastName;
    private long pesel;
    private String login;
    private String email;
    private int telephoneNumber;
    private String adress;
    private String postCode;
    private String City;

    public Patient() {
    }

    public Patient(String firstName, String lastName, long pesel, String login, String email, int telephoneNumber, String adress, String postCode, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.login = login;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.adress = adress;
        this.postCode = postCode;
        City = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNumber=" + telephoneNumber +
                ", adress='" + adress + '\'' +
                ", postCode='" + postCode + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}
