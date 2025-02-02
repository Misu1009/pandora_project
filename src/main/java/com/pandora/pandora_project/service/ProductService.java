package com.pandora.pandora_project.service;


import com.pandora.pandora_project.model.Feature;
import com.pandora.pandora_project.model.PQuarter;
import com.pandora.pandora_project.model.Product;
import com.pandora.pandora_project.model.Subtask;
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
import java.text.SimpleDateFormat;

@Service
public class ProductService{
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
    public ByteArrayInputStream convertToExcel(Product product) throws IOException {
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Product");

            // Create header row
            Row idBlueprintRow = sheet.createRow(0);
            idBlueprintRow.createCell(0).setCellValue("Id Blueprint");
            idBlueprintRow.createCell(1).setCellValue(product.getIdblueprint());

            // Fill product name
            Row productNameRow = sheet.createRow(1);
            productNameRow.createCell(0).setCellValue("Name");
            productNameRow.createCell(1).setCellValue(product.getName());

            // Fill product mico
            Row micoRow = sheet.createRow(2);
            micoRow.createCell(0).setCellValue("Mico");
            micoRow.createCell(1).setCellValue(product.getMico());

            // Fill KPI Product Score
            Row kpiProductScoreRow = sheet.createRow(3);
            kpiProductScoreRow.createCell(0).setCellValue("Kpi Product Score");
            kpiProductScoreRow.createCell(1).setCellValue(product.getKpi_product_score());

            // Fill PQuarter
            Row pQuarterHeaderRow = sheet.createRow(5);
            String[] pQuarterHeaders = {"Period", "Target", "Done"};
            for (int i = 0; i < pQuarterHeaders.length; i++) {
                Cell cell = pQuarterHeaderRow.createCell(i);
                cell.setCellValue(pQuarterHeaders[i]);
            }
            int rowIndex = 6;
            for (PQuarter pQuarter : product.getPquarters()) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(pQuarter.getPeriod());
                row.createCell(1).setCellValue(pQuarter.getTarget());
                row.createCell(2).setCellValue(pQuarter.getDone());
            }

            // Fill Feature and Subtask
            Cell featureCell = sheet.createRow(11).createCell(3);
            featureCell.setCellValue("Feature");
            Row featureHeaderRow = sheet.createRow(rowIndex + 2);
            String[] featureHeaders = {"No", "Code", "Name", "Status", "Strategic Topic", "Start Date", "End Date"};
            for (int i = 0; i < featureHeaders.length; i++) {
                Cell cell = featureHeaderRow.createCell(i);
                cell.setCellValue(featureHeaders[i]);
            }

            Cell subtaskeCell = sheet.createRow(11).createCell(11);
            subtaskeCell.setCellValue("Subtask");
            Cell subtaskHeaderCell = featureHeaderRow.createCell(8);
            subtaskHeaderCell.setCellValue("No");
            subtaskHeaderCell = featureHeaderRow.createCell(9);
            subtaskHeaderCell.setCellValue("Code");
            subtaskHeaderCell = featureHeaderRow.createCell(10);
            subtaskHeaderCell.setCellValue("Name");
            subtaskHeaderCell = featureHeaderRow.createCell(11);
            subtaskHeaderCell.setCellValue("Status");
            subtaskHeaderCell = featureHeaderRow.createCell(12);
            subtaskHeaderCell.setCellValue("Start Date");
            subtaskHeaderCell = featureHeaderRow.createCell(13);
            subtaskHeaderCell.setCellValue("End Date");
            subtaskHeaderCell = featureHeaderRow.createCell(14);
            subtaskHeaderCell.setCellValue("Due Date");

            rowIndex += 3;
            int featureCount = 1;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (Feature feature : product.getFeatures()) {
                int subtaskCount = feature.getSubtasks().size();
                for (int i = 0; i < subtaskCount; i++) {
                    Row row = sheet.createRow(rowIndex++);
                    if (i == 0) {
                        row.createCell(0).setCellValue(featureCount++);
                        row.createCell(1).setCellValue(feature.getCode());
                        row.createCell(2).setCellValue(feature.getName());
                        row.createCell(3).setCellValue(feature.getStatus());
                        row.createCell(4).setCellValue(feature.getStrategic_topic());
                        row.createCell(5).setCellValue(dateFormat.format(feature.getStart_date()));
                        row.createCell(6).setCellValue(dateFormat.format(feature.getEnd_date()));
                    }
                    Subtask subtask = feature.getSubtasks().get(i);
                    row.createCell(8).setCellValue(i+1);
                    row.createCell(9).setCellValue(subtask.getCode());
                    row.createCell(10).setCellValue(subtask.getName());
                    row.createCell(11).setCellValue(subtask.getStatus());
                    row.createCell(12).setCellValue(dateFormat.format(subtask.getStart_date()));
                    row.createCell(13).setCellValue(dateFormat.format(subtask.getEnd_date()));
                    row.createCell(14).setCellValue(dateFormat.format(subtask.getDue_date()));
                }
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

//    public ByteArrayInputStream convertToExcel(Product products) throws IOException {
//        Product product = products;
//
//        Workbook workbook = new XSSFWorkbook();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        try{
//
//            Sheet sheet = workbook.createSheet();
//
//            Row row = sheet.createRow(0);
//
//            for(int i=0; i< PRODUCTHEADERS.length; i++){
//                Cell cell = row.createCell(i);
//                cell.setCellValue(PRODUCTHEADERS[i]);
//            }
//
//            int rowIndex = 1;
//            Row dataRow = sheet.createRow(rowIndex);
//
//            dataRow.createCell(0).setCellValue(product.getIdblueprint());
//            dataRow.createCell(1).setCellValue(product.getName());
//            dataRow.createCell(2).setCellValue(product.getMico());
//            dataRow.createCell(3).setCellValue(product.getKpi_product_score());
//
//            workbook.write(out);
//
//            return new ByteArrayInputStream(out.toByteArray());
//
//        } catch (IOException e){
//            e.printStackTrace();
//            System.out.println("fail to import data product excel");
//            return null;
//        } finally {
//            workbook.close();
//            out.close();
//        }
//    }
//    public ByteArrayInputStream convertToExcel(Product products) throws IOException {
//        Product product = products;
//        Workbook workbook = new XSSFWorkbook();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        List<PQuarter> pQuarterList = product.getPquarters();
//        List<Feature> featureList = product.getFeatures();
//
//        try {
//            Sheet sheet = workbook.createSheet();
//
//            // Array header sesuai urutan yang diinginkan
//    //        String[] headers = {"idblueprint", "name", "mico", "kpi_product_score"};
//
//            for (int i = 0; i < 4; i++) {// info basic
//                Row row = sheet.createRow(i); // Setiap atribut di baris terpisah
//                Cell headerCell = row.createCell(0);
//                headerCell.setCellValue(PRODUCTHEADERS[i]); // Kolom A: Header
//
//                Cell valueCell = row.createCell(1); // Kolom B: Nilai
//                switch(i) {
//                    case 0:
//                        valueCell.setCellValue(product.getIdblueprint());
//                        break;
//                    case 1:
//                        valueCell.setCellValue(product.getName());
//                        break;
//                    case 2:
//                        valueCell.setCellValue(product.getMico());
//                        break;
//                    case 3:
//                        valueCell.setCellValue(product.getKpi_product_score());
//                        break;
//                    default:
//                        break;
//                }
//            }
//
//            workbook.write(out);
//            return new ByteArrayInputStream(out.toByteArray());
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("fail to import data product excel");
//            return null;
//        } finally {
//            workbook.close();
//            out.close();
//        }
//    }
}
