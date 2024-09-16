package com.pandora.pandora_project.model;

import java.util.Date;

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
@Table(name = "subtask")
public class Subtask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String code;
    String name;
    String status;
    Date start_date;
    Date end_date;

    @JsonIgnoreProperties("subtasks")
    @ManyToOne
    @JoinColumn(name="member_id", nullable = true)
    Member member;

    @JsonIgnoreProperties("subtasks")
    @ManyToOne
    @JoinColumn(name="feature_id", nullable = true)
    Feature feature;

    public Subtask(String code, String name, String status, Date start_date, Date end_date) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.start_date = start_date;
        this.end_date = end_date;
        this.member = null;
        this.feature = null;
    }
}
