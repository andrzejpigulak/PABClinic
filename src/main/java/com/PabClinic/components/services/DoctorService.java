package com.PabClinic.components.services;
import com.PabClinic.components.repositories.DoctorRepository;
import com.PabClinic.model.dtos.DoctorDTO;
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

    public void removeDoctor(DoctorDTO doctorDTO){

        doctorRepository.removeDoctor(doctorDTO);

    }

    public DoctorDTO findDoctor(DoctorDTO doctorDTO) {

        return doctorRepository.findDoctor(doctorDTO);
    }

    public void editDoctor(DoctorDTO doctorDTO) {

        doctorRepository.updateDoctor(doctorDTO);
    }


}
