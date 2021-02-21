package com.pabclinic.services;

import com.pabclinic.repositories.ResearchRepository;
import com.pabclinic.model.dtos.ResearchDTO;
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

    public void removeResearch(String researchName){

        researchRepository.removeResearch(researchName);

    }
}
