package com.pandora.pandora_project.controller;

import com.pandora.pandora_project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PutMapping("/product/edit")
    public void editProduct(@RequestParam long productId, @RequestParam String name,
                                            @RequestParam String mico,  @RequestParam double score) {
        productService.editProduct(productId, name, mico, score);
    }
}
