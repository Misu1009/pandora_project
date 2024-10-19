package com.pandora.pandora_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FeatureD {
    String featureId;
    String name;
    String status;
    String strategicTopic;
    Date startDate;
    Date endDate;
}
