package com.PabClinic.Model.Patient;
import lombok.Data;
import org.springframework.stereotype.Component;


import com.PabClinic.Model.Database.DataBase;

import java.util.ArrayList;

@Component
@Data
public class PatientFabrik {

    private ArrayList<Patient> patientsList = new ArrayList<>();

    public PatientFabrik() {

        DataBase dataBase = new DataBase();
        dataBase.getPatients(patientsList);
    }

}
