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
@Table(name = "pquarter")
public class PQuarter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String period;

    int target;

    int done;
}
