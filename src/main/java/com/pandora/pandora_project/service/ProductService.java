package com.pandora.pandora_project.service;


import com.pandora.pandora_project.model.Product;
import com.pandora.pandora_project.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class ProductService{
    public static String[] PRODUCTHEADERS= {
            "idblueprint",
            "name",
            "mico",
            "kpi_product_score"
    };

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Transactional
    public void updateProduct(long id, String name, String mico){
        Product product = productRepository.getReferenceById(id);

        product.setName(name);
        product.setMico(mico);

        productRepository.save(product);
    }

    public ByteArrayInputStream convertToExcel(Product products) throws IOException {
        Product product = products;

        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try{

            Sheet sheet = workbook.createSheet();

            Row row = sheet.createRow(0);

            for(int i=0; i< PRODUCTHEADERS.length; i++){
                Cell cell = row.createCell(i);
                cell.setCellValue(PRODUCTHEADERS[i]);
            }

            int rowIndex = 1;
            Row dataRow = sheet.createRow(rowIndex);

            dataRow.createCell(0).setCellValue(product.getIdblueprint());
            dataRow.createCell(1).setCellValue(product.getName());
            dataRow.createCell(2).setCellValue(product.getMico());
            dataRow.createCell(3).setCellValue(product.getKpi_product_score());

            workbook.write(out);

            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e){
            e.printStackTrace();
            System.out.println("fail to import data product excel");
            return null;
        } finally {
            workbook.close();
            out.close();
        }
    }
}
