package com.pandora.pandora_project.model;

import java.util.Date;
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
@Table(name = "feature")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String code;
    String name;
    String status;
    String strategic_topic;
    Date start_date;
    Date end_date;

    @JsonIgnoreProperties("feature")
    @OneToMany(mappedBy = "feature", cascade=CascadeType.ALL, orphanRemoval = true)
    List<Subtask> subtasks;

    public Feature(String code, String name, String status, String strategic_topic, Date start_date, Date end_date) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.strategic_topic = strategic_topic;
        this.start_date = start_date;
        this.end_date = end_date;
        this.subtasks = null;
    }
}
//Menambahkan json ignore 7:55 6/8/2024
