package com.PabClinic.model.dtos;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientDTO {

    private int user_id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private int telephoneNumber;
    private long pesel;
    private String address;
    private String postCode;
    private String city;
    private String opis;
    private boolean enabled;


    public PatientDTO(int user_id, String firstName, String lastName, String username, String password, String email, int telephoneNumber, long pesel, String address, String postCode, String city) {
        this.user_id = user_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
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
