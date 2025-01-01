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
public class LaporanProductDTO{
    ProductD product;
    String productOwnerName;
    int totalFeature;
    int totalSubtask;
    Double kpiScore;
    List<PQuarterD> pquarters;
    List<FeatureD> features;
    int annualTarget;
    int annualDone;
}
