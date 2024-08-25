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
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String id_blueprint;
    String name;
    String mico;
    Double kpi_product_score;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<PQuarter> quarters;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Feature> features;

    @JsonIgnoreProperties("product")
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "productowner_id", nullable = true)
    ProductOwner productowner;

    public Product(String id_blueprint, String name, String mico, Double kpi_product_score) {
        this.id_blueprint = id_blueprint;
        this.name = name;
        this.mico = mico;
        this.kpi_product_score = kpi_product_score;
        this.quarters = null;
        this.features = null;
        this.productowner = null;
    }
}
