package com.PabClinic.Model.Visit;

import java.util.ArrayList;
import java.util.Objects;

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

    public ArrayList<Visit> getVisitsList() {
        return visitsList;
    }

    public void setVisitsList(ArrayList<Visit> visitsList) {
        this.visitsList = visitsList;
    }

    public ArrayList<Visit> getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(ArrayList<Visit> visitTime) {
        this.visitTime = visitTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisitFabrik that = (VisitFabrik) o;
        return Objects.equals(visitsList, that.visitsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitsList);
    }

    @Override
    public String toString() {
        return "VisitFabrik{" +
                "visitsList=" + visitsList +
                '}';
    }
}
