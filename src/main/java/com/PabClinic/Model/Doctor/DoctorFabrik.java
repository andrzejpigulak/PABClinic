package com.PabClinic.Model.Doctor;

import com.PabClinic.Model.Database.DataBase;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Data
public class DoctorFabrik {

    private ArrayList<Doctor> doctorList = new ArrayList<>();

    public DoctorFabrik() {

        DataBase dataBase = new DataBase();
        dataBase.getDoctors(doctorList);

    }

}
