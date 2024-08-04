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
@Table(name = "productowner")
public class ProductOwner extends User{

    @OneToOne(mappedBy = "productowner")
    Product product;

    @OneToMany(mappedBy = "productowner", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Member> members;

    public ProductOwner(String name, String udomain, String division, String email, String biro, String eselon_tier, String password) {
        super(name, udomain, division, email, biro, eselon_tier, password);
        this.product = null;
        this.members = null;
    }
}
