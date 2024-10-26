package com.pandora.pandora_project.service;

import com.pandora.pandora_project.dto.*;
import com.pandora.pandora_project.model.*;
import com.pandora.pandora_project.repository.MemberRepository;
import com.pandora.pandora_project.repository.PMORepository;
import com.pandora.pandora_project.repository.ProductOwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
        PMO pmo = pmoRepository.findByEmail(email);
        if(pmo != null && pmo.getPassword().equals(password)){
            return new LoginDTO(pmo.getId(), pmo.getName(), "PMO");
        }

        ProductOwner productowner = productownerRepository.findByEmail(email);
        if(productowner != null && productowner.getPassword().equals(password)){
            return new LoginDTO(productowner.getId(), productowner.getName(), "Product Owner");
        }

        Member member = memberRepository.findByEmail(email);
        if(member != null && member.getPassword().equals(password)){
            return new LoginDTO(member.getId(), member.getName(), "Member");
        }

        return new LoginDTO(0, "Error not found", "Error");
    }

    @Transactional
    public void register(String name, String email, String password, Long poId) {
        ProductOwner productOwner = productownerRepository.getReferenceById(poId);

        List<KQuarter> kquarters = new ArrayList<>();
        kquarters.add(new KQuarter("Q1"));
        kquarters.add(new KQuarter("Q2"));
        kquarters.add(new KQuarter("Q3"));
        kquarters.add(new KQuarter("Q4"));

        KPI kpi = new KPI();
        kpi.setKquarters(kquarters);

        Member member = new Member(
                name,
                createUdomain(),
                productOwner.getUdomain(),
                email,
                productOwner.getBiro(),
                "S7",
                password
        );
        member.setKpi(kpi);
        member.setProductowner(productOwner);
        memberRepository.save(member);
    }
    private String createUdomain(){
        int memberTotal = memberRepository.findAll().size();
        return "U"+memberTotal;
    }

    // 3
    public ListProductOwnerDTO getAllProductOwner(){
        List<ProductOwner> productOwnerList = productownerRepository.findAll();
        List<ProductOwnerD> result = new ArrayList<>();

        for(ProductOwner productOwner: productOwnerList){
            result.add(new ProductOwnerD(productOwner.getId(), productOwner.getName()));
        }
        return new ListProductOwnerDTO(result);
    }

    // 5
    public LaporanProductDTO getProductByProductOwner(long productOwnerId){
        int subtaskSize = 0;

        ProductOwner productOwner = productownerRepository.getReferenceById(productOwnerId);
        Product product = productOwner.getProduct();

        ProductD productD = new ProductD(product.getName(), product.getMico(), product.getIdblueprint());
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

    private String whatFeatureThiSubtask(Product product, Subtask subtask){
        for(Feature feature: product.getFeatures()){
            for(Subtask subtask1: feature.getSubtasks()){
                if(subtask1.getCode().equals(subtask.getCode())){
                    return feature.getCode();
                }
            }
        }
        return null;
    }
    private int totalOfFeatureInvolvedMember(Member member){
        HashSet<String> featureCodeHashSet = new HashSet<>();
        Product product = member.getProductowner().getProduct();
        for(Subtask subtask: member.getSubtasks()){
            featureCodeHashSet.add(whatFeatureThiSubtask(product, subtask));
        }
        return featureCodeHashSet.size();
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
            memberD.setTotalFeature(totalOfFeatureInvolvedMember(member)); // fix later
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
                                kquarter.getPeriod(),
                                kquarter.getTarget(),
                                kquarter.getDone(),
                                Double.toString((double) kquarter.getDone() / (double)kquarter.getTarget()*100) +"%" ,
                                kquarter.getCust_focus(),
                                kquarter.getIntegrity(),
                                kquarter.getTeamwork(),
                                kquarter.getCpoe(),
                                (kquarter.getCust_focus()+kquarter.getIntegrity()+kquarter.getTeamwork()+kquarter.getCpoe())/4,
                                kquarter.getOn_schedule(),
                                kquarter.getLate()
                        )
                );
            }


            MemberKPID memberKPID = new MemberKPID();
            memberKPID.setUdomain(member.getUdomain());
            memberKPID.setName(member.getName());
            memberKPID.setProductName(member.getProductowner().getProduct().getName());
            memberKPID.setRole("Member"); // fix later
            memberKPID.setKpiProductSore(member.getProductowner().getProduct().getKpi_product_score());
            memberKPID.setKquarters(kquarterDList);

            memberKPIDList.add(memberKPID);
        }
        return new LaporanMemberKPIDTO(memberKPIDList);
    }
    // 12
    public ListProductOwnerDTO getAllProductOwnerByPMO(long pmoId){
        PMO pmo = pmoRepository.getReferenceById(pmoId);

        List<ProductOwner> productOwnerList = pmo.getProductowners();
        List<ProductOwnerD> result = new ArrayList<>();

        for(ProductOwner productOwner: productOwnerList){
            result.add(new ProductOwnerD(productOwner.getId(), productOwner.getName()));
        }
        return new ListProductOwnerDTO(result);
    }

    // 13
    public MasterUserDTO getAllUserByPMO(long pmoId){
        PMO pmo = pmoRepository.getReferenceById(pmoId);

        List<ProductOwner> productOwnerList = pmo.getProductowners();

        List<UserD> userDList = new ArrayList<>();
        for(ProductOwner productOwner: productOwnerList){
            userDList.add(
                new UserD(
                        productOwner.getId(),
                        productOwner.getName(),
                        productOwner.getUdomain(),
                        productOwner.getEmail(),
                        productOwner.getDivision(),
                        productOwner.getBiro(),
                        productOwner.getEselon_tier(),
                        "Product Owner"
                )
            );
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
                                "Member"
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
                            product.getIdblueprint(),
                            product.getName(),
                            product.getMico(),
                            product.getProductowner().getName()
                    )
            );
        }
        return new MasterProductDTO(productInfoDList);
    }

    // 17
    public MasterUserProductDTO getAllUserJoinProduct(long pmoId){
        PMO pmo = pmoRepository.getReferenceById(pmoId);
        List<UserProductD> userProductDList = new ArrayList<>();

        for(ProductOwner productOwner: pmo.getProductowners()){
            for(Member member: productOwner.getMembers()){
                UserProductD userProduct = new UserProductD();
                userProduct.setName(member.getName());
                userProduct.setUdomain(member.getUdomain());
                userProduct.setIdBluePrint(productOwner.getProduct().getIdblueprint());
                userProduct.setProductName(productOwner.getProduct().getName());

                userProductDList.add(userProduct);
            }
        }
        return new MasterUserProductDTO(userProductDList);
    }

    // 19
    public MemberMainPageDTO getOtherMember(long memberId){
        ProductOwner productOwner = memberRepository.getReferenceById(memberId).getProductowner();

        List<OtherMemberD> otherMemberDList = new ArrayList<>();
        for(Member member: productOwner.getMembers()){
            if(member.getId() == memberId){
                continue;
            }
            OtherMemberD otherMember = new OtherMemberD(
                    member.getId(),
                    member.getName()
            );
            otherMemberDList.add(otherMember);
        }
        return new MemberMainPageDTO(otherMemberDList);
    }

}