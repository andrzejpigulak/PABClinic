package com.PabClinic.Model.serwisy;

import com.PabClinic.Model.Database.DataBase;
import com.PabClinic.Model.Patient.Patient;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SerwisRejestracjiPacjentow {

    private DataBase dataBase = new DataBase();

    public void zarejestrujPacjenta(Patient patient) {

        dataBase.registerPatient(patient);

    }

}
