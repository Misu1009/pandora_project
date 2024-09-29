package com.pandora.pandora_project.jira;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeatureDb {
    String code;
    String name;
    String status;
    String strategic_topic;
    Date start_date;
    Date end_date;
    List<SubtaskDb> subtasks;
}
