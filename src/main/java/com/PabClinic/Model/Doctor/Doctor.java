package com.PabClinic.Model.Doctor;

public class Doctor {

    private int doctor_ID;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String specialisation;

    public Doctor(int doctor_ID, String firstName, String lastName, String login, String password, String specialisation) {
        this.doctor_ID = doctor_ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.specialisation = specialisation;
    }

    public int getDoctor_ID() {
        return doctor_ID;
    }

    public void setDoctor_ID(int doctor_ID) {
        this.doctor_ID = doctor_ID;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public Doctor() {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_ID=" + doctor_ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", specialisation='" + specialisation + '\'' +
                '}';
    }

//    public Specialisation getSpecialisation() {
//        return specialisation;
//    }
//
//    public void setSpecialisation(Specialisation specialisation) {
//        this.specialisation = specialisation;
//    }
}
