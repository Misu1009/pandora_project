package com.pandora.pandora_project.service;

import com.pandora.pandora_project.repository.MemberRepository;
import com.pandora.pandora_project.repository.PMORepository;
import com.pandora.pandora_project.repository.ProductOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService{
    private final PMORepository pmoRepository;
    private final ProductOwnerRepository productownerRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public UserService(PMORepository pmoRepository, ProductOwnerRepository productownerRepository, MemberRepository memberRepository){
        this.pmoRepository = pmoRepository;
        this.productownerRepository = productownerRepository;
        this.memberRepository = memberRepository;
    }

//    public Pmo loginAsPmo(String email, String password){
//
//    }
//    public ProductOwner loginAsProductOwner(String email, String password){
//
//    }
//    public Member loginAsMember(String email, String password){
//
//    }
//
//    public boolean register(String name, String email, String password, Long poId){
//
//    }
//
//    public boolean updateUser(String name, String eselon_tier){
//
//    }
}