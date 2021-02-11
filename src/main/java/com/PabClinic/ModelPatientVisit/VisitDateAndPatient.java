package com.PabClinic.ModelPatientVisit;

import com.PabClinic.Model.Patient.Patient;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Data
public class VisitDateAndPatient {

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    private Date dateTimeFirst;
    private Date dateTimeLast;

    private Patient patient;
    private Date next = dateTimeFirst;

    private ArrayList<Date> dateTimeList;

    public ArrayList<Date> dodajGodzinyDoTablicy() {

        do {
            System.out.println(format.format(next));
            dateTimeList.add(next);
        } while ((next = new Date(next.getTime() + 1800000)).before(dateTimeLast));

        return dateTimeList;
    }

    public VisitDateAndPatient(Patient patient, ArrayList<Date> dateTimeList) {
        this.patient = patient;
        this.dateTimeList = dodajGodzinyDoTablicy();
    }

    {
        try {
            dateTimeFirst = format.parse("08:00");
            dateTimeLast = format.parse("12:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
