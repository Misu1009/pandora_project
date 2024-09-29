package com.pandora.pandora_project.service;


import com.pandora.pandora_project.model.Product;
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

    public void updateProduct(long id, String name, String mico, double score){
        Product product = productRepository.getReferenceById(id);

        product.setName(name);
        product.setMico(mico);
        product.setKpi_product_score(score);

        productRepository.save(product);
    }
}
