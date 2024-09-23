package com.pandora.pandora_project.service;

import com.pandora.pandora_project.model.Member;
import com.pandora.pandora_project.model.Product;
import com.pandora.pandora_project.repository.ProductOwnerRepository;
import com.pandora.pandora_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void updateProductDB(String udomain, Product product){
        long productId = productownerRepository.findbyudomain(udomain).getProduct().getId();

        Product productT = productRepository.getReferenceById(productId);

    }
//    public void updateMemberDB(String udomain, Member member){
//
//    }
//
//    public boolean synchronize(String udomain){
//
//    }
}
