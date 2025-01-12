package com.pandora.pandora_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KQuarterD {
    String period;
    int target;
    int done;
    String ach;
    double custFocus;
    double integrity;
    double teamwork;
    double cpoe;
    double average;
    int onSchedule;
    int late;
}
