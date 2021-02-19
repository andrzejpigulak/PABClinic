package com.pabclinic.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResearchDTO {

    private int research_id;
    private String researchName;
    private int researchPrice;

}
