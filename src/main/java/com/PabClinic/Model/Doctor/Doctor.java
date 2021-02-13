package com.PabClinic.Model.Doctor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    private Integer doctor_ID;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String specialisation;

}
