package com.pabclinic.model.daos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResearchDAO {

    private int badanie_id;
    private String nazwaBadania;
    private int cenaBadania;

}
