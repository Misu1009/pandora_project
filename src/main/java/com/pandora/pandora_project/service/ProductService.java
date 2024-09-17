package com.pandora.pandora_project.service;


import com.pandora.pandora_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

//    public boolean convertToExcel(Product product){
//
//    }
//
//    public boolean setKPIProductScore(String idBlueprint, double score){
//
//    }
//
//    public boolean updateProduct(String name, String mico, double score){
//
//    }
}
