package com.PabClinic.Model.Research;
import com.PabClinic.Model.Database.DataBase;
import lombok.Data;
import java.util.ArrayList;

@Data
public class ResearchFabrik {

    ArrayList<Research> researchList = new ArrayList<>();

    public ResearchFabrik() {

        DataBase dbResearch = new DataBase();
        dbResearch.getResearches(researchList);

    }

}
