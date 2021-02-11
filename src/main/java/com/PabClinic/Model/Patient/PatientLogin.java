package com.PabClinic.Model.Patient;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientLogin {

    private String login;
    private String password;

}
