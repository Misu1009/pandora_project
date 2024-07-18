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
@Table(name = "kquarter")
public class KQuarter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String period;

    int target;

    int done;

    Double cust_focus;

    Double integrity;

    Double teamwork;

    Double cpoe;

    int on_schedule;

    int late;

}
