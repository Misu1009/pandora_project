package com.pandora.pandora_project.jira;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PQuarter {
    String id_blueprint;
    int period;
    int target;
    int done;
}
