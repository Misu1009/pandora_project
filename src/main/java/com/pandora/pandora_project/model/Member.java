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
@Table(name = "member")
public class Member extends User{

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "kpi_id")
    KPI kpi;

    @OneToMany(mappedBy = "member", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Subtask> subtasks;

    @ManyToOne
    @JoinColumn(name="productowner_id")
    ProductOwner productowner;

    public Member(String name, String udomain, String division, String email, String biro, String eselon_tier, String password) {
        super(name, udomain, division, email, biro, eselon_tier, password);
        this.kpi = null;
        this.subtasks = null;
        this.productowner = null;
    }
}
// nambah super constructor
