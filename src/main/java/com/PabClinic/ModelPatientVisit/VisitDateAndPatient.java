package com.PabClinic.ModelPatientVisit;

import com.PabClinic.Model.Patient.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class VisitDateAndPatient {

    private SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    private Date dateTimeFirst;
    private Date dateTimeLast;
    private Patient patient;
    private Date next = dateTimeFirst;
    private ArrayList<Date> dateTimeList = new ArrayList<>();

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

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }

    public Date getDateTimeFirst() {
        return dateTimeFirst;
    }

    public void setDateTimeFirst(Date dateTimeFirst) {
        this.dateTimeFirst = dateTimeFirst;
    }

    public Date getDateTimeLast() {
        return dateTimeLast;
    }

    public void setDateTimeLast(Date dateTimeLast) {
        this.dateTimeLast = dateTimeLast;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getNext() {
        return next;
    }

    public void setNext(Date next) {
        this.next = next;
    }
}
