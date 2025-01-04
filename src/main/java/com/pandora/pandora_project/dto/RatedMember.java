package com.pandora.pandora_project.dto;


import com.pandora.pandora_project.model.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ratedMember")
public class RatedMember {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    long ratingMemberId;
    long ratedMemberId;
    String period;

    public RatedMember(long ratingMemberId, long ratedMemberId, String period){
        this.ratingMemberId = ratingMemberId;
        this.ratedMemberId = ratedMemberId;
        this.period = period;
    }
}