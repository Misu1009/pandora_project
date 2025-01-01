package com.pandora.pandora_project.controller;

import com.pandora.pandora_project.model.Product;
import com.pandora.pandora_project.model.ProductOwner;
import com.pandora.pandora_project.service.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/pandora")
public class ProductController {
    public static String[] PRODUCTHEADERS= {
            "idblueprint",
            "name",
            "mico",
            "kpi_product_score"
    };

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

    public ByteArrayInputStream convertToExcel(Product product) throws IOException {
        return productService.convertToExcel(product);
    }
}
