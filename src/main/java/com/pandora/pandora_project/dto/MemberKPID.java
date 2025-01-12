package com.pandora.pandora_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberKPID {
    String udomain;
    String name;
    String productName;
    String role;
    double kpiProductSore;
    List<KQuarterD> kquarters;
    double kpiFinal;
}
