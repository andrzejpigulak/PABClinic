package com.PabClinic.Model.Doctor;

import com.PabClinic.Model.Database.DataBase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DoctorFabrik {

    private ArrayList<Doctor> doctorList = new ArrayList<>();

    public DoctorFabrik() {

        DataBase dataBase = new DataBase();
        dataBase.getDoctors(doctorList);

    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
