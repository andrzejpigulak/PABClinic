package com.pabclinic.model.daos.security;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoleDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private String role;

    public RoleDAO() {
    }

    public RoleDAO(String username, String role) {
        this.username = username;
        this.role = role;
    }

}
