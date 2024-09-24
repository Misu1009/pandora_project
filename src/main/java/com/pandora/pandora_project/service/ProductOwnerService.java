package com.pandora.pandora_project.service;

import com.pandora.pandora_project.jira.ProductDb;
import com.pandora.pandora_project.model.Member;
import com.pandora.pandora_project.model.PQuarter;
import com.pandora.pandora_project.model.Product;
import com.pandora.pandora_project.repository.ProductOwnerRepository;
import com.pandora.pandora_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOwnerService{
    private final ProductOwnerRepository productownerRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductOwnerService(ProductOwnerRepository productownerRepository, ProductRepository productRepository){
        this.productownerRepository = productownerRepository;
        this.productRepository = productRepository;
    }

    public void setKpiProductScore(String udomain, double score){
        long productId = productownerRepository.findbyudomain(udomain).getProduct().getId();

        Product product = productRepository.getReferenceById(productId);
        product.setKpi_product_score(score);
        productRepository.save(product);
    }
//    public void downloadProduct(String udomain){
//
//    }
//    public void downloadMember(String udomain){
//
//    }
//    public void downloadKpiExcel(String udomain){
//
//    }
//
    public void updateProductDB(String udomain, ProductDb productDb){
        long productId = productownerRepository.findbyudomain(udomain).getProduct().getId();

        Product product = productRepository.getReferenceById(productId);
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


    }
//    public void updateMemberDB(String udomain, Member member){
//
//    }
//
//    public boolean synchronize(String udomain){
//
//    }
}
