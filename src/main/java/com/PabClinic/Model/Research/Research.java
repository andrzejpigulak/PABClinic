package com.PabClinic.Model.Research;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Research {

    private int badanie_id;
    private String nazwaBadania;
    private int cenaBadania;

}
