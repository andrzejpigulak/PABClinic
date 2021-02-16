package com.PabClinic.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResearchDTO {

    private int badanie_id;
    private String nazwaBadania;
    private int cenaBadania;

}
