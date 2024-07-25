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

    KPI kpi;

    List<Subtask> subtasks;

    ProductOwner product_owner;

    public Member() {
        super();
        this.kpi = null;
        this.subtasks = null;
        this.product_owner = null;
    }
}
