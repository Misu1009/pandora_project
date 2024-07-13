package com.pandora.pandora_project.model;

import java.util.List;

public class Product {

    Long id;

    String id_blueprint;

    String name;

    String mico;

    Double kpi_product_score;

    List<PQuarter> quarters;

    List<Feature> features;

    ProductOwner product_owner;
}
