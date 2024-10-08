package com.pandora.pandora_project.service;

import com.pandora.pandora_project.dto.*;
import com.pandora.pandora_project.model.*;
import com.pandora.pandora_project.repository.MemberRepository;
import com.pandora.pandora_project.repository.PMORepository;
import com.pandora.pandora_project.repository.ProductOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    // 3
    public List<ProductOwnerD> getAllProductOwner(){
        List<ProductOwner> productOwnerList = productownerRepository.findAll();
        List<ProductOwnerD> result = new ArrayList<>();

        for(ProductOwner productOwner: productOwnerList){
            result.add(new ProductOwnerD(productOwner.getId(), productOwner.getName()));
        }
        return result;
    }

    // 5
    public LaporanProductDTO getProductByProductOwner(long productOwnerId){
        int subtaskSize = 0;

        ProductOwner productOwner = productownerRepository.getReferenceById(productOwnerId);
        Product product = productOwner.getProduct();

        ProductD productD = new ProductD(product.getName(), product.getMico(), product.getId_blueprint());
        List<PQuarterD> pQuarterDs = new ArrayList<>();
        List<FeatureD> featureDs = new ArrayList<>();

        for(PQuarter pQuarter: product.getPquarters()){
            pQuarterDs.add(new PQuarterD(pQuarter.getPeriod(), pQuarter.getTarget(), pQuarter.getDone()));
        }
        for(Feature feature: product.getFeatures()){
            featureDs.add(
                    new FeatureD(
                            feature.getId().toString(),
                            feature.getName(),
                            feature.getStatus(),
                            feature.getStrategic_topic(),
                            feature.getStart_date(),
                            feature.getEnd_date()
                    )
            );
            subtaskSize+=feature.getSubtasks().size();
        }

        LaporanProductDTO laporanProductDTO = new LaporanProductDTO();
        laporanProductDTO.setProduct(productD);
        laporanProductDTO.setPquarters(pQuarterDs);
        laporanProductDTO.setFeatures(featureDs);

        laporanProductDTO.setProductOwnerName(productOwner.getName());
        laporanProductDTO.setTotalFeature(featureDs.size());
        laporanProductDTO.setTotalSubtask(subtaskSize);
        laporanProductDTO.setKpiScore(product.getKpi_product_score());

        return laporanProductDTO;
    }
}