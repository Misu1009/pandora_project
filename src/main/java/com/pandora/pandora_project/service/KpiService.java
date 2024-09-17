package com.pandora.pandora_project.service;

import com.pandora.pandora_project.repository.KpiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KpiService{
    private final KpiRepository kpiRepository;

    @Autowired
    public KpiService(KpiRepository kpiRepository){
        this.kpiRepository = kpiRepository;
    }

//    public void convertToExcel(List<Member> members){
//
//    }
}