package com.pandora.pandora_project.model;

import java.util.Date;
import java.util.List;

public class Feature {
    Long id;

    String code;

    String name;

    String status;

    String strategic_topic;

    Date start_date;

    Date end_date;

    List<Subtask> subtasks;

}
