package com.pandora.pandora_project.service;

import com.pandora.pandora_project.dto.LoginDTO;
import com.pandora.pandora_project.model.KPI;
import com.pandora.pandora_project.model.Member;
import com.pandora.pandora_project.model.PMO;
import com.pandora.pandora_project.model.ProductOwner;
import com.pandora.pandora_project.repository.MemberRepository;
import com.pandora.pandora_project.repository.PMORepository;
import com.pandora.pandora_project.repository.ProductOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public LoginDTO login(String email, String password){
        PMO pmo = pmoRepository.findbyemail(email);
        if(pmo != null && pmo.getPassword().equals(password)){
            return new LoginDTO(pmo.getId(), pmo.getName(), "PMO");
        }

        ProductOwner productowner = productownerRepository.findbyemail(email);
        if(productowner != null && productowner.getPassword().equals(password)){
            return new LoginDTO(productowner.getId(), productowner.getName(), "Product Owner");
        }

        Member member = memberRepository.findbyemail(email);
        if(member != null && member.getPassword().equals(password)){
            return new LoginDTO(member.getId(), member.getName(), "Member");
        }

        return new LoginDTO(0, "Error not found", "Error");
    }

    public void register(String name, String udomain, String division, String email, String password, Long poId) {
        Optional<ProductOwner> productOwner = productownerRepository.findById(poId);
        if (productOwner.isEmpty()) {
            throw new IllegalStateException("Product Owner is not found");
        }
        ProductOwner productOwner2 = productOwner.get();
        // bikin member pake semua data + dari po + buatin kpi baru
        KPI kpi = new KPI();
        Member member = new Member(
                name,
                udomain,
                division,
                email,
                productOwner2.getBiro(),
                "S7",
                password
        );
        member.setKpi(kpi);
        memberRepository.save(member);
    }
//
//    public boolean updateUser(String name, String eselon_tier){
//
//    }
}