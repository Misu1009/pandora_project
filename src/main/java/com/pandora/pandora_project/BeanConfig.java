package com.pandora.pandora_project;

import com.pandora.pandora_project.dto.RatedMember;
import com.pandora.pandora_project.dto.RatedMemberList;
import com.pandora.pandora_project.jira.FeatureDb;
import com.pandora.pandora_project.jira.ProductDb;
import com.pandora.pandora_project.jira.SubtaskDb;
import com.pandora.pandora_project.model.*;
import com.pandora.pandora_project.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

@Configuration
public class BeanConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            PMORepository pmoRepository
    ){
        return args-> {
            PMO pmo = new PMO("Dora", "u54321", "GPOLS", "dora@gmail.com", "pmo", "s2", "blabla");
            ProductOwner productowner1 = new ProductOwner("Vincent Chen", "u12345", "GPOLS", "vincent.chen@example.com", "uatc", "s1", "Senior Product Owner");
            ProductOwner productowner2 = new ProductOwner("Sophia Rodriguez", "u67890", "MKTG", "sophia.r@example.com", "datc", "s2", "Lead Product Strategist");

            Member member1a = new Member("Kevin Wilson", "u287554", "GPOLS", "kevin.w@example.com", "uatc", "s7", "Senior Developer");
            Member member1b = new Member("Emily Zhang", "u398765", "MKTG", "emily.z@example.com", "datc", "s5", "UX Designer");
            Member member2a = new Member("Michael Johnson", "u456789", "FINC", "michael.j@example.com", "fatc", "s6", "Data Analyst");
            Member member2b = new Member("Olivia Patel", "u567890", "HRMS", "olivia.p@example.com", "hatc", "s4", "HR Specialist");

            Product product1 = new Product("MXYZ", "Mobile XYZ", "XYZ External", 4.0);
            Product product2 = new Product("FABC", "FinTech ABC", "ABC Internal", 3.5);

            Feature feature1a = new Feature("BPRO002", "Bitcoin Purchase Integration", "On Progress", "Cryptocurrency", new GregorianCalendar(2023, Calendar.JANUARY, 15).getTime(), new GregorianCalendar(2023, Calendar.MARCH, 30).getTime());
            Feature feature1b = new Feature("APAY001", "Apple Pay Integration", "Completed", "Payment Systems", new GregorianCalendar(2023, Calendar.FEBRUARY, 1).getTime(), new GregorianCalendar(2023, Calendar.APRIL, 15).getTime());
            Feature feature2a = new Feature("DEXP003", "Data Export Module", "Planning", "Data Management", new GregorianCalendar(2023, Calendar.MARCH, 10).getTime(), new GregorianCalendar(2023, Calendar.MAY, 20).getTime());
            Feature feature2b = new Feature("CHAT004", "AI Chatbot Implementation", "On Hold", "Customer Support", new GregorianCalendar(2023, Calendar.APRIL, 5).getTime(), new GregorianCalendar(2023, Calendar.JUNE, 30).getTime());

            Subtask subtask1aa = new Subtask("S0008", "Connect to Bitcoin Network", "On Progress", new GregorianCalendar(2023, Calendar.JANUARY, 20).getTime(), new GregorianCalendar(2023, Calendar.FEBRUARY, 10).getTime(), "u287554");
            Subtask subtask1ab = new Subtask("S0009", "Implement Wallet Security", "Not Started", new GregorianCalendar(2023, Calendar.FEBRUARY, 15).getTime(), new GregorianCalendar(2023, Calendar.MARCH, 15).getTime(), "u287554");
            Subtask subtask1ba = new Subtask("S0010", "Design Apple Pay UI", "Completed", new GregorianCalendar(2023, Calendar.FEBRUARY, 5).getTime(), new GregorianCalendar(2023, Calendar.FEBRUARY, 25).getTime(), "u398765");
            Subtask subtask1bb = new Subtask("S0011", "Test Apple Pay Transactions", "On Progress", new GregorianCalendar(2023, Calendar.MARCH, 1).getTime(), new GregorianCalendar(2023, Calendar.MARCH, 20).getTime(), "u398765");
            Subtask subtask2aa = new Subtask("S0012", "Implement Two-Factor Authentication", "In Review", new GregorianCalendar(2023, Calendar.APRIL, 5).getTime(), new GregorianCalendar(2023, Calendar.APRIL, 20).getTime(), "u456789");
            Subtask subtask2ab = new Subtask("S0013", "Optimize Database Queries", "On Progress", new GregorianCalendar(2023, Calendar.MAY, 1).getTime(), new GregorianCalendar(2023, Calendar.MAY, 15).getTime(), "u456789");
            Subtask subtask2ba = new Subtask("S0014", "Design New User Onboarding Flow", "Not Started", new GregorianCalendar(2023, Calendar.JUNE, 10).getTime(), new GregorianCalendar(2023, Calendar.JULY, 1).getTime(), "u567890");
            Subtask subtask2bb = new Subtask("S0015", "Implement Push Notifications", "Completed", new GregorianCalendar(2023, Calendar.MARCH, 15).getTime(), new GregorianCalendar(2023, Calendar.APRIL, 5).getTime(), "u567890");

            KQuarter kquarter1aa = new KQuarter("Q1", 20, 18, 3.8, 3.9, 3.2, 3.95, 10, 2);
            KQuarter kquarter1ab = new KQuarter("Q2", 25, 23, 3.9, 4.0, 3.3, 4.0, 12, 1);
            KQuarter kquarter1ac = new KQuarter("Q3", 22, 22, 3.7, 3.8, 3.1, 3.9, 11, 0);
            KQuarter kquarter1ad = new KQuarter("Q4", 28, 26, 4.0, 4.1, 3.4, 4.1, 13, 1);
            KQuarter kquarter1ba = new KQuarter("Q1", 20, 18, 3.8, 3.9, 3.2, 3.95, 10, 2);
            KQuarter kquarter1bb = new KQuarter("Q2", 25, 23, 3.9, 4.0, 3.3, 4.0, 12, 1);
            KQuarter kquarter1bc = new KQuarter("Q3", 22, 22, 3.7, 3.8, 3.1, 3.9, 11, 0);
            KQuarter kquarter1bd = new KQuarter("Q4", 28, 26, 4.0, 4.1, 3.4, 4.1, 13, 1);
            KQuarter kquarter2aa = new KQuarter("Q1", 18, 17, 3.6, 3.7, 3.0, 3.8, 9, 1);
            KQuarter kquarter2ab = new KQuarter("Q2", 23, 21, 3.7, 3.8, 3.1, 3.9, 11, 2);
            KQuarter kquarter2ac = new KQuarter("Q3", 20, 20, 3.5, 3.6, 2.9, 3.7, 10, 0);
            KQuarter kquarter2ad = new KQuarter("Q4", 26, 24, 3.8, 3.9, 3.2, 4.0, 12, 2);
            KQuarter kquarter2ba = new KQuarter("Q1", 18, 17, 3.6, 3.7, 3.0, 3.8, 9, 1);
            KQuarter kquarter2bb = new KQuarter("Q2", 23, 21, 3.7, 3.8, 3.1, 3.9, 11, 2);
            KQuarter kquarter2bc = new KQuarter("Q3", 20, 20, 3.5, 3.6, 2.9, 3.7, 10, 0);
            KQuarter kquarter2bd = new KQuarter("Q4", 26, 24, 3.8, 3.9, 3.2, 4.0, 12, 2);

            KPI kpi1a = new KPI(3.84);
            KPI kpi1b = new KPI(3.92);
            KPI kpi2a = new KPI(3.75);
            KPI kpi2b = new KPI(3.88);

            kpi1a.setKquarters(List.of(kquarter1aa, kquarter1ab, kquarter1ac, kquarter1ad));
            kpi1b.setKquarters(List.of(kquarter1ba, kquarter1bb, kquarter1bc, kquarter1bd));
            kpi2a.setKquarters(List.of(kquarter2aa, kquarter2ab, kquarter2ac, kquarter2ad));
            kpi2b.setKquarters(List.of(kquarter2ba, kquarter2bb, kquarter2bc, kquarter2bd));

            member1a.setKpi(kpi1a);
            member1b.setKpi(kpi1b);
            member2a.setKpi(kpi2a);
            member2b.setKpi(kpi2b);

            member1a.setSubtasks(List.of(subtask1aa, subtask1ab));
            member1b.setSubtasks(List.of(subtask1ba, subtask1bb));
            member2a.setSubtasks(List.of(subtask2aa, subtask2ab));
            member2b.setSubtasks(List.of(subtask2ba, subtask2bb));

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

            pmoRepository.save(pmo);
        };
    }

    @Bean
    List<ProductDb> productDBJira(){
        SubtaskDb subtaskDb1aa = new SubtaskDb("S0008", "Connect to Bitcoin Network", "On Progress", new GregorianCalendar(2023, Calendar.JANUARY, 20).getTime(), new GregorianCalendar(2023, Calendar.FEBRUARY, 10).getTime(), "u287554");
        SubtaskDb subtaskDb1ab = new SubtaskDb("S0009", "Implement Wallet Security", "Not Started", new GregorianCalendar(2023, Calendar.FEBRUARY, 15).getTime(), new GregorianCalendar(2023, Calendar.MARCH, 15).getTime(), "u287554");
        SubtaskDb subtaskDb1ba = new SubtaskDb("S0010", "Design Apple Pay UI", "Completed", new GregorianCalendar(2023, Calendar.FEBRUARY, 5).getTime(), new GregorianCalendar(2023, Calendar.FEBRUARY, 25).getTime(), "u398765");
        SubtaskDb subtaskDb1bb = new SubtaskDb("S0011", "Test Apple Pay Transactions", "On Progress", new GregorianCalendar(2023, Calendar.MARCH, 1).getTime(), new GregorianCalendar(2023, Calendar.MARCH, 20).getTime(), "u398765");
        SubtaskDb subtaskDb2aa = new SubtaskDb("S0012", "Implement Two-Factor Authentication", "In Review", new GregorianCalendar(2023, Calendar.APRIL, 5).getTime(), new GregorianCalendar(2023, Calendar.APRIL, 20).getTime(), "u456789");
        SubtaskDb subtaskDb2ab = new SubtaskDb("S0013", "Optimize Database Queries", "On Progress", new GregorianCalendar(2023, Calendar.MAY, 1).getTime(), new GregorianCalendar(2023, Calendar.MAY, 15).getTime(), "u456789");
        SubtaskDb subtaskDb2ba = new SubtaskDb("S0014", "Design New User Onboarding Flow", "Not Started", new GregorianCalendar(2023, Calendar.JUNE, 10).getTime(), new GregorianCalendar(2023, Calendar.JULY, 1).getTime(), "u567890");
        SubtaskDb subtaskDb2bb = new SubtaskDb("S0015", "Implement Push Notifications", "Completed", new GregorianCalendar(2023, Calendar.MARCH, 15).getTime(), new GregorianCalendar(2023, Calendar.APRIL, 5).getTime(), "u567890");

        FeatureDb featureDb1a = new FeatureDb("BPRO002", "Bitcoin Purchase Integration", "On Progress", "Cryptocurrency", new GregorianCalendar(2023, Calendar.JANUARY, 15).getTime(), new GregorianCalendar(2023, Calendar.MARCH, 30).getTime(), List.of(subtaskDb1aa, subtaskDb1ab));
        FeatureDb featureDb1b = new FeatureDb("APAY001", "Apple Pay Integration", "Completed", "Payment Systems", new GregorianCalendar(2023, Calendar.FEBRUARY, 1).getTime(), new GregorianCalendar(2023, Calendar.APRIL, 15).getTime(), List.of(subtaskDb1ba, subtaskDb1bb));
        FeatureDb featureDb2a = new FeatureDb("DEXP003", "Data Export Module", "Planning", "Data Management", new GregorianCalendar(2023, Calendar.MARCH, 10).getTime(), new GregorianCalendar(2023, Calendar.MAY, 20).getTime(), List.of(subtaskDb2aa, subtaskDb2ab));
        FeatureDb featureDb2b = new FeatureDb("CHAT004", "AI Chatbot Implementation", "On Hold", "Customer Support", new GregorianCalendar(2023, Calendar.APRIL, 5).getTime(), new GregorianCalendar(2023, Calendar.JUNE, 30).getTime(), List.of(subtaskDb2ba, subtaskDb2bb));

        ProductDb productDb1 = new ProductDb("MXYZ", "Q1", "Q2", "Q3", "Q4", 2, 3, 4, 5, 2, 2, 4, 4, List.of(featureDb1a, featureDb1b));
        ProductDb productDb2 = new ProductDb("FABC", "Q1", "Q2", "Q3", "Q4", 5, 7, 3, 2, 1, 4, 2, 4, List.of(featureDb2a, featureDb2b));

        ArrayList<ProductDb> productDbArrayList = new ArrayList<>();
        productDbArrayList.add(productDb1);
        productDbArrayList.add(productDb2);
        return productDbArrayList;
    }

    @Bean
    RatedMemberList ratedMemberList(){
        List<RatedMember> ratedMemberList = new ArrayList<>();
        return new RatedMemberList(ratedMemberList);
    }
}
