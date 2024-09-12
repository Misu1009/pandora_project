package com.pandora.pandora_project;

import com.pandora.pandora_project.model.*;
import com.pandora.pandora_project.repository.*;
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
            MemberRepository memberRepository,
            FeatureRepository featureRepository,
            KpiRepository kpiRepository,
            KquarterRepository kquarterRepository,
            PMORepository pmoRepository,
            PQuarterRepository pQuarterRepository,
            ProductRepository productRepository,
            ProductOwnerRepository productOwnerRepository,
            SubtaskRepository subtaskRepository
    ){
        return args-> {

            PMO pmo = new PMO(
                    "Dora",
                    "u54321",
                    "GPOLS",
                    "dora@gmail.com",
                    "pmo",
                    "s2",
                    "blabla"
            );

            ProductOwner productOwner1 = new ProductOwner(
                    "Vincent",
                    "u12345",
                    "GPOLS",
                    "vincent@gmail.com",
                    "uatc",
                    "s1",
                    "blabla"
            );
            ProductOwner productOwner2 = new ProductOwner(
                    "Vincent",
                    "u12345",
                    "GPOLS",
                    "vincent@gmail.com",
                    "uatc",
                    "s1",
                    "blabla"
            );

            Member member1a = new Member(
                    "Kevin",
                    "u287554",
                    "GPOLS",
                    "kevin.w@gmail.com",
                    "uatc",
                    "s7",
                    "blabla"
            );
            Member member1b = new Member(
                    "Kevin",
                    "u287554",
                    "GPOLS",
                    "kevin.w@gmail.com",
                    "uatc",
                    "s7",
                    "blabla"
            );
            Member member2a = new Member(
                    "Kevin",
                    "u287554",
                    "GPOLS",
                    "kevin.w@gmail.com",
                    "uatc",
                    "s7",
                    "blabla"
            );
            Member member2b = new Member(
                    "Kevin",
                    "u287554",
                    "GPOLS",
                    "kevin.w@gmail.com",
                    "uatc",
                    "s7",
                    "blabla"
            );

            Product product1 = new Product(
                    "MXYZ",
                    "Mobile XYZ",
                    "XYZ Eksternal",
                    4.0
            );
            Product product2 = new Product(
                    "MXYZ",
                    "Mobile XYZ",
                    "XYZ Eksternal",
                    4.0
            );

            PQuarter pQuarter1a = new PQuarter(
                    "Q1",
                    10,
                    5
            );
            PQuarter pQuarter1b = new PQuarter(
                    "Q1",
                    10,
                    5
            );
            PQuarter pQuarter2a = new PQuarter(
                    "Q1",
                    10,
                    5
            );
            PQuarter pQuarter2b = new PQuarter(
                    "Q1",
                    10,
                    5
            );

            Feature feature1a = new Feature(
                    "BPRO002",
                    "Pembelian Bitcoin",
                    "On Progress",
                    "Crypto Currency",
                    new GregorianCalendar(2009, Calendar.JANUARY, 3).getTime(),
                    new GregorianCalendar(2009, Calendar.FEBRUARY, 2).getTime()
            );
            Feature feature1b = new Feature(
                    "BPRO002",
                    "Pembelian Bitcoin",
                    "On Progress",
                    "Crypto Currency",
                    new GregorianCalendar(2009, Calendar.JANUARY, 3).getTime(),
                    new GregorianCalendar(2009, Calendar.FEBRUARY, 2).getTime()
            );
            Feature feature2a = new Feature(
                    "BPRO002",
                    "Pembelian Bitcoin",
                    "On Progress",
                    "Crypto Currency",
                    new GregorianCalendar(2009, Calendar.JANUARY, 3).getTime(),
                    new GregorianCalendar(2009, Calendar.FEBRUARY, 2).getTime()
            );
            Feature feature2b = new Feature(
                    "BPRO002",
                    "Pembelian Bitcoin",
                    "On Progress",
                    "Crypto Currency",
                    new GregorianCalendar(2009, Calendar.JANUARY, 3).getTime(),
                    new GregorianCalendar(2009, Calendar.FEBRUARY, 2).getTime()
            );

            Subtask subtask1aa = new Subtask(
                    "S0008",
                    "Connecting To Bitcoin Network",
                    "On Progress",
                    new GregorianCalendar(2010, Calendar.MAY, 22).getTime(),
                    new GregorianCalendar(2010, Calendar.JUNE, 22).getTime()
            );
            Subtask subtask1ab = new Subtask(
                    "S0008",
                    "Connecting To Bitcoin Network",
                    "On Progress",
                    new GregorianCalendar(2010, Calendar.MAY, 22).getTime(),
                    new GregorianCalendar(2010, Calendar.JUNE, 22).getTime()
            );
            Subtask subtask1ba = new Subtask(
                    "S0008",
                    "Connecting To Bitcoin Network",
                    "On Progress",
                    new GregorianCalendar(2010, Calendar.MAY, 22).getTime(),
                    new GregorianCalendar(2010, Calendar.JUNE, 22).getTime()
            );
            Subtask subtask1bb = new Subtask(
                    "S0008",
                    "Connecting To Bitcoin Network",
                    "On Progress",
                    new GregorianCalendar(2010, Calendar.MAY, 22).getTime(),
                    new GregorianCalendar(2010, Calendar.JUNE, 22).getTime()
            );
            Subtask subtask2aa = new Subtask(
                    "S0008",
                    "Connecting To Bitcoin Network",
                    "On Progress",
                    new GregorianCalendar(2010, Calendar.MAY, 22).getTime(),
                    new GregorianCalendar(2010, Calendar.JUNE, 22).getTime()
            );
            Subtask subtask2ab = new Subtask(
                    "S0008",
                    "Connecting To Bitcoin Network",
                    "On Progress",
                    new GregorianCalendar(2010, Calendar.MAY, 22).getTime(),
                    new GregorianCalendar(2010, Calendar.JUNE, 22).getTime()
            );
            Subtask subtask2ba = new Subtask(
                    "S0008",
                    "Connecting To Bitcoin Network",
                    "On Progress",
                    new GregorianCalendar(2010, Calendar.MAY, 22).getTime(),
                    new GregorianCalendar(2010, Calendar.JUNE, 22).getTime()
            );
            Subtask subtask2bb = new Subtask(
                    "S0008",
                    "Connecting To Bitcoin Network",
                    "On Progress",
                    new GregorianCalendar(2010, Calendar.MAY, 22).getTime(),
                    new GregorianCalendar(2010, Calendar.JUNE, 22).getTime()
            );

            KQuarter kQuarter1aa = new KQuarter(
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
            KQuarter kQuarter1ab = new KQuarter(
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
            KQuarter kQuarter1ba = new KQuarter(
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
            KQuarter kQuarter1bb = new KQuarter(
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
            KQuarter kQuarter2aa = new KQuarter(
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
            KQuarter kQuarter2ab = new KQuarter(
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
            KQuarter kQuarter2ba = new KQuarter(
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
            KQuarter kQuarter2bb = new KQuarter(
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

            KPI kpi1a = new KPI(
                    3.84
            );
            KPI kpi1b = new KPI(
                    3.84
            );
            KPI kpi2a = new KPI(
                    3.84
            );
            KPI kpi2b = new KPI(
                    3.84
            );


//            feature1.setSubtasks(List.of(subtask1a));
//
//            kpi1.setKquarters(List.of(kQuarter1a));
//
//            member1.setKpi(kpi1);
//            member1.setSubtasks(List.of(subtask1a));
//            member1.setProductowner(productOwner1);
//
//            pmo.setProductowners(List.of(productOwner1));
//
//            product1.setQuarters(List.of(pQuarter1a));
//            product1.setFeatures(List.of(feature1));
//            product1.setProductowner(productOwner1);
//
//            productOwner1.setProduct(product1);
//            productOwner1.setMembers(List.of(member1));
//
//            subtask1a.setMember(member1);
//            subtask1a.setFeature(feature1);

            //------------------------------------------- 1


        };
    }
}
// prepare all configuration
// hubungin semua config
