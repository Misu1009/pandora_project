package com.pandora.pandora_project.model;

import java.util.Date;

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
    String udomain;

    public Subtask(String code, String name, String status, Date start_date, Date end_date, String udomain) {
        this.code = code;
        this.name = name;
        this.status = status;
        this.start_date = start_date;
        this.end_date = end_date;
        this.udomain = udomain;
    }
}
