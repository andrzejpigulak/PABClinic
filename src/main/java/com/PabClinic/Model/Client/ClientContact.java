package com.PabClinic.Model.Client;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientContact {

    private String name;
    private String email;
    private String textMessage;
    private String subject;

}
