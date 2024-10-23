package com.pandora.pandora_project.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "kpi")
public class KPI {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    Double final_score;

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    List<KQuarter> kquarters;

    public KPI() {
        this.final_score = 0.0;
        this.kquarters = null;
    }
}