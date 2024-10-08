package com.pandora.pandora_project.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class FeatureD {
    String featureId;
    String name;
    String status;
    String strategicTopic;
    Date startDate;
    Date endDate;
}
