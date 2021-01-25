package com.PabClinic.Model.Doctor;

import com.PabClinic.Model.enums.Specialisation;

import java.util.ArrayList;

public class DoctorFabrik {

    private ArrayList<Doctor> doctorList = new ArrayList<>();

    public DoctorFabrik() {
        doctorList.add(new Doctor("Mateusz", "Borek", "matRod", "meteuszborek", Specialisation.LEKARZRODZINNY));
        doctorList.add(new Doctor("Tomasz", "Smokowski", "tomRod", "tomaszsmokowski", Specialisation.LEKARZRODZINNY));
        doctorList.add(new Doctor("Krzyszto", "Stanowski", "krzRod", "krzysztofstanowski", Specialisation.LEKARZRODZINNY));
        doctorList.add(new Doctor("Michał", "Pol", "michRod", "michalpol", Specialisation.LEKARZRODZINNY));
        doctorList.add(new Doctor("Anna", "Dermatologowa", "annaDer", "annadermatologowa", Specialisation.DERMATOLOG));
        doctorList.add(new Doctor("Radosław", "Majdan", "radGin", "radoslawmajdan", Specialisation.GINEKOLOG));
        doctorList.add(new Doctor("Edgar", "Davids", "edgarOku", "edgardavids", Specialisation.OKULISTA));
        doctorList.add(new Doctor("Marcin", "Wasilewski", "marOrt", "marcinwasilewski", Specialisation.ORTOPEDA));
        doctorList.add(new Doctor("Katarzyna", "Selwant", "katPsy", "katarzynaselwant", Specialisation.PSYCHOLOG));
        doctorList.add(new Doctor("Tomasz", "Hajto", "tomPsy", "tomaszhajto", Specialisation.PSYCHIATRA));
        doctorList.add(new Doctor("Franz", "Smuda", "fraLar", "franzsmuda", Specialisation.LARYNGOLOG));
        doctorList.add(new Doctor("Petr", "Cech", "petrNeu", "petrcech", Specialisation.NEUROLOG));
        doctorList.add(new Doctor("Ewelina", "Sterczewska", "eweUro", "ewasterczewska", Specialisation.UROLOG));
        doctorList.add(new Doctor("Zofia", "Puk", "zofiaPol", "zofiapuk", Specialisation.POLOZNA));
        doctorList.add(new Doctor("Joanna", "Arcykoronna", "joaPie", "joannaarcykoronna", Specialisation.PIELEGNIARKA));
        doctorList.add(new Doctor("Władysława", "Kowalska", "wlaPie", "wladyslawakowalska", Specialisation.PIELEGNIARKA));
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(ArrayList<Doctor> doctorList) {
        this.doctorList = doctorList;
    }
}
