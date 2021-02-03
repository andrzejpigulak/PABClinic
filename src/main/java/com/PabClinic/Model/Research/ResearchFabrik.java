package com.PabClinic.Model.Research;

import com.PabClinic.Model.Database.DataBase;

import java.util.ArrayList;

public class ResearchFabrik {

    ArrayList<Research> researchList = new ArrayList<>();

    public ResearchFabrik() {

        DataBase dbResearch = new DataBase();
        dbResearch.getResearches(researchList);

    }

    public ArrayList<Research> getResearchList() {
        return researchList;
    }

    public void setResearchList(ArrayList<Research> researchList) {
        this.researchList = researchList;
    }
}
