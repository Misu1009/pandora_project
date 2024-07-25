package com.pandora.pandora_project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    String udomain;

    String division;

    String email;

    String biro;

    String eselon_tier;

    String password;

    public User(String name, String udomain, String division, String email, String biro, String eselon_tier, String password) {
        this.name = name;
        this.udomain = udomain;
        this.division = division;
        this.email = email;
        this.biro = biro;
        this.eselon_tier = eselon_tier;
        this.password = password;
    }
}
