package com.pandora.pandora_project.service;

import com.pandora.pandora_project.controller.KPIController;
import com.pandora.pandora_project.controller.MemberController;
import com.pandora.pandora_project.controller.ProductController;
import com.pandora.pandora_project.dto.KQuarterD;
import com.pandora.pandora_project.thirdParty.FeatureDb;
import com.pandora.pandora_project.thirdParty.ProductDb;
import com.pandora.pandora_project.thirdParty.SubtaskDb;
import com.pandora.pandora_project.model.*;
import com.pandora.pandora_project.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class ProductOwnerService{
    private final PMORepository pmoRepository;
    private final ProductOwnerRepository productownerRepository;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    private final List<ProductDb> productDb;
    private final FeatureRepository featureRepository;
    private final PQuarterRepository pQuarterRepository;
    private final SubtaskRepository subtaskRepository;
    private final KquarterRepository kquarterRepository;

    private final ProductController productController;
    private final MemberController memberController;
    private final KPIController kpiController;
//    private final FeatureDb featureDb;
//    private final SubtaskDb subtaskDb;

    @Autowired
    public ProductOwnerService(
            PMORepository pmoRepository,
            ProductOwnerRepository productownerRepository,
            ProductRepository productRepository,
            MemberRepository memberRepository,
            FeatureRepository featureRepository,
            PQuarterRepository pQuarterRepository,
            SubtaskRepository subtaskRepository,
            KquarterRepository kquarterRepository,
            List<ProductDb> productDb,
            ProductController productController,
            MemberController memberController,
            KPIController kpiController
    ){
        this.pmoRepository = pmoRepository;
        this.productownerRepository = productownerRepository;
        this.productRepository = productRepository;
        this.memberRepository = memberRepository;
        this.featureRepository = featureRepository;
        this.pQuarterRepository = pQuarterRepository;
        this.subtaskRepository = subtaskRepository;
        this.kquarterRepository = kquarterRepository;
        this.productDb = productDb;
        this.productController = productController;
        this.memberController = memberController;
        this.kpiController = kpiController;
    }
    public static String PRODUCT_SHEET_NAME = "Product_Data";
    public static String MEMBER_SHEET_NAME = "Member_Data";
    public static String MEMBERKPI_SHEET_NAME = "Member_KPI_Data";

    @Transactional
    public void setKpiProductScore(long id,  double score){
        long productId = productownerRepository.getReferenceById(id).getProduct().getId();

        Product product = productRepository.getReferenceById(productId);
        product.setKpi_product_score(score);
        productRepository.save(product);
    }

    public Feature findFeatureByCode(Product product, String code){
        for(Feature feature: product.getFeatures()){
            if(feature.getCode().equals(code)){
                return feature;
            }
        }
        return null;
    }

    public Subtask findSubtaskByCode(Feature feature, String code){
        for(Subtask subtask: feature.getSubtasks()){
            if(subtask.getCode().equals(code)){
                return subtask;
            }
        }
        return null;
    }

    @Transactional
    public void updateProductDB(ProductDb productDb){
        Product product = productRepository.findByIdblueprint(productDb.getId_blueprint());

        // Pquarter
        List<PQuarter> pquarters = product.getPquarters();
        pquarters.sort(Comparator.comparing(PQuarter::getPeriod));
        PQuarter pQuarter;

        pQuarter = pquarters.get(0);
        pQuarter.setDone(productDb.getDone1());
        pQuarter.setTarget(productDb.getTarget1());
        pQuarterRepository.save(pQuarter);

        pQuarter = pquarters.get(1);
        pQuarter.setDone(productDb.getDone2());
        pQuarter.setTarget(productDb.getTarget2());
        pQuarterRepository.save(pQuarter);

        pQuarter = pquarters.get(2);
        pQuarter.setDone(productDb.getDone3());
        pQuarter.setTarget(productDb.getTarget3());
        pQuarterRepository.save(pQuarter);

        pQuarter = pquarters.get(3);
        pQuarter.setDone(productDb.getDone4());
        pQuarter.setTarget(productDb.getTarget4());
        pQuarterRepository.save(pQuarter);


        // Feature + Subtask

        for(FeatureDb featureDB: productDb.getFeatures()){
            if(findFeatureByCode(product, featureDB.getCode()) != null){ // update feature
                Feature feature = findFeatureByCode(product, featureDB.getCode());
                feature.setName(featureDB.getName());
                feature.setStatus(featureDB.getStatus());
                feature.setStrategic_topic(featureDB.getStrategic_topic());
                feature.setStart_date(featureDB.getStart_date());
                feature.setEnd_date(featureDB.getEnd_date());

                featureRepository.save(feature);

                for(SubtaskDb subtaskDB: featureDB.getSubtasks()){
                    if(findSubtaskByCode(feature, subtaskDB.getCode()) != null){ // update subtask
                        Subtask subtask = findSubtaskByCode(feature, subtaskDB.getCode());
                        subtask.setName(subtaskDB.getName());
                        subtask.setStatus(subtaskDB.getStatus());
                        subtask.setStart_date(subtaskDB.getStart_date());
                        subtask.setEnd_date(subtaskDB.getEnd_date());
                        subtask.setUdomain(subtaskDB.getUdomain());
                        subtaskRepository.save(subtask);
                    } else{ // add new subtask
                        Subtask subtask = new Subtask(
                                subtaskDB.getCode(),
                                subtaskDB.getName(),
                                subtaskDB.getStatus(),
                                subtaskDB.getStart_date(),
                                subtaskDB.getEnd_date(),
                                subtaskDB.getUdomain()
                        );
                        feature.getSubtasks().add(subtask);
                        featureRepository.save(feature);
                    }
                }
            }else{ // add new feature
                List<Subtask> subtasks = new ArrayList<>();
                for(SubtaskDb subtaskDB: featureDB.getSubtasks()){
                    Subtask subtask = new Subtask(
                            subtaskDB.getCode(),
                            subtaskDB.getName(),
                            subtaskDB.getStatus(),
                            subtaskDB.getStart_date(),
                            subtaskDB.getEnd_date(),
                            subtaskDB.getUdomain()
                    );
                    subtasks.add(subtask);
                }
                Feature feature = new Feature();
                feature.setCode(featureDB.getCode());
                feature.setName(featureDB.getName());
                feature.setStatus(featureDB.getStatus());
                feature.setStrategic_topic(featureDB.getStrategic_topic());
                feature.setStart_date(featureDB.getStart_date());
                feature.setEnd_date(featureDB.getEnd_date());
                feature.setSubtasks(subtasks);

                product.getFeatures().add(feature);
                productRepository.save(product);
            }
        }
    }

    private String getQuarter(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int quarter = Math.min(((month / 3) + 1), 4); // Memastikan nilai maksimal adalah 4
        return String.format("Q%d", quarter);
    }

    @Transactional
    public void updateMemberDB(long id){
        ProductOwner productOwner = productownerRepository.getReferenceById(id);

        Product product = productOwner.getProduct();
        List<Feature> features = product.getFeatures();

        for(Feature feature: features){ // loop feature to get each subtask
            for(Subtask subtask: feature.getSubtasks()){ // bind every subtask to it's member
                Member findMember = memberRepository.findByUdomain(subtask.getUdomain());
                if(!checkSubtaskMember(findMember, subtask.getCode())){ // not found, subtask will be bind to member
                    findMember.getSubtasks().add(subtask);
                    memberRepository.save(findMember);
                }
            }
        }
        // target + done
        List<Member> memberList = productOwner.getMembers();
        List<PQuarter> pQuarterList = product.getPquarters();
        pQuarterList.sort(Comparator.comparing(PQuarter::getPeriod));

        for(Member member: memberList){
            List<KQuarter> kquarters = member.getKpi().getKquarters();
            kquarters.sort(Comparator.comparing(KQuarter::getPeriod));

            for(int i=0; i<4; i++){
                kquarters.get(i).setTarget(pQuarterList.get(i).getTarget());
                kquarters.get(i).setDone(pQuarterList.get(i).getDone());
            }
//            // on schedule + late
            Map<String, Integer> onScheduleResult = new HashMap<>();
            Map<String, Integer> lateResult = new HashMap<>();
            onScheduleResult.put("Q1", 0);
            onScheduleResult.put("Q2", 0);
            onScheduleResult.put("Q3", 0);
            onScheduleResult.put("Q4", 0);

            lateResult.put("Q1", 0);
            lateResult.put("Q2", 0);
            lateResult.put("Q3", 0);
            lateResult.put("Q4", 0);

            for(Subtask subtask: member.getSubtasks()){
                String period = getQuarter(subtask.getEnd_date());
                if(subtask.getStatus().equals("In Progress") || subtask.getStatus().equals("To Do")){
                    lateResult.put(period, lateResult.get(period)+1);
                }else{
                    onScheduleResult.put(period, onScheduleResult.get(period)+1);
                }
            }

            kquarters.get(0).setOn_schedule(onScheduleResult.get("Q1"));
            kquarters.get(1).setOn_schedule(onScheduleResult.get("Q2"));
            kquarters.get(2).setOn_schedule(onScheduleResult.get("Q3"));
            kquarters.get(3).setOn_schedule(onScheduleResult.get("Q4"));

            kquarters.get(0).setLate(lateResult.get("Q1"));
            kquarters.get(1).setLate(lateResult.get("Q2"));
            kquarters.get(2).setLate(lateResult.get("Q3"));
            kquarters.get(3).setLate(lateResult.get("Q4"));

            kquarterRepository.saveAll(kquarters);
        }
    }

    public boolean checkSubtaskMember(Member findMember, String code){
        for(Subtask subtaskMember: findMember.getSubtasks()){
            if(subtaskMember.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    @Transactional
    public void synchronize(long id){
        ProductOwner productOwner = productownerRepository.getReferenceById(id);

        ProductDb productDb1 = findProductDBByid_blueprint(productOwner.getProduct().getIdblueprint()); // API

        if(productDb1 != null){
            updateProductDB(productDb1);
            updateMemberDB(id);
        }

    }

    @Transactional
    public void synchronizedByPmo(long pmoId){
        PMO pmo = pmoRepository.getReferenceById(pmoId);
        for(ProductOwner productOwner: pmo.getProductowners()){
            synchronize(productOwner.getId());
        }
    }

    @Transactional
    public ProductDb findProductDBByid_blueprint(String id_blueprint){
        for(ProductDb productDb: this.productDb){
            if(productDb.getId_blueprint().equals(id_blueprint)){
                return productDb;
            }
        }
        return null;
    }

    public List<Member> getAllMemberByProductOwnerId(long poId){
        ProductOwner productOwner = productownerRepository.getReferenceById(poId);
        List<Member> memberList = memberRepository.findByProductowner(productOwner);

        return memberList;
    }
    public ByteArrayInputStream downloadProduct(long poId) throws IOException {
        ProductOwner productOwner = productownerRepository.getReferenceById(poId);
        return productController.convertToExcel(productOwner.getProduct());
    }
    public ByteArrayInputStream downloadMember(long poId) throws IOException {
        List<Member> memberList = getAllMemberByProductOwnerId(poId);
        return memberController.convertToExcel(memberList);
    }
    public ByteArrayInputStream downloadKpiExcel(long poId) throws IOException{
        List<Member> memberList = getAllMemberByProductOwnerId(poId);
        return kpiController.convertToExcel(memberList);
    }
}
