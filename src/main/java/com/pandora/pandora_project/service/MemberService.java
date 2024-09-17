package com.pandora.pandora_project.service;

import com.pandora.pandora_project.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService{
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

//    public boolean rate(String udomain, double cust_focus, double integrity, double teamwork, dowble cpoe){
//
//    }
//    public void convertToExcel(List<Member> members){
//
//    }
}