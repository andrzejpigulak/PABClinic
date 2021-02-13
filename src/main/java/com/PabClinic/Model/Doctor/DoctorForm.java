package com.PabClinic.Model.Doctor;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DoctorForm {

    private String fullName;

    private Integer doctor_ID;

}
