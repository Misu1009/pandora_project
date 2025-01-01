package com.pandora.pandora_project.controller;

import com.pandora.pandora_project.model.KQuarter;
import com.pandora.pandora_project.model.Member;
import com.pandora.pandora_project.service.KpiService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/pandora")
public class KPIController {
    private final KpiService kpiService;

    @Autowired
    public KPIController(KpiService kpiService) {
        this.kpiService = kpiService;
    }

    public ByteArrayInputStream convertToExcel(List<Member> members) throws IOException {
        return kpiService.convertToExcel(members);
    }
}
