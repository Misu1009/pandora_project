package com.pandora.pandora_project.service;

import com.pandora.pandora_project.model.KPI;
import com.pandora.pandora_project.model.KQuarter;
import com.pandora.pandora_project.model.Member;
import com.pandora.pandora_project.repository.KpiRepository;
import com.pandora.pandora_project.repository.KquarterRepository;
import com.pandora.pandora_project.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService{
    private final MemberRepository memberRepository;
    private final KquarterRepository kquarterRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository, KquarterRepository kquarterRepository){
        this.memberRepository = memberRepository;
        this.kquarterRepository = kquarterRepository;
    }

    public void rate(String udomain, String period, double cust_focus, double integrity, double teamwork, double cpoe){
        Member member = memberRepository.findbyudomain(udomain);
        KPI kpi = member.getKpi();
        List<KQuarter> kQuarters = kpi.getKquarters();

        for(KQuarter kQuarter: kQuarters){
            if(kQuarter.getPeriod().equals(period)){
                kQuarter.setCust_focus(cust_focus);
                kQuarter.setIntegrity(integrity);
                kQuarter.setTeamwork(teamwork);
                kQuarter.setCpoe(cpoe);
                break;
            }
        }
        kquarterRepository.saveAll(kQuarters);
    }

}