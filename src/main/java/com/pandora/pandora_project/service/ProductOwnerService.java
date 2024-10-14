package com.pandora.pandora_project.service;

import com.pandora.pandora_project.jira.FeatureDb;
import com.pandora.pandora_project.jira.ProductDb;
import com.pandora.pandora_project.jira.SubtaskDb;
import com.pandora.pandora_project.model.*;
import com.pandora.pandora_project.repository.MemberRepository;
import com.pandora.pandora_project.repository.ProductOwnerRepository;
import com.pandora.pandora_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductOwnerService{
    private final ProductOwnerRepository productownerRepository;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    private final List<ProductDb> productDb;
    private final FeatureDb featureDb;
    private final SubtaskDb subtaskDb;

    @Autowired
    public ProductOwnerService(
            ProductOwnerRepository productownerRepository,
            ProductRepository productRepository,
            MemberRepository memberRepository,
            List<ProductDb> productDb,
            FeatureDb featureDb,
            SubtaskDb subtaskDb
    ){
        this.productownerRepository = productownerRepository;
        this.productRepository = productRepository;
        this.memberRepository = memberRepository;
        this.productDb = productDb;
        this.featureDb = featureDb;
        this.subtaskDb = subtaskDb;
    }

    public void setKpiProductScore(long id,  double score){
        long productId = productownerRepository.getReferenceById(id).getProduct().getId();

        Product product = productRepository.getReferenceById(productId);
        product.setKpi_product_score(score);
        productRepository.save(product);
    }

    public void updateProductDB(ProductDb productDb){
        Product product = productRepository.findByIdblueprint(productDb.getId_blurprint());

        // Pquarter
        List<PQuarter> pquarters = product.getPquarters();
        if(pquarters == null){
            pquarters.add(
                    new PQuarter(productDb.getPeriod1(), productDb.getTarget1(), productDb.getDone1())
            );
            pquarters.add(
                    new PQuarter(productDb.getPeriod2(), productDb.getTarget2(), productDb.getDone2())
            );
            pquarters.add(
                    new PQuarter(productDb.getPeriod3(), productDb.getTarget3(), productDb.getDone3())
            );
            pquarters.add(
                    new PQuarter(productDb.getPeriod4(), productDb.getTarget4(), productDb.getDone4())
            );
        }else{
            pquarters.get(0).setDone(productDb.getDone1());
            pquarters.get(0).setTarget(productDb.getTarget1());

            pquarters.get(1).setDone(productDb.getDone2());
            pquarters.get(1).setTarget(productDb.getTarget2());

            pquarters.get(1).setDone(productDb.getDone3());
            pquarters.get(1).setTarget(productDb.getTarget3());

            pquarters.get(1).setDone(productDb.getDone4());
            pquarters.get(1).setTarget(productDb.getTarget4());
        }
        product.setPquarters(pquarters);

        // Feature + Subtask
        List<Feature> features = new ArrayList<>();
        List<Subtask> subtasks = new ArrayList<>();
        for(FeatureDb featureDb: productDb.getFeatures()){
            for(SubtaskDb subtaskDb: featureDb.getSubtasks()){
                subtasks.add(
                        new Subtask(
                                subtaskDb.getCode(),
                                subtaskDb.getName(),
                                subtaskDb.getStatus(),
                                subtaskDb.getStart_date(),
                                subtaskDb.getEnd_date(),
                                subtaskDb.getUdomain()
                        )
                );
            }
            Feature featureTemp = new Feature(
                        featureDb.getCode(),
                        featureDb.getName(),
                        featureDb.getStatus(),
                        featureDb.getStrategic_topic(),
                        featureDb.getStart_date(),
                        featureDb.getEnd_date()
            );
            featureTemp.setSubtasks(subtasks);
            features.add(featureTemp);
        }
        product.setFeatures(features);
        productRepository.save(product);
    }
    public void updateMemberDB(long id){
        ProductOwner productOwner = productownerRepository.getReferenceById(id);

        List<Member> members = productOwner.getMembers();
        Product product = productOwner.getProduct();
        List<Feature> features = product.getFeatures();
        List<Subtask> subtasks = new ArrayList<>();

        for(Member member: members){ // set null arraylist to every member
            member.setSubtasks(new ArrayList<>());
        }
        for(Feature feature: features){ // loop feature to get each subtask
            for(Subtask subtask: feature.getSubtasks()){ // bind every subtask to it's member
                String udomainS = subtask.getUdomain();
                Member findMember = memberRepository.findByUdomain(udomainS);
                findMember.getSubtasks().add(subtask);
            }
        }
    }

    public void synchronize(long id){
        ProductOwner productOwner = productownerRepository.getReferenceById(id);

        ProductDb productDb1 = findProductDBByid_blueprint(productOwner.getProduct().getIdblueprint());
        updateProductDB(productDb1);
        updateMemberDB(id);
    }

    public ProductDb findProductDBByid_blueprint(String id_blueprint){
        for(ProductDb productDb: this.productDb){
            if(productDb.getId_blurprint().equals(id_blueprint)){
                return productDb;
            }
        }
        return null;
    }

    public void downloadProduct(long poId){

    }
    public void downloadMember(long poId){

    }
    public void downloadKpiExcel(long poId){

    }

}
