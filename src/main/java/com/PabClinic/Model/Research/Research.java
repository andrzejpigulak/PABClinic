package com.PabClinic.Model.Research;

import java.util.ArrayList;

public class Research {

    private int badanie_id;
    private String nazwaBadania;
    private int cenaBadania;


    public Research() {
    }

    public Research(int badanie_id, String nazwaBadania, int cenaBadania) {
        this.badanie_id = badanie_id;
        this.nazwaBadania = nazwaBadania;
        this.cenaBadania = cenaBadania;
    }

    public int getBadanie_id() {
        return badanie_id;
    }

    public void setBadanie_id(int badanie_id) {
        this.badanie_id = badanie_id;
    }

    public String getNazwaBadania() {
        return nazwaBadania;
    }

    public void setNazwaBadania(String nazwaBadania) {
        this.nazwaBadania = nazwaBadania;
    }

    public int getCenaBadania() {
        return cenaBadania;
    }

    public void setCenaBadania(int cenaBadania) {
        this.cenaBadania = cenaBadania;
    }
}
