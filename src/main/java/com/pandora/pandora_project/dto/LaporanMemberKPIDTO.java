package com.pandora.pandora_project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LaporanMemberKPIDTO {
    List<MemberKPID> memberKPIDList;
}
