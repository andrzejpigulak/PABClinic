package com.PabClinic.Model;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PatientFabrik {

    private ArrayList<Patient> patientsList = new ArrayList<>();

    public PatientFabrik() {
        patientsList.add(new Patient("Adam", "Kowalski", "haslo", 87110725732L, "akowalski", "akowalski@mail.com", 627315621, "ul. Marszalkowska 12", "61-001", "Poznań"));
        patientsList.add(new Patient("Katarzyna", "Sikora","haslo",67032265927L, "ksikora", "akowalski@mail.com", 504213521, "ul. Grunwaldzka 25/3", "60-783", "Poznań"));
        patientsList.add(new Patient("Mariusz", "Misiorny","haslo",48072685251L, "mariuszmisiorny", "mariusz.misiorny@gmail.com", 852451267, "ul. Mickiewicza 55/23", "01-625", "Warszawa"));
        patientsList.add(new Patient("Agnieszka", "Sochaczewska","haslo",98122575235L, "agsoch", "aga.socha@onet.pl", 695264216, "ul. Alojzego Felińskiego 14", "01-513", "Warszawa"));
        patientsList.add(new Patient("Katarzyna", "Politowicz","haslo",67071975251L, "kpolitowicz", "polkata@onet.pl", 515525623, "ul Małeckiego 16/12", "60-707", "Poznań"));
        patientsList.add(new Patient("Katarzyna", "Cichopek","haslo",58090276921L, "kcichopek", "k.cichopek@gmail.com", 725612562, "ul. Małe Garbary 32", "61-756", "Poznań"));
        patientsList.add(new Patient("Tomasz", "Karolak","haslo",65111252612L, "tomciokarol", "tomciokarol@przykladowymail.com", 725516562, "ul. Aleje Solidarności 21/2", "61-512", "Poznań"));
        patientsList.add(new Patient("Robert", "Makłowicz","haslo",54102151362L, "kucharzmistrz", "kucharzmistrz@maklowicz.com", 826125231, "ul. Kucharska 21", "60-523", "Poznań"));
        patientsList.add(new Patient("Snoop", "Dog","haslo",86110425124L, "snoopie", "snoopiedogg@gmail.com", 666666420, "ul. Weedowa 4/20", "60-420", "Poznań"));
        patientsList.add(new Patient("Edyta", "Górniak","haslo",79041252123L, "edziaantyszczepionka", "antyszczepionkowa@gmail.com", 752621272, "ul. Antyszczepionkwa 21", "61-215", "Poznań"));
        patientsList.add(new Patient("Iwan", "Delfin","haslo",65050276213L, "iwanplywak", "plywamzdelfinami@onet.eu", 627631234, "ul. Delfiny i orki 21", "61-521", "Poznań"));

    }

    public ArrayList<Patient> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(ArrayList<Patient> patientsList) {
        this.patientsList = patientsList;
    }
}
