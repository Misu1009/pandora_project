package com.pandora.pandora_project.jira;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Feature {
    String code;
    Date start_date;
    Date end_date;
    List<Subtask> subtasks;
}
