package com.pandora.pandora_project.controller;

import com.pandora.pandora_project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/pandora")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PutMapping("/product/edit")
    public void editProduct(@RequestParam long productId, @RequestParam String name,
                            @RequestParam String mico) {
        productService.editProduct(productId, name, mico);
    }
}
