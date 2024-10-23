package com.pandora.pandora_project.model;

import java.util.ArrayList;
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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String idblueprint;
    String name;
    String mico;
    Double kpi_product_score;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    List<PQuarter> pquarters;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    List<Feature> features;

    @JsonIgnoreProperties("product")
    @OneToOne()
    @JoinColumn(name = "productowner_id", nullable = true)
    ProductOwner productowner;

    public Product(String id_blueprint, String name, String mico, Double kpi_product_score) {
        this.idblueprint = id_blueprint;
        this.name = name;
        this.mico = mico;
        this.kpi_product_score = kpi_product_score;

        this.features = null;
        this.productowner = null;
        this.pquarters = null;
    }
}
