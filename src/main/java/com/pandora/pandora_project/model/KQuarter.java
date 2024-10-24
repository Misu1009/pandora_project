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

    public KQuarter(String period, int target, int done, Double cust_focus, Double integrity, Double teamwork, Double cpoe, int on_schedule, int late) {
        this.period = period;
        this.target = target;
        this.done = done;
        this.cust_focus = cust_focus;
        this.integrity = integrity;
        this.teamwork = teamwork;
        this.cpoe = cpoe;
        this.on_schedule = on_schedule;
        this.late = late;
    }

    public KQuarter(String period) {
        this.period = period;
        this.target = 0;
        this.done = 0;
        this.cust_focus = 0.0;
        this.integrity = 0.0;
        this.teamwork = 0.0;
        this.cpoe = 0.0;
        this.on_schedule = 0;
        this.late = 0;
    }

}
