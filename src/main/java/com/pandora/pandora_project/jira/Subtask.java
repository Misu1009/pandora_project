package com.pandora.pandora_project.jira;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Subtask {
    String code;
    String status;
    String udomain;
    Date start_date;
    Date end_date;
}
