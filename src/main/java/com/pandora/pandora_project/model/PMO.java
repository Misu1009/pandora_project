package com.pandora.pandora_project.model;

import java.util.List;

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
@Table(name = "pmo")
public class PMO {
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

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    List<ProductOwner> productowners;

    public PMO(String name, String udomain, String division, String email, String biro, String eselon_tier, String password) {
        this.name = name;
        this.udomain = udomain;
        this.division = division;
        this.email = email;
        this.biro = biro;
        this.eselon_tier = eselon_tier;
        this.password = password;

        this.productowners = null;
    }
}
