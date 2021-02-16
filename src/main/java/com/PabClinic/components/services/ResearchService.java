package com.PabClinic.components.services;

import com.PabClinic.components.repositories.ResearchRepository;
import com.PabClinic.model.dtos.ResearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResearchService {

    private ResearchRepository researchRepository;

    @Autowired
    public ResearchService(ResearchRepository researchRepository) {
        this.researchRepository = researchRepository;
    }

    public List<ResearchDTO> getAllResearches(){

        return researchRepository.getResearches();

    }
}
