package com.pabclinic.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDTO {

    private Integer doctor_ID;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String specialisation;

}
