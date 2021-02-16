package com.PabClinic.model.daos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientDAO {


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
    private boolean enabled;

    public PatientDAO(int user_id, String firstName, String lastName, String login, String password, String email, int telephoneNumber, long pesel, String address, String postCode, String city) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.pesel = pesel;
        this.address = address;
        this.postCode = postCode;
        this.city = city;
        this.enabled = true;
    }
}
