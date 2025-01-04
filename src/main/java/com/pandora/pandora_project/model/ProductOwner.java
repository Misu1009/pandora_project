package com.pandora.pandora_project.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pandora.pandora_project.dto.RatedMember;
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
@Table(name = "productowner")
public class ProductOwner{
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

    @JsonIgnoreProperties("productowner")
    @OneToOne(mappedBy = "productowner", cascade=CascadeType.ALL)
    Product product;

    @JsonIgnoreProperties("productowner")
    @OneToMany(mappedBy = "productowner", cascade=CascadeType.ALL, orphanRemoval = true)
    List<Member> members;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    List<RatedMember> rateFlag;

    public ProductOwner(String name, String udomain, String division, String email, String biro, String eselon_tier, String password) {
        this.name = name;
        this.udomain = udomain;
        this.division = division;
        this.email = email;
        this.biro = biro;
        this.eselon_tier = eselon_tier;
        this.password = password;

        this.product = null;
        this.members = null;
        this.rateFlag = new ArrayList<>();
    }

}
