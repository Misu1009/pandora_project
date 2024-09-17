package com.pandora.pandora_project.service;

import com.pandora.pandora_project.repository.ProductOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductOwnerService{
    private final ProductOwnerRepository productownerRepository;

    @Autowired
    public ProductOwnerService(ProductOwnerRepository productownerRepository){
        this.productownerRepository = productownerRepository;
    }

//    public boolean setKpiProductScore(String udomain, double score){
//
//    }
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
//    public boolean updateProductDB(String udomain, Product product){
//
//    }
//    public boolean updateMemberDB(String udomain, Member member){
//
//    }
//
//    public boolean synchronize(String udomain){
//
//    }
}
