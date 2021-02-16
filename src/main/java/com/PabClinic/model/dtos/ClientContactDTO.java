package com.PabClinic.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientContactDTO {

    private String name;
    private String email;
    private String textMessage;
    private String subject;

}
