package com.pandora.pandora_project.service;

import com.pandora.pandora_project.dto.RatedMember;
import com.pandora.pandora_project.dto.RatedMemberList;
import com.pandora.pandora_project.model.KPI;
import com.pandora.pandora_project.model.KQuarter;
import com.pandora.pandora_project.model.Member;
import com.pandora.pandora_project.repository.KpiRepository;
import com.pandora.pandora_project.repository.KquarterRepository;
import com.pandora.pandora_project.repository.MemberRepository;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class MemberService{
    public static String[] MEMBERHEADERS = {
            "name",
            "udomain",
            "division",
            "email",
            "biro",
            "eselon_tier",
    };

    private final MemberRepository memberRepository;
    private final HashMap<String, ArrayList<String>> ratingStatus;

    @Autowired
    public MemberService(MemberRepository memberRepository, HashMap<String, ArrayList<String>> ratingStatus){
        this.memberRepository = memberRepository;
        this.ratingStatus = ratingStatus;
    }

    @Transactional
    public boolean rate(long senderId, long memberId, String period, double cust_focus, double integrity, double teamwork, double cpoe){
        Member member = memberRepository.getReferenceById(memberId);
        Member sender = memberRepository.getReferenceById(senderId);
        int amountOfOtherMember = member.getProductowner().getMembers().size() - 1;
        String key = member.getUdomain()+period;

        if(ratingStatus.get(key) == null){ // make new key in hashmap
            ratingStatus.put(key, new ArrayList<>());
        }else{
            for(String senderUdomain: ratingStatus.get(key)){ // checking eligible
                if(senderUdomain.equals(sender.getUdomain())){
                    return false;
                }
            }
        }
        ArrayList<String> value = ratingStatus.get(key);

        KPI kpi = member.getKpi();
        List<KQuarter> kQuarters = kpi.getKquarters();

        for(KQuarter kQuarter: kQuarters){
            if(kQuarter.getPeriod().equals(period)){
                kQuarter.setCust_focus(cust_focus/amountOfOtherMember + kQuarter.getCust_focus());
                kQuarter.setIntegrity(integrity/amountOfOtherMember + kQuarter.getIntegrity());
                kQuarter.setTeamwork(teamwork/amountOfOtherMember + kQuarter.getTeamwork());
                kQuarter.setCpoe(cpoe/amountOfOtherMember + kQuarter.getCpoe());

                value.add(sender.getUdomain());
                ratingStatus.put(key, value);
            }
        }
        return true;
    }

    public ByteArrayInputStream convertToExcel(List<Member> members) throws IOException {
        List<Member> memberList = members;

        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            Sheet sheet = workbook.createSheet();

            Row row = sheet.createRow(0);

            for (int i = 0; i < MEMBERHEADERS.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(MEMBERHEADERS[i]);
            }

            int rowIndex = 1;

            for(Member member: memberList){
                Row dataRow = sheet.createRow(rowIndex);

                rowIndex++;
                dataRow.createCell(0).setCellValue(member.getName());
                dataRow.createCell(1).setCellValue(member.getUdomain());
                dataRow.createCell(2).setCellValue(member.getDivision());
                dataRow.createCell(3).setCellValue(member.getEmail());
                dataRow.createCell(4).setCellValue(member.getBiro());
                dataRow.createCell(5).setCellValue(member.getEselon_tier());
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