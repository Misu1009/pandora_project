package com.pandora.pandora_project.jira;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubtaskDb {
    String code;
    String name;
    String status;
    Date start_date;
    Date end_date;
    String udomain;
}
