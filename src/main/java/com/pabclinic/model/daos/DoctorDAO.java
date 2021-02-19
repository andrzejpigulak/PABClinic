package com.pabclinic.model.daos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDAO {

    private Integer doctor_ID;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String specialisation;

}
