package com.pandora.pandora_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserD {
    long id;
    String name;
    String udomain;
    String email;
    String division;
    String biro;
    String eselonTier;
    String role;
}
