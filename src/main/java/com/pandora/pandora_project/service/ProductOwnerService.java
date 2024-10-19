package com.pandora.pandora_project.service;

import com.pandora.pandora_project.jira.FeatureDb;
import com.pandora.pandora_project.jira.ProductDb;
import com.pandora.pandora_project.jira.SubtaskDb;
import com.pandora.pandora_project.model.*;
import com.pandora.pandora_project.repository.*;
import jakarta.transaction.Transactional;
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
    private final FeatureRepository featureRepository;
    private final PQuarterRepository pQuarterRepository;
    private final SubtaskRepository subtaskRepository;
//    private final FeatureDb featureDb;
//    private final SubtaskDb subtaskDb;

    @Autowired
    public ProductOwnerService(
            ProductOwnerRepository productownerRepository,
            ProductRepository productRepository,
            MemberRepository memberRepository,
            FeatureRepository featureRepository,
            PQuarterRepository pQuarterRepository,
            SubtaskRepository subtaskRepository,
            List<ProductDb> productDb
//            FeatureDb featureDb,
//            SubtaskDb subtaskDb
    ){
        this.productownerRepository = productownerRepository;
        this.productRepository = productRepository;
        this.memberRepository = memberRepository;
        this.featureRepository = featureRepository;
        this.pQuarterRepository = pQuarterRepository;
        this.subtaskRepository = subtaskRepository;
        this.productDb = productDb;
//        this.featureDb = featureDb;
//        this.subtaskDb = subtaskDb;
    }

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
            product.setPquarters(pquarters);
            productRepository.save(product);
        }else{
            pquarters.get(0).setDone(productDb.getDone1());
            pquarters.get(0).setTarget(productDb.getTarget1());

            pquarters.get(1).setDone(productDb.getDone2());
            pquarters.get(1).setTarget(productDb.getTarget2());

            pquarters.get(1).setDone(productDb.getDone3());
            pquarters.get(1).setTarget(productDb.getTarget3());

            pquarters.get(1).setDone(productDb.getDone4());
            pquarters.get(1).setTarget(productDb.getTarget4());
            pQuarterRepository.saveAll(pquarters);
        }

        // Feature + Subtask

        for(FeatureDb featureDB: productDb.getFeatures()){
            if(findFeatureByCode(product, featureDB.getCode()) != null){
                Feature feature = findFeatureByCode(product, featureDB.getCode());
                feature.setStrategic_topic(featureDB.getStrategic_topic());
                feature.setStart_date(featureDB.getStart_date());
                feature.setEnd_date(featureDB.getEnd_date());
                featureRepository.save(feature);

                for(SubtaskDb subtaskDB: featureDB.getSubtasks()){
                    if(findSubtaskByCode(feature, subtaskDB.getCode()) != null){
                        Subtask subtask = findSubtaskByCode(feature, subtaskDB.getCode());
                        subtask.setStart_date(subtaskDB.getStart_date());
                        subtask.setEnd_date(subtaskDB.getEnd_date());
                        subtask.setStatus(subtaskDB.getStatus());
                        subtaskRepository.save(subtask);
                    } else{
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
            }else{
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

    @Transactional
    public void updateMemberDB(long id){
        ProductOwner productOwner = productownerRepository.getReferenceById(id);

        Product product = productOwner.getProduct();
        List<Feature> features = product.getFeatures();

        for(Feature feature: features){ // loop feature to get each subtask
            for(Subtask subtask: feature.getSubtasks()){ // bind every subtask to it's member
                Member findMember = memberRepository.findByUdomain(subtask.getUdomain());
                if(!checkSubtaskMember(findMember, subtask.getCode())){
                    findMember.getSubtasks().add(subtask);
                }
            }
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

        ProductDb productDb1 = findProductDBByid_blueprint(productOwner.getProduct().getIdblueprint());
        updateProductDB(productDb1);
        updateMemberDB(id);
    }

    @Transactional
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
