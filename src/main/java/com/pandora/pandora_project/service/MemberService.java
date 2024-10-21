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
import java.util.List;

@Service
public class MemberService{
    private final MemberRepository memberRepository;
    private final KquarterRepository kquarterRepository;
    private final RatedMemberList ratedMemberList;

    @Autowired
    public MemberService(MemberRepository memberRepository, KquarterRepository kquarterRepository, RatedMemberList ratedMemberList){
        this.memberRepository = memberRepository;
        this.kquarterRepository = kquarterRepository;
        this.ratedMemberList = ratedMemberList;
    }

    @Transactional
    public boolean rate(long senderId, long id, String period, double cust_focus, double integrity, double teamwork, double cpoe){
        if(!checkRatingSenderEligible(senderId, id, period)){
            return false;
        }

        Member member = memberRepository.getReferenceById(id);
        KPI kpi = member.getKpi();
        List<KQuarter> kQuarters = kpi.getKquarters();

        for(KQuarter kQuarter: kQuarters){
            if(kQuarter.getPeriod().equals(period)){
                RatedMember ratedMember = findRatedMemberByMemberId(id, period);
                if(ratedMember == null){
                    RatedMember temp = new RatedMember(id, period, new ArrayList<>());
                    this.ratedMemberList.getList().add(temp);

                    kQuarter.setCust_focus(cust_focus);
                    kQuarter.setIntegrity(integrity);
                    kQuarter.setTeamwork(teamwork);
                    kQuarter.setCpoe(cpoe);
                    kquarterRepository.save(kQuarter);

                    findRatedMemberByMemberId(id, period).getRatingMemberList().add(memberRepository.getReferenceById(senderId));
                    break;
                }
                ratedMember.getRatingMemberList().add(memberRepository.getReferenceById(senderId));
                double devide = ratedMember.getRatingMemberList().size();
                kQuarter.setCust_focus(kQuarter.getCust_focus() + cust_focus/devide);
                kQuarter.setIntegrity(kQuarter.getCust_focus() + integrity/devide);
                kQuarter.setTeamwork(kQuarter.getCust_focus() + teamwork/devide);
                kQuarter.setCpoe(kQuarter.getCust_focus() + cpoe/devide);
                kquarterRepository.save(kQuarter);
                break;
            }
        }
        return true;
    }

    public RatedMember findRatedMemberByMemberId(long memberId, String period){
        for(RatedMember ratedMember: this.ratedMemberList.getList()){
            if(ratedMember.getMemberId() == memberId && ratedMember.getPeriod().equals(period)){
                return ratedMember;
            }
        }
        return null;
    }

    public boolean checkRatingSenderEligible(long senderId, long memberId, String period){
        RatedMember ratedMember = findRatedMemberByMemberId(memberId, period);

        if(ratedMember == null){
            return true;
        }
        for(Member member: ratedMember.getRatingMemberList()){
            if(member.getId() == senderId){ // sender, one of the member that rate other member
                return false;
            }
        }
        return true;
    }

}