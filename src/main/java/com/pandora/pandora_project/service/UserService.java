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

    // 8
    public LaporanMemberDTO getAllMemberByProductOwner(long productOwnerId){
        ProductOwner productOwner = productownerRepository.getReferenceById(productOwnerId);

        List<MemberD> memberDList = new ArrayList<>();
        for(Member member: productOwner.getMembers()){
            List<SubtaskD> subtaskDList = new ArrayList<>();
            for(Subtask subtask: member.getSubtasks()){
                subtaskDList.add(
                        new SubtaskD(
                                subtask.getCode(),
                                subtask.getName(),
                                subtask.getStatus(),
                                subtask.getStart_date(),
                                subtask.getEnd_date()
                        )
                );
            }

            MemberD memberD = new MemberD();
            memberD.setName(member.getName());
            memberD.setDivision(member.getDivision());
            memberD.setEmail(member.getEmail());
            memberD.setTotalFeature(100); // fix later
            memberD.setTotalSubtask(member.getSubtasks().size());
            memberD.setSubtasks(subtaskDList);

            memberDList.add(memberD);
        }

        return new LaporanMemberDTO(memberDList);
    }

    // 10
    public LaporanMemberKPIDTO getAllMemberKPIByProductOwner(long productOwnerId){
        ProductOwner productOwner = productownerRepository.getReferenceById(productOwnerId);

        List<MemberKPID> memberKPIDList = new ArrayList<>();
        for(Member member: productOwner.getMembers()){
            List<KQuarterD> kquarterDList = new ArrayList<>();
            for(KQuarter kquarter: member.getKpi().getKquarters()){
                kquarterDList.add(
                        new KQuarterD(
                                kquarter.getTarget(),
                                kquarter.getDone(),
                                kquarter.getCust_focus(),
                                kquarter.getIntegrity(),
                                kquarter.getTeamwork(),
                                kquarter.getCpoe(),
                                kquarter.getOn_schedule(),
                                kquarter.getLate()
                        )
                );
            }

            MemberKPID memberKPID = new MemberKPID();
            memberKPID.setUdomain(member.getUdomain());
            memberKPID.setName(member.getName());
            memberKPID.setProductName(member.getProductowner().getProduct().getName());
            memberKPID.setRole("User"); // fix later
            memberKPID.setKpiProductSore(member.getProductowner().getProduct().getKpi_product_score());
            memberKPID.setKquarters(kquarterDList);

            memberKPIDList.add(memberKPID);
        }
        return new LaporanMemberKPIDTO(memberKPIDList);
    }
    // 12
    public List<ProductOwnerD> getAllProductOwnerByPMO(long pmoId){
        PMO pmo = pmoRepository.getReferenceById(pmoId);

        List<ProductOwner> productOwnerList = pmo.getProductowners();
        List<ProductOwnerD> result = new ArrayList<>();

        for(ProductOwner productOwner: productOwnerList){
            result.add(new ProductOwnerD(productOwner.getId(), productOwner.getName()));
        }
        return result;
    }

    // 13
    public MasterUserDTO getAllUserByPMO(long pmoId){
        PMO pmo = pmoRepository.getReferenceById(pmoId);

        List<ProductOwner> productOwnerList = pmo.getProductowners();

        List<UserD> userDList = new ArrayList<>();
        for(ProductOwner productOwner: productOwnerList){
            for(Member member: productOwner.getMembers()){
                userDList.add(
                        new UserD(
                                member.getId(),
                                member.getName(),
                                member.getUdomain(),
                                member.getEmail(),
                                member.getDivision(),
                                member.getBiro(),
                                member.getEselon_tier(),
                                "User"
                        )
                );
            }
        }
        return new MasterUserDTO(userDList);
    }

    // 15
    public MasterProductDTO getAllProductByPMO(long pmoId){
        PMO pmo = pmoRepository.getReferenceById(pmoId);

        List<ProductOwner> productOwnerList = pmo.getProductowners();

        List<ProductInfoD> productInfoDList = new ArrayList<>();
        for(ProductOwner productOwner: productOwnerList){
            Product product = productOwner.getProduct();

            productInfoDList.add(
                    new ProductInfoD(
                            product.getId(),
                            product.getId_blueprint(),
                            product.getName(),
                            product.getMico(),
                            product.getProductowner().getName()
                    )
            );
        }
        return new MasterProductDTO(productInfoDList);
    }

}