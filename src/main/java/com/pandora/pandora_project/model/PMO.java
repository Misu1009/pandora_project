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
public class PMO extends User{

    @OneToMany(mappedBy = "pmo", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<ProductOwner> productowners;

    public PMO(String name, String udomain, String division, String email, String biro, String eselon_tier, String password) {
        super(name, udomain, division, email, biro, eselon_tier, password);
        this.productowners = null;
    }
}
