package com.pandora.pandora_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfoD {
    long id;
    String idBlueprint;
    String name;
    String mico;
    String productOwnerName;
}
