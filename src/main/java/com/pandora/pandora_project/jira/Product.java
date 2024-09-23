package com.pandora.pandora_project.jira;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    String id_blurprint;
    List<PQuarter> pquarters;
    List<Feature> features;
}
