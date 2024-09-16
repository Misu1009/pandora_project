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
            PQuarterRepository pquarterRepository,
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
            pmoRepository.save(pmo);

            ProductOwner productowner1 = new ProductOwner(
                    "Vincent",
                    "u12345",
                    "GPOLS",
                    "vincent@gmail.com",
                    "uatc",
                    "s1",
                    "blabla"
            );
            ProductOwner productowner2 = new ProductOwner(
                    "Vincent",
                    "u12345",
                    "GPOLS",
                    "vincent@gmail.com",
                    "uatc",
                    "s1",
                    "blabla"
            );
            productOwnerRepository.saveAll(List.of(productowner1, productowner2));

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
            memberRepository.saveAll(List.of(member1a, member1b, member2a, member2b));

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
            productRepository.saveAll(List.of(product1, product2));

            PQuarter pquarter1a = new PQuarter(
                    "Q1",
                    10,
                    5
            );
            PQuarter pquarter1b = new PQuarter(
                    "Q1",
                    10,
                    5
            );
            PQuarter pquarter2a = new PQuarter(
                    "Q1",
                    10,
                    5
            );
            PQuarter pquarter2b = new PQuarter(
                    "Q1",
                    10,
                    5
            );
            pquarterRepository.saveAll(List.of(pquarter1a, pquarter1b, pquarter2a, pquarter2b));

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
            featureRepository.saveAll(List.of(feature1a, feature1b, feature2a, feature2b));

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
            subtaskRepository.saveAll(
                    List.of(
                            subtask1aa, subtask1ab, subtask1ba, subtask1bb,
                            subtask2aa, subtask2ab, subtask2ba, subtask2bb
                    ));

            KQuarter kquarter1aa = new KQuarter(
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
            KQuarter kquarter1ab = new KQuarter(
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
            KQuarter kquarter1ba = new KQuarter(
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
            KQuarter kquarter1bb = new KQuarter(
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
            KQuarter kquarter2aa = new KQuarter(
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
            KQuarter kquarter2ab = new KQuarter(
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
            KQuarter kquarter2ba = new KQuarter(
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
            KQuarter kquarter2bb = new KQuarter(
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
            kquarterRepository.saveAll(
                    List.of(
                            kquarter1aa, kquarter1ab, kquarter1ba, kquarter1bb,
                            kquarter2aa, kquarter2ab, kquarter2ba,kquarter2bb
                    ));

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
            kpiRepository.saveAll(List.of(kpi1a, kpi1b, kpi2a, kpi2b));

            kpi1a.setKquarters(List.of(kquarter1aa, kquarter1ab));
            kpi1b.setKquarters(List.of(kquarter1ba, kquarter1bb));
            kpi2a.setKquarters(List.of(kquarter2aa, kquarter2ab));
            kpi2b.setKquarters(List.of(kquarter2ba, kquarter2bb));

            member1a.setKpi(kpi1a);
            member1b.setKpi(kpi1b);
            member2a.setKpi(kpi2a);
            member2b.setKpi(kpi2b);

            member1a.setSubtasks(List.of(subtask1aa, subtask1ab));
            member1b.setSubtasks(List.of(subtask1ba, subtask1bb));
            member2a.setSubtasks(List.of(subtask2aa, subtask2ab));
            member2b.setSubtasks(List.of(subtask2ba, subtask2bb));

            product1.setPquarters(List.of(pquarter1a, pquarter1b));
            product2.setPquarters(List.of(pquarter2a, pquarter2b));

            feature1a.setSubtasks(List.of(subtask1aa, subtask1ab));
            feature1b.setSubtasks(List.of(subtask1ba, subtask1bb));
            feature2a.setSubtasks(List.of(subtask2aa, subtask2ab));
            feature2b.setSubtasks(List.of(subtask2ba, subtask2bb));

            product1.setFeatures(List.of(feature1a, feature1b));
            product2.setFeatures(List.of(feature2a, feature2b));

            productowner1.setProduct(product1);
            productowner2.setProduct(product2);

            member1a.setProductowner(productowner1);
            member1b.setProductowner(productowner1);
            member2a.setProductowner(productowner2);
            member2b.setProductowner(productowner2);

            product1.setProductowner(productowner1);
            product2.setProductowner(productowner2);

            productowner1.setMembers(List.of(member1a, member1b));
            productowner2.setMembers(List.of(member2a, member2b));

            pmo.setProductowners(List.of(productowner1, productowner2));

            // Bidirectional
//            subtask1aa.setMember(member1a);
//            subtask1ab.setMember(member1a);
//            subtask1ba.setMember(member1b);
//            subtask1bb.setMember(member1b);
//            subtask2aa.setMember(member2a);
//            subtask2ab.setMember(member2a);
//            subtask2ba.setMember(member2b);
//            subtask2bb.setMember(member2b);

//            subtask1aa.setFeature(feature1a);
//            subtask1ab.setFeature(feature1a);
//            subtask1ba.setFeature(feature1b);
//            subtask1bb.setFeature(feature1b);
//            subtask2aa.setFeature(feature2a);
//            subtask2ab.setFeature(feature2a);
//            subtask2ba.setFeature(feature2b);
//            subtask2bb.setFeature(feature2b);

            // upload via repository
            kquarterRepository.saveAll(
                    List.of(
                            kquarter1aa, kquarter1ab, kquarter1ba, kquarter1bb,
                            kquarter2aa, kquarter2ab, kquarter2ba,kquarter2bb
                    ));
            pquarterRepository.saveAll(List.of(pquarter1a, pquarter1b, pquarter2a, pquarter2b));
            subtaskRepository.saveAll(
                    List.of(
                            subtask1aa, subtask1ab, subtask1ba, subtask1bb,
                            subtask2aa, subtask2ab, subtask2ba, subtask2bb
                    ));
            featureRepository.saveAll(List.of(feature1a, feature1b, feature2a, feature2b));
            productRepository.saveAll(List.of(product1, product2));
            kpiRepository.saveAll(List.of(kpi1a, kpi1b, kpi2a, kpi2b));
            memberRepository.saveAll(List.of(member1a, member1b, member2a, member2b));
            productOwnerRepository.saveAll(List.of(productowner1, productowner2));
            pmoRepository.save(pmo);

        };
    }
}
