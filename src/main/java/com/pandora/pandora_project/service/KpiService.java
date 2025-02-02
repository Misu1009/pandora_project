package com.pandora.pandora_project.service;

import com.pandora.pandora_project.model.KQuarter;
import com.pandora.pandora_project.model.Member;
import com.pandora.pandora_project.repository.KpiRepository;
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
import java.util.List;

@Service
public class KpiService{
    public static String[] KPIMEMBERHEADERS = {
            "name",
            "udomain",
            "final_score",
            "period 1",
            "target",
            "done",
            "cust_focus",
            "integrity",
            "teamwork",
            "cpoe",
            "on_schedule",
            "late",
            "period 2",
            "target",
            "done",
            "cust_focus",
            "integrity",
            "teamwork",
            "cpoe",
            "on_schedule",
            "late",
            "period 3",
            "target",
            "done",
            "cust_focus",
            "integrity",
            "teamwork",
            "cpoe",
            "on_schedule",
            "late",
            "period 4",
            "target",
            "done",
            "cust_focus",
            "integrity",
            "teamwork",
            "cpoe",
            "on_schedule",
            "late"
    };
    private final KpiRepository kpiRepository;

    @Autowired
    public KpiService(KpiRepository kpiRepository){
        this.kpiRepository = kpiRepository;
    }

//    public ByteArrayInputStream convertToExcel(List<Member> members) throws IOException {
//        List<Member> memberList = members;
//
//        Workbook workbook = new XSSFWorkbook();
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//
//        try {
//
//            Sheet sheet = workbook.createSheet();
//
//            Row row = sheet.createRow(0);
//
//            for (int i = 0; i < KPIMEMBERHEADERS.length; i++) {
//                Cell cell = row.createCell(i);
//                cell.setCellValue(KPIMEMBERHEADERS[i]);
//            }
//
//            int rowIndex = 1;
//
//            for(Member member: memberList){
//                Row dataRow = sheet.createRow(rowIndex);
//                rowIndex++;
//                dataRow.createCell(0).setCellValue(member.getName());
//                dataRow.createCell(1).setCellValue(member.getUdomain());
//                dataRow.createCell(2).setCellValue(member.getKpi().getFinal_score());
//                int index = 2;
//                for(KQuarter kQuarter: member.getKpi().getKquarters()){
//                    dataRow.createCell(++index).setCellValue(kQuarter.getPeriod());
//                    dataRow.createCell(++index).setCellValue(kQuarter.getTarget());
//                    dataRow.createCell(++index).setCellValue(kQuarter.getDone());
//                    dataRow.createCell(++index).setCellValue(kQuarter.getCust_focus());
//                    dataRow.createCell(++index).setCellValue(kQuarter.getIntegrity());
//                    dataRow.createCell(++index).setCellValue(kQuarter.getTeamwork());
//                    dataRow.createCell(++index).setCellValue(kQuarter.getCpoe());
//                    dataRow.createCell(++index).setCellValue(kQuarter.getOn_schedule());
//                    dataRow.createCell(++index).setCellValue(kQuarter.getLate());
//                }
//            }
//
//            workbook.write(out);
//
//            return new ByteArrayInputStream(out.toByteArray());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("fail to import data product excel");
//            return null;
//        } finally {
//            workbook.close();
//            out.close();
//        }
//    }
    public ByteArrayInputStream convertToExcel(List<Member> memberKPIs) throws IOException {
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Member KPI");

            // Create header row
            Row headerRow = sheet.createRow(0);
            String[] headers = {"No", "Name", "Udomain", "Product", "Kpi Product", "Quarter", "Target", "Done", "Ach",
                    "Cust Focus", "Integrity", "Teamwork", "CPOE", "Average", "On Schedule", "Late", "KPI Final"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }

            int memberCount=0;
            int rowIndex = 1;

            for (Member memberKPI : memberKPIs) {
                boolean isFirstQuarter = true;
                for (KQuarter kQuarter : memberKPI.getKpi().getKquarters()) {
                    Row row = sheet.createRow(rowIndex++);

                    if (isFirstQuarter) {
                        row.createCell(0).setCellValue(++memberCount);
                        row.createCell(1).setCellValue(memberKPI.getName());
                        row.createCell(2).setCellValue(memberKPI.getUdomain());
                        row.createCell(3).setCellValue(memberKPI.getProductowner().getProduct().getName());
                        row.createCell(4).setCellValue(memberKPI.getProductowner().getProduct().getKpi_product_score());
                        row.createCell(16).setCellValue(5); // kpi final
                        isFirstQuarter = false;
                    }

                    row.createCell(5).setCellValue(kQuarter.getPeriod());
                    row.createCell(6).setCellValue(kQuarter.getTarget());
                    row.createCell(7).setCellValue(kQuarter.getDone());
                    row.createCell(8).setCellValue(5); // ach
                    row.createCell(9).setCellValue(kQuarter.getCust_focus());
                    row.createCell(10).setCellValue(kQuarter.getIntegrity());
                    row.createCell(11).setCellValue(kQuarter.getTeamwork());
                    row.createCell(12).setCellValue(kQuarter.getCpoe());
                    row.createCell(13).setCellValue(5); // avg
                    row.createCell(14).setCellValue(kQuarter.getOn_schedule());
                    row.createCell(15).setCellValue(kQuarter.getLate());
                }
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}