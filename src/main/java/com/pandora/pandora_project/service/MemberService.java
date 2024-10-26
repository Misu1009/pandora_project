package com.pandora.pandora_project.service;

import com.pandora.pandora_project.dto.RatedMember;
import com.pandora.pandora_project.dto.RatedMemberList;
import com.pandora.pandora_project.model.KPI;
import com.pandora.pandora_project.model.KQuarter;
import com.pandora.pandora_project.model.Member;
import com.pandora.pandora_project.repository.KpiRepository;
import com.pandora.pandora_project.repository.KquarterRepository;
import com.pandora.pandora_project.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MemberService{
    private final MemberRepository memberRepository;
    private final HashMap<String, ArrayList<String>> ratingStatus;

    @Autowired
    public MemberService(MemberRepository memberRepository, HashMap<String, ArrayList<String>> ratingStatus){
        this.memberRepository = memberRepository;
        this.ratingStatus = ratingStatus;
    }

    @Transactional
    public boolean rate(long senderId, long memberId, String period, double cust_focus, double integrity, double teamwork, double cpoe){
        Member member = memberRepository.getReferenceById(memberId);
        Member sender = memberRepository.getReferenceById(senderId);
        int amountOfOtherMember = member.getProductowner().getMembers().size() - 1;
        String key = member.getUdomain()+period;

        if(ratingStatus.get(memberId) == null){ // make new key in hashmap
            ratingStatus.put(key, new ArrayList<>());
        }else{
            for(String senderUdomain: ratingStatus.get(key)){
                if(senderUdomain.equals(sender.getUdomain())){
                    return false;
                }
            }
        }
        ArrayList<String> value = ratingStatus.get(key);

        KPI kpi = member.getKpi();
        List<KQuarter> kQuarters = kpi.getKquarters();

        for(KQuarter kQuarter: kQuarters){
            if(kQuarter.getPeriod().equals(period)){
                kQuarter.setCust_focus(cust_focus/amountOfOtherMember + kQuarter.getCust_focus());
                kQuarter.setIntegrity(integrity/amountOfOtherMember + kQuarter.getIntegrity());
                kQuarter.setTeamwork(teamwork/amountOfOtherMember + kQuarter.getTeamwork());
                kQuarter.setCpoe(cpoe/amountOfOtherMember + kQuarter.getCpoe());

                value.add(sender.getUdomain());
                ratingStatus.put(key, value);
            }
        }
        return true;
    }
}