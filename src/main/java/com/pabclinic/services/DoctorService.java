package com.pabclinic.services;
import com.pabclinic.repositories.DoctorRepository;
import com.pabclinic.model.dtos.DoctorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorDTO> getAllDoctors(){

        return doctorRepository.getDoctors();
    }

    public void registerDoctor(DoctorDTO doctorDTO) {

        doctorRepository.addDoctor(doctorDTO);

    }

    public void removeDoctor(String login){

        doctorRepository.removeDoctor(login);

    }

    public DoctorDTO findDoctor(DoctorDTO doctorDTO) {

        return doctorRepository.findDoctor(doctorDTO);
    }

    public DoctorDTO findDoctorByUsername(String login) {

        return doctorRepository.findDoctorByUsernameFromDb(login);
    }

    public void editDoctor(DoctorDTO doctorDTO) {

        doctorRepository.updateDoctor(doctorDTO);
    }


}
