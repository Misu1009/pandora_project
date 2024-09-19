package com.pandora.pandora_project.dto;

import java.util.List;

public class LaporanProductDTO{
    Product product;
    String productOwnerName;
    int totalFeature;
    int totalSubtask;
    Double kpiScore;
    List<PQuarter> pquarters;
    List<Feature> features;
}
