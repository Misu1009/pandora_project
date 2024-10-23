package com.pandora.pandora_project.service;


import com.pandora.pandora_project.model.Product;
import com.pandora.pandora_project.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService{
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional
    public void editProduct(long id, String name, String mico){
        Product product = productRepository.getReferenceById(id);

        product.setName(name);
        product.setMico(mico);

        productRepository.save(product);
    }
}
