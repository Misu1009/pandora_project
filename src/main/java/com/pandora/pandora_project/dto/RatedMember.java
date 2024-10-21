package com.pandora.pandora_project.dto;


import com.pandora.pandora_project.model.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RatedMember {
    long memberId;
    String period;
    List<Member> ratingMemberList;
}