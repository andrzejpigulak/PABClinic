package com.PabClinic.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientLoginDTO {

    private String login;
    private String password;

}
