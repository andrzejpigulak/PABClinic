package com.PabClinic.Model.Visit;

import lombok.Data;

import java.util.ArrayList;
import java.util.Objects;

@Data
public class VisitFabrik {

    ArrayList<Visit> visitsList = new ArrayList<>();
    ArrayList<Visit> visitTime = new ArrayList<>();


    public VisitFabrik() {
        visitTime.add(new Visit("8:00"));
        visitTime.add(new Visit("8:30"));
        visitTime.add(new Visit("9:00"));
        visitTime.add(new Visit("9:30"));
        visitTime.add(new Visit("10:00"));

    }

    public ArrayList<Visit> usunGodzine(Visit visit) {
        visitTime.remove(visit);

        return visitTime;
    }

    public ArrayList<Visit> addVisitToList(Visit visit){

        visitsList.add(visit);

        return visitsList;
    }

}
