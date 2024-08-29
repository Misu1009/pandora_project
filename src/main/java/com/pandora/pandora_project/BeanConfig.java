package com.pandora.pandora_project;

import com.pandora.pandora_project.model.*;
import com.pandora.pandora_project.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Configuration
public class BeanConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            MemberRepository memberRepository
    ){
        return args-> {
            ProductOwner productOwner = new ProductOwner(
                    "Vincent",
                    "u12345",
                    "GPOLS",
                    "vincent@gmail.com",
                    "uatc",
                    "s1",
                    "blabla"
            );

            PMO pmo = new PMO(
                    "Dora",
                    "u54321",
                    "GPOLS",
                    "dora@gmail.com",
                    "pmo",
                    "s2",
                    "blabla"
            );

            Member member = new Member(
                    "Kevin",
                    "u287554",
                    "GPOLS",
                    "kevin.w@gmail.com",
                    "uatc",
                    "s7",
                    "blabla"
            );

//            memberRepository.save(member);

            Product product = new Product(
                    "MXYZ",
                    "Mobile XYZ",
                    "XYZ Eksternal",
                    4.0
            );

            PQuarter pQuarter = new PQuarter(
                    "Q1",
                    10,
                    5
            );

            Feature feature = new Feature(
                    "BPRO002",
                    "Pembelian Bitcoin",
                    "On Progress",
                    "Crypto Currency",
                    new GregorianCalendar(2009, Calendar.JANUARY, 3).getTime(),
                    new GregorianCalendar(2009, Calendar.FEBRUARY, 2).getTime()
            );

            Subtask subtask = new Subtask(
                    "S0008",
                    "Connecting To Bitcoin Network",
                    "On Progress",
                    new GregorianCalendar(2010, Calendar.MAY, 22).getTime(),
                    new GregorianCalendar(2010, Calendar.JUNE, 22).getTime()
            );

            KQuarter kQuarter = new KQuarter(
                    "Q1",
                    20,
                    20,
                    3.8,
                    3.9,
                    3.2,
                    3.95,
                    10,
                    0
            );

            KPI kpi = new KPI(
                    3.84
            );


            feature.setSubtasks(List.of(subtask));

            kpi.setKquarters(List.of(kQuarter));

            member.setKpi(kpi);
            member.setSubtasks(List.of(subtask));
            member.setProductowner(productOwner);

            pmo.setProductowners(List.of(productOwner));

            product.setQuarters(List.of(pQuarter));
            product.setFeatures(List.of(feature));
            product.setProductowner(productOwner);

            productOwner.setProduct(product);
            productOwner.setMembers(List.of(member));

            subtask.setMember(member);
            subtask.setFeature(feature);

        };
    }
}
