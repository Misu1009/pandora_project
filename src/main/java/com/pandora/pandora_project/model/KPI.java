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
@Table(name = "kpi")
public class KPI {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Double final_score;

    List<KQuarter> kquarters;
}
