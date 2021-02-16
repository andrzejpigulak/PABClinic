package com.PabClinic.components.configurations;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String role;

    public Role() {
    }

    public Role(String login, String role) {
        this.login = login;
        this.role = role;
    }

}
