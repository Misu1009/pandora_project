package com.pandora.pandora_project.jira;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDb {
    String id_blurprint;
    String period1, period2, period3, period4;
    int target1, target2, target3, target4;
    int done1, done2, done3, done4;
    List<FeatureDb> features;
}
