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

    public ByteArrayInputStream convertToExcel(List<Member> members) throws IOException {
        List<Member> memberList = members;

        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            Sheet sheet = workbook.createSheet();

            Row row = sheet.createRow(0);

            for (int i = 0; i < KPIMEMBERHEADERS.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(KPIMEMBERHEADERS[i]);
            }

            int rowIndex = 1;

            for(Member member: memberList){
                Row dataRow = sheet.createRow(rowIndex);
                rowIndex++;
                dataRow.createCell(0).setCellValue(member.getName()+"TESSSSSSS");
                dataRow.createCell(1).setCellValue(member.getUdomain());
                dataRow.createCell(2).setCellValue(member.getKpi().getFinal_score());
                int index = 2;
                for(KQuarter kQuarter: member.getKpi().getKquarters()){
                    dataRow.createCell(++index).setCellValue(kQuarter.getPeriod());
                    dataRow.createCell(++index).setCellValue(kQuarter.getTarget());
                    dataRow.createCell(++index).setCellValue(kQuarter.getDone());
                    dataRow.createCell(++index).setCellValue(kQuarter.getCust_focus());
                    dataRow.createCell(++index).setCellValue(kQuarter.getIntegrity());
                    dataRow.createCell(++index).setCellValue(kQuarter.getTeamwork());
                    dataRow.createCell(++index).setCellValue(kQuarter.getCpoe());
                    dataRow.createCell(++index).setCellValue(kQuarter.getOn_schedule());
                    dataRow.createCell(++index).setCellValue(kQuarter.getLate());
                }
            }

            workbook.write(out);

            return new ByteArrayInputStream(out.toByteArray());

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("fail to import data product excel");
            return null;
        } finally {
            workbook.close();
            out.close();
        }
    }
}