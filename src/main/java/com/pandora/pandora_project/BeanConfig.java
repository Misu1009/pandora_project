package com.pandora.pandora_project;

import com.pandora.pandora_project.thirdParty.FeatureDb;
import com.pandora.pandora_project.thirdParty.ProductDb;
import com.pandora.pandora_project.thirdParty.SubtaskDb;
import com.pandora.pandora_project.model.*;
import com.pandora.pandora_project.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class BeanConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            PMORepository pmoRepository
    ){
        return args-> {
            PMO pmo1 = new PMO("PMO 1", "U1", "GPOL", "pmo1@xyz.com", "PMO", "S5", "pass123");
            PMO pmo2 = new PMO("PMO 2", "U2", "GPOL", "pmo2@xyz.com", "PMO", "S5", "pass123");
//            PMO pmo3 = new PMO("PMO 3", "U3", "GPOL", "pmo3@xyz.com", "PMO", "S5", "pass123");

            ProductOwner productowner1 = new ProductOwner("Product Owner 1", "U4", "ABCD", "productowner1@xyz.com", "ABC", "s2", "pass123");
            ProductOwner productowner2 = new ProductOwner("Product Owner 2", "U5", "EFGH", "productowner2@xyz.com", "DEF", "s2", "pass123");
            ProductOwner productowner3 = new ProductOwner("Product Owner 3", "U6", "IJKL", "productowner3@xyz.com", "GHI", "s3", "pass123");
            ProductOwner productowner4 = new ProductOwner("Product Owner 4", "U7", "MNOP", "productowner4@xyz.com", "JKL", "s2", "pass123");
            ProductOwner productowner5 = new ProductOwner("Product Owner 5", "U8", "QRST", "productowner5@xyz.com", "MNO", "s2", "pass123");
            ProductOwner productowner6 = new ProductOwner("Product Owner 6", "U9", "UVWX", "productowner6@xyz.com", "PQR", "s3", "pass123");
            ProductOwner productowner7 = new ProductOwner("Product Owner 7", "U10", "YZAB", "productowner7@xyz.com", "STU", "s2", "pass123");
            ProductOwner productowner8 = new ProductOwner("Product Owner 8", "U11", "CDEF", "productowner8@xyz.com", "VWX", "s3", "pass123");
            ProductOwner productowner9 = new ProductOwner("Product Owner 9", "U12", "GHIJ", "productowner9@xyz.com", "YZA", "s3", "pass123");

            Member member1a = new Member("Member 1a", "U13", "ABCD", "member1a@xyz.com", "ABC", "s7", "pass123");
            Member member1b = new Member("Member 1b", "U14", "ABCD", "member1b@xyz.com", "ABC", "s7", "pass123");
            Member member1c = new Member("Member 1c", "U15", "ABCD", "member1c@xyz.com", "ABC", "s7", "pass123");

            Member member2a = new Member("Member 2a", "U16", "EFGH", "member2a@xyz.com", "DEF", "s7", "pass123");
            Member member2b = new Member("Member 2b", "U17", "EFGH", "member2b@xyz.com", "DEF", "s7", "pass123");
            Member member2c = new Member("Member 2c", "U18", "EFGH", "member2c@xyz.com", "DEF", "s7", "pass123");

            Member member3a = new Member("Member 3a", "U19", "IJKL", "member3a@xyz.com", "GHI", "s7", "pass123");
            Member member3b = new Member("Member 3b", "U20", "IJKL", "member3b@xyz.com", "GHI", "s7", "pass123");
            Member member3c = new Member("Member 3c", "U21", "IJKL", "member3c@xyz.com", "GHI", "s7", "pass123");

            Member member4a = new Member("Member 4a", "U22", "MNOP", "member4a@xyz.com", "JKL", "s7", "pass123");
            Member member4b = new Member("Member 4b", "U23", "MNOP", "member4b@xyz.com", "JKL", "s7", "pass123");
            Member member4c = new Member("Member 4c", "U24", "MNOP", "member4c@xyz.com", "JKL", "s7", "pass123");

            Member member5a = new Member("Member 5a", "U25", "QRST", "member5a@xyz.com", "MNO", "s7", "pass123");
            Member member5b = new Member("Member 5b", "U26", "QRST", "member5b@xyz.com", "MNO", "s7", "pass123");
            Member member5c = new Member("Member 5c", "U27", "QRST", "member5c@xyz.com", "MNO", "s7", "pass123");

            Member member6a = new Member("Member 6a", "U28", "UVWX", "member6a@xyz.com", "PQR", "s7", "pass123");
            Member member6b = new Member("Member 6b", "U29", "UVWX", "member6b@xyz.com", "PQR", "s7", "pass123");
            Member member6c = new Member("Member 6c", "U30", "UVWX", "member6c@xyz.com", "PQR", "s7", "pass123");

            Member member7a = new Member("Member 7a", "U31", "YZAB", "member7a@xyz.com", "STU", "s7", "pass123");
            Member member7b = new Member("Member 7b", "U32", "YZAB", "member7b@xyz.com", "STU", "s7", "pass123");
            Member member7c = new Member("Member 7c", "U33", "YZAB", "member7c@xyz.com", "STU", "s7", "pass123");

            Member member8a = new Member("Member 8a", "U34", "CDEF", "member8a@xyz.com", "VWX", "s7", "pass123");
            Member member8b = new Member("Member 8b", "U35", "CDEF", "member8b@xyz.com", "VWX", "s7", "pass123");
            Member member8c = new Member("Member 8c", "U36", "CDEF", "member8c@xyz.com", "VWX", "s7", "pass123");

            Member member9a = new Member("Member 9a", "U37", "GHIJ", "member9a@xyz.com", "YZA", "s7", "pass123");
            Member member9b = new Member("Member 9b", "U38", "GHIJ", "member9b@xyz.com", "YZA", "s7", "pass123");
            Member member9c = new Member("Member 9c", "U39", "GHIJ", "member9c@xyz.com", "YZA", "s7", "pass123");

            Product product1 = new Product("BTCUSD", "Product 1", "Bockchain External", 0.0);
            Product product2 = new Product("MABC", "Product 2", "MABC Internal", 0.0);
            Product product3 = new Product("MDEF", "Product 3", "MDEF External", 0.0);
            Product product4 = new Product("MGHI", "Product 4", "MGHI Internal", 0.0);
            Product product5 = new Product("MJKL", "Product 5", "MJKL External", 0.0);
            Product product6 = new Product("MMNO", "Product 6", "MMNO Internal", 0.0);
            Product product7 = new Product("MPQR", "Product 7", "MPQR External", 0.0);
            Product product8 = new Product("MSTU", "Product 8", "MSTU Internal", 0.0);
            Product product9 = new Product("MVWX", "Product 9", "MVWX External", 0.0);

            Feature feature1a = new Feature("FPRO1", "Feature 1a", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2024, Calendar.JANUARY, 20).getTime());
            Feature feature1b = new Feature("FPRO2", "Feature 1b", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JANUARY, 22).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 10).getTime());
            Feature feature1c = new Feature("FPRO3", "Feature 1c", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.FEBRUARY, 15).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 25).getTime());

            Feature feature2a = new Feature("FPRO4", "Feature 2a", "To Do", "Strategic Topic 2", new GregorianCalendar(2024, Calendar.FEBRUARY, 15).getTime(), new GregorianCalendar(2024, Calendar.APRIL, 30).getTime());
            Feature feature2b = new Feature("FPRO5", "Feature 2b", "In Progress", "Strategic Topic 2", new GregorianCalendar(2024, Calendar.MARCH, 1).getTime(), new GregorianCalendar(2024, Calendar.MAY, 15).getTime());
            Feature feature2c = new Feature("FPRO6", "Feature 2c", "Done", "Strategic Topic 2", new GregorianCalendar(2024, Calendar.APRIL, 1).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 30).getTime());

            Feature feature3a = new Feature("FPRO7", "Feature 3a", "Done", "Strategic Topic 3", new GregorianCalendar(2024, Calendar.MARCH, 15).getTime(), new GregorianCalendar(2024, Calendar.MAY, 30).getTime());
            Feature feature3b = new Feature("FPRO8", "Feature 3b", "To Do", "Strategic Topic 3", new GregorianCalendar(2024, Calendar.APRIL, 1).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime());
            Feature feature3c = new Feature("FPRO9", "Feature 3c", "In Progress", "Strategic Topic 3", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), new GregorianCalendar(2024, Calendar.JULY, 30).getTime());

            Feature feature4a = new Feature("FPRO10", "Feature 4a", "In Progress", "Strategic Topic 4", new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 30).getTime());
            Feature feature4b = new Feature("FPRO11", "Feature 4b", "Done", "Strategic Topic 4", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), new GregorianCalendar(2024, Calendar.JULY, 15).getTime());
            Feature feature4c = new Feature("FPRO12", "Feature 4c", "To Do", "Strategic Topic 4", new GregorianCalendar(2024, Calendar.JUNE, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 30).getTime());

            Feature feature5a = new Feature("FPRO13", "Feature 5a", "Done", "Strategic Topic 5", new GregorianCalendar(2024, Calendar.MAY, 15).getTime(), new GregorianCalendar(2024, Calendar.JULY, 30).getTime());
            Feature feature5b = new Feature("FPRO14", "Feature 5b", "In Progress", "Strategic Topic 5", new GregorianCalendar(2024, Calendar.JUNE, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 15).getTime());
            Feature feature5c = new Feature("FPRO15", "Feature 5c", "To Do", "Strategic Topic 5", new GregorianCalendar(2024, Calendar.JULY, 1).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 30).getTime());

            Feature feature6a = new Feature("FPRO16", "Feature 6a", "To Do", "Strategic Topic 6", new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 30).getTime());
            Feature feature6b = new Feature("FPRO17", "Feature 6b", "Done", "Strategic Topic 6", new GregorianCalendar(2024, Calendar.JULY, 1).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 15).getTime());
            Feature feature6c = new Feature("FPRO18", "Feature 6c", "In Progress", "Strategic Topic 6", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.OCTOBER, 30).getTime());

            Feature feature7a = new Feature("FPRO19", "Feature 7a", "In Progress", "Strategic Topic 7", new GregorianCalendar(2024, Calendar.JULY, 15).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 30).getTime());
            Feature feature7b = new Feature("FPRO20", "Feature 7b", "To Do", "Strategic Topic 7", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.OCTOBER, 15).getTime());
            Feature feature7c = new Feature("FPRO21", "Feature 7c", "Done", "Strategic Topic 7", new GregorianCalendar(2024, Calendar.SEPTEMBER, 1).getTime(), new GregorianCalendar(2024, Calendar.NOVEMBER, 30).getTime());

            Feature feature8a = new Feature("FPRO22", "Feature 8a", "Done", "Strategic Topic 8", new GregorianCalendar(2024, Calendar.AUGUST, 15).getTime(), new GregorianCalendar(2024, Calendar.OCTOBER, 30).getTime());
            Feature feature8b = new Feature("FPRO23", "Feature 8b", "In Progress", "Strategic Topic 8", new GregorianCalendar(2024, Calendar.SEPTEMBER, 1).getTime(), new GregorianCalendar(2024, Calendar.NOVEMBER, 15).getTime());
            Feature feature8c = new Feature("FPRO24", "Feature 8c", "To Do", "Strategic Topic 8", new GregorianCalendar(2024, Calendar.OCTOBER, 1).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 30).getTime());

            Feature feature9a = new Feature("FPRO25", "Feature 9a", "To Do", "Strategic Topic 9", new GregorianCalendar(2024, Calendar.SEPTEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.NOVEMBER, 30).getTime());
            Feature feature9b = new Feature("FPRO26", "Feature 9b", "Done", "Strategic Topic 9", new GregorianCalendar(2024, Calendar.OCTOBER, 1).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime());
            Feature feature9c = new Feature("FPRO27", "Feature 9c", "In Progress", "Strategic Topic 9", new GregorianCalendar(2024, Calendar.NOVEMBER, 1).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 30).getTime());

            Subtask subtask1aa = new Subtask("S001", "Subtask 1aa", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 20).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 10).getTime(), "U13");
            Subtask subtask1ab = new Subtask("S002", "Subtask 1ab", "In Progress", new GregorianCalendar(2024, Calendar.FEBRUARY, 1).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime(), "U13");
            Subtask subtask1ac = new Subtask("S003", "Subtask 1ac", "To Do", new GregorianCalendar(2024, Calendar.FEBRUARY, 15).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 5).getTime(), "U13");
            Subtask subtask1ba = new Subtask("S004", "Subtask 1ba", "To Do", new GregorianCalendar(2024, Calendar.FEBRUARY, 5).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime(), "U14");
            Subtask subtask1bb = new Subtask("S005", "Subtask 1bb", "Done", new GregorianCalendar(2024, Calendar.FEBRUARY, 20).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 10).getTime(), "U14");
            Subtask subtask1bc = new Subtask("S006", "Subtask 1bc", "In Progress", new GregorianCalendar(2024, Calendar.MARCH, 1).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 20).getTime(), "U14");
            Subtask subtask1ca = new Subtask("S007", "Subtask 1ca", "In Progress", new GregorianCalendar(2024, Calendar.MARCH, 5).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 25).getTime(), "U15");
            Subtask subtask1cb = new Subtask("S008", "Subtask 1cb", "To Do", new GregorianCalendar(2024, Calendar.MARCH, 20).getTime(), new GregorianCalendar(2024, Calendar.APRIL, 10).getTime(), "U15");
            Subtask subtask1cc = new Subtask("S009", "Subtask 1cc", "Done", new GregorianCalendar(2024, Calendar.APRIL, 1).getTime(), new GregorianCalendar(2024, Calendar.APRIL, 20).getTime(), "U15");
            Subtask subtask2aa = new Subtask("S010", "Subtask 2aa", "Done", new GregorianCalendar(2024, Calendar.FEBRUARY, 20).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 10).getTime(), "U16");
            Subtask subtask2ab = new Subtask("S011", "Subtask 2ab", "In Progress", new GregorianCalendar(2024, Calendar.MARCH, 1).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 25).getTime(), "U16");
            Subtask subtask2ac = new Subtask("S012", "Subtask 2ac", "To Do", new GregorianCalendar(2024, Calendar.MARCH, 15).getTime(), new GregorianCalendar(2024, Calendar.APRIL, 5).getTime(), "U16");
            Subtask subtask2ba = new Subtask("S013", "Subtask 2ba", "To Do", new GregorianCalendar(2024, Calendar.MARCH, 5).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 25).getTime(), "U17");
            Subtask subtask2bb = new Subtask("S014", "Subtask 2bb", "Done", new GregorianCalendar(2024, Calendar.MARCH, 20).getTime(), new GregorianCalendar(2024, Calendar.APRIL, 10).getTime(), "U17");
            Subtask subtask2bc = new Subtask("S015", "Subtask 2bc", "In Progress", new GregorianCalendar(2024, Calendar.APRIL, 1).getTime(), new GregorianCalendar(2024, Calendar.APRIL, 20).getTime(), "U17");
            Subtask subtask2ca = new Subtask("S016", "Subtask 2ca", "In Progress", new GregorianCalendar(2024, Calendar.APRIL, 5).getTime(), new GregorianCalendar(2024, Calendar.APRIL, 25).getTime(), "U18");
            Subtask subtask2cb = new Subtask("S017", "Subtask 2cb", "To Do", new GregorianCalendar(2024, Calendar.APRIL, 20).getTime(), new GregorianCalendar(2024, Calendar.MAY, 10).getTime(), "U18");
            Subtask subtask2cc = new Subtask("S018", "Subtask 2cc", "Done", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), new GregorianCalendar(2024, Calendar.MAY, 20).getTime(), "U18");
            Subtask subtask3aa = new Subtask("S019", "Subtask 3aa", "Done", new GregorianCalendar(2024, Calendar.MARCH, 20).getTime(), new GregorianCalendar(2024, Calendar.APRIL, 10).getTime(), "U19");
            Subtask subtask3ab = new Subtask("S020", "Subtask 3ab", "In Progress", new GregorianCalendar(2024, Calendar.APRIL, 1).getTime(), new GregorianCalendar(2024, Calendar.APRIL, 25).getTime(), "U19");
            Subtask subtask3ac = new Subtask("S021", "Subtask 3ac", "To Do", new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), new GregorianCalendar(2024, Calendar.MAY, 5).getTime(), "U19");
            Subtask subtask3ba = new Subtask("S022", "Subtask 3ba", "To Do", new GregorianCalendar(2024, Calendar.APRIL, 5).getTime(), new GregorianCalendar(2024, Calendar.APRIL, 25).getTime(), "U20");
            Subtask subtask3bb = new Subtask("S023", "Subtask 3bb", "Done", new GregorianCalendar(2024, Calendar.APRIL, 20).getTime(), new GregorianCalendar(2024, Calendar.MAY, 10).getTime(), "U20");
            Subtask subtask3bc = new Subtask("S024", "Subtask 3bc", "In Progress", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), new GregorianCalendar(2024, Calendar.MAY, 20).getTime(), "U20");
            Subtask subtask3ca = new Subtask("S025", "Subtask 3ca", "In Progress", new GregorianCalendar(2024, Calendar.MAY, 5).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), "U21");
            Subtask subtask3cb = new Subtask("S026", "Subtask 3cb", "To Do", new GregorianCalendar(2024, Calendar.MAY, 20).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "U21");
            Subtask subtask3cc = new Subtask("S027", "Subtask 3cc", "Done", new GregorianCalendar(2024, Calendar.JUNE, 1).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), "U21");
            Subtask subtask4aa = new Subtask("S028", "Subtask 4aa", "Done", new GregorianCalendar(2024, Calendar.APRIL, 20).getTime(), new GregorianCalendar(2024, Calendar.MAY, 10).getTime(), "U22");
            Subtask subtask4ab = new Subtask("S029", "Subtask 4ab", "In Progress", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), "U22");
            Subtask subtask4ac = new Subtask("S030", "Subtask 4ac", "To Do", new GregorianCalendar(2024, Calendar.MAY, 15).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 5).getTime(), "U22");
            Subtask subtask4ba = new Subtask("S031", "Subtask 4ba", "To Do", new GregorianCalendar(2024, Calendar.MAY, 5).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), "U23");
            Subtask subtask4bb = new Subtask("S032", "Subtask 4bb", "Done", new GregorianCalendar(2024, Calendar.MAY, 20).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "U23");
            Subtask subtask4bc = new Subtask("S033", "Subtask 4bc", "In Progress", new GregorianCalendar(2024, Calendar.JUNE, 1).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), "U23");
            Subtask subtask4ca = new Subtask("S034", "Subtask 4ca", "In Progress", new GregorianCalendar(2024, Calendar.JUNE, 5).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 25).getTime(), "U24");
            Subtask subtask4cb = new Subtask("S035", "Subtask 4cb", "To Do", new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), new GregorianCalendar(2024, Calendar.JULY, 10).getTime(), "U24");
            Subtask subtask4cc = new Subtask("S036", "Subtask 4cc", "Done", new GregorianCalendar(2024, Calendar.JULY, 1).getTime(), new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), "U24");
            Subtask subtask5aa = new Subtask("S037", "Subtask 5aa", "Done", new GregorianCalendar(2024, Calendar.MAY, 20).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "U25");
            Subtask subtask5ab = new Subtask("S038", "Subtask 5ab", "In Progress", new GregorianCalendar(2024, Calendar.JUNE, 1).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 25).getTime(), "U25");
            Subtask subtask5ac = new Subtask("S039", "Subtask 5ac", "To Do", new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), "U25");
            Subtask subtask5ba = new Subtask("S040", "Subtask 5ba", "To Do", new GregorianCalendar(2024, Calendar.JUNE, 5).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 25).getTime(), "U26");
            Subtask subtask5bb = new Subtask("S041", "Subtask 5bb", "Done", new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), new GregorianCalendar(2024, Calendar.JULY, 10).getTime(), "U26");
            Subtask subtask5bc = new Subtask("S042", "Subtask 5bc", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 1).getTime(), new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), "U26");
            Subtask subtask5ca = new Subtask("S043", "Subtask 5ca", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U27");
            Subtask subtask5cb = new Subtask("S044", "Subtask 5cb", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U27");
            Subtask subtask5cc = new Subtask("S045", "Subtask 5cc", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U27");
            Subtask subtask6aa = new Subtask("S046", "Subtask 6aa", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U28");
            Subtask subtask6ab = new Subtask("S047", "Subtask 6ab", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U28");
            Subtask subtask6ac = new Subtask("S048", "Subtask 6ac", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U28");
            Subtask subtask6ba = new Subtask("S049", "Subtask 6ba", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U29");
            Subtask subtask6bb = new Subtask("S050", "Subtask 6bb", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U29");
            Subtask subtask6bc = new Subtask("S051", "Subtask 6bc", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U29");
            Subtask subtask6ca = new Subtask("S052", "Subtask 6ca", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U30");
            Subtask subtask6cb = new Subtask("S053", "Subtask 6cb", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U30");
            Subtask subtask6cc = new Subtask("S054", "Subtask 6cc", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U30");
            Subtask subtask7aa = new Subtask("S055", "Subtask 7aa", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U31");
            Subtask subtask7ab = new Subtask("S056", "Subtask 7ab", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U31");
            Subtask subtask7ac = new Subtask("S057", "Subtask 7ac", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U31");
            Subtask subtask7ba = new Subtask("S058", "Subtask 7ba", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U32");
            Subtask subtask7bb = new Subtask("S059", "Subtask 7bb", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U32");
            Subtask subtask7bc = new Subtask("S060", "Subtask 7bc", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U32");
            Subtask subtask7ca = new Subtask("S061", "Subtask 7ca", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U33");
            Subtask subtask7cb = new Subtask("S062", "Subtask 7cb", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U33");
            Subtask subtask7cc = new Subtask("S063", "Subtask 7cc", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U33");
            Subtask subtask8aa = new Subtask("S064", "Subtask 8aa", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U34");
            Subtask subtask8ab = new Subtask("S065", "Subtask 8ab", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U34");
            Subtask subtask8ac = new Subtask("S066", "Subtask 8ac", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U34");
            Subtask subtask8ba = new Subtask("S067", "Subtask 8ba", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U35");
            Subtask subtask8bb = new Subtask("S068", "Subtask 8bb", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U35");
            Subtask subtask8bc = new Subtask("S069", "Subtask 8bc", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U35");
            Subtask subtask8ca = new Subtask("S070", "Subtask 8ca", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U36");
            Subtask subtask8cb = new Subtask("S071", "Subtask 8cb", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U36");
            Subtask subtask8cc = new Subtask("S072", "Subtask 8cc", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U36");
            Subtask subtask9aa = new Subtask("S073", "Subtask 9aa", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U37");
            Subtask subtask9ab = new Subtask("S074", "Subtask 9ab", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U37");
            Subtask subtask9ac = new Subtask("S075", "Subtask 9ac", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U37");
            Subtask subtask9ba = new Subtask("S076", "Subtask 9ba", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U38");
            Subtask subtask9bb = new Subtask("S077", "Subtask 9bb", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U38");
            Subtask subtask9bc = new Subtask("S078", "Subtask 9bc", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U38");
            Subtask subtask9ca = new Subtask("S079", "Subtask 9ca", "In Progress", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.JULY, 25).getTime(), "U39");
            Subtask subtask9cb = new Subtask("S080", "Subtask 9cb", "To Do", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 10).getTime(), "U39");
            Subtask subtask9cc = new Subtask("S081", "Subtask 9cc", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), "U39");

            KQuarter kquarter1aa = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1ab = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1ac = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1ad = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1ba = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1bb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1bc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1bd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1ca = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1cb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1cc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1cd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);

            KQuarter kquarter2aa = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2ab = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2ac = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2ad = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2ba = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2bb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2bc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2bd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2ca = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2cb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2cc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2cd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);

            KQuarter kquarter3aa = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter3ab = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter3ac = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter3ad = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter3ba = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter3bb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter3bc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter3bd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter3ca = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter3cb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter3cc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter3cd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);

            KQuarter kquarter4aa = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter4ab = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter4ac = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter4ad = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter4ba = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter4bb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter4bc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter4bd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter4ca = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter4cb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter4cc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter4cd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);

            KQuarter kquarter5aa = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter5ab = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter5ac = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter5ad = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter5ba = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter5bb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter5bc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter5bd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter5ca = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter5cb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter5cc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter5cd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);

            KQuarter kquarter6aa = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter6ab = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter6ac = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter6ad = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter6ba = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter6bb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter6bc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter6bd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter6ca = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter6cb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter6cc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter6cd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);

            KQuarter kquarter7aa = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter7ab = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter7ac = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter7ad = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter7ba = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter7bb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter7bc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter7bd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter7ca = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter7cb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter7cc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter7cd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);

            KQuarter kquarter8aa = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter8ab = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter8ac = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter8ad = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter8ba = new KQuarter("Q1", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter8bb = new KQuarter("Q2", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter8bc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter8bd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter8ca = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter8cb = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter8cc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter8cd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);

            KQuarter kquarter9aa = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter9ab = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter9ac = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter9ad = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter9ba = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter9bb = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter9bc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter9bd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter9ca = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter9cb = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter9cc = new KQuarter("Q3", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter9cd = new KQuarter("Q4", 0, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);


            KPI kpi1a = new KPI();
            KPI kpi1b = new KPI();
            KPI kpi1c = new KPI();
            KPI kpi2a = new KPI();
            KPI kpi2b = new KPI();
            KPI kpi2c = new KPI();
            KPI kpi3a = new KPI();
            KPI kpi3b = new KPI();
            KPI kpi3c = new KPI();
            KPI kpi4a = new KPI();
            KPI kpi4b = new KPI();
            KPI kpi4c = new KPI();
            KPI kpi5a = new KPI();
            KPI kpi5b = new KPI();
            KPI kpi5c = new KPI();
            KPI kpi6a = new KPI();
            KPI kpi6b = new KPI();
            KPI kpi6c = new KPI();
            KPI kpi7a = new KPI();
            KPI kpi7b = new KPI();
            KPI kpi7c = new KPI();
            KPI kpi8a = new KPI();
            KPI kpi8b = new KPI();
            KPI kpi8c = new KPI();
            KPI kpi9a = new KPI();
            KPI kpi9b = new KPI();
            KPI kpi9c = new KPI();

            PQuarter pQuarter1a = new PQuarter("Q1");
            PQuarter pQuarter1b = new PQuarter("Q2");
            PQuarter pQuarter1c = new PQuarter("Q3");
            PQuarter pQuarter1d = new PQuarter("Q4");
            PQuarter pQuarter2a = new PQuarter("Q1");
            PQuarter pQuarter2b = new PQuarter("Q2");
            PQuarter pQuarter2c = new PQuarter("Q3");
            PQuarter pQuarter2d = new PQuarter("Q4");
            PQuarter pQuarter3a = new PQuarter("Q1");
            PQuarter pQuarter3b = new PQuarter("Q2");
            PQuarter pQuarter3c = new PQuarter("Q3");
            PQuarter pQuarter3d = new PQuarter("Q4");
            PQuarter pQuarter4a = new PQuarter("Q1");
            PQuarter pQuarter4b = new PQuarter("Q2");
            PQuarter pQuarter4c = new PQuarter("Q3");
            PQuarter pQuarter4d = new PQuarter("Q4");
            PQuarter pQuarter5a = new PQuarter("Q1");
            PQuarter pQuarter5b = new PQuarter("Q2");
            PQuarter pQuarter5c = new PQuarter("Q3");
            PQuarter pQuarter5d = new PQuarter("Q4");
            PQuarter pQuarter6a = new PQuarter("Q1");
            PQuarter pQuarter6b = new PQuarter("Q2");
            PQuarter pQuarter6c = new PQuarter("Q3");
            PQuarter pQuarter6d = new PQuarter("Q4");
            PQuarter pQuarter7a = new PQuarter("Q1");
            PQuarter pQuarter7b = new PQuarter("Q2");
            PQuarter pQuarter7c = new PQuarter("Q3");
            PQuarter pQuarter7d = new PQuarter("Q4");
            PQuarter pQuarter8a = new PQuarter("Q1");
            PQuarter pQuarter8b = new PQuarter("Q2");
            PQuarter pQuarter8c = new PQuarter("Q3");
            PQuarter pQuarter8d = new PQuarter("Q4");
            PQuarter pQuarter9a = new PQuarter("Q1");
            PQuarter pQuarter9b = new PQuarter("Q2");
            PQuarter pQuarter9c = new PQuarter("Q3");
            PQuarter pQuarter9d = new PQuarter("Q4");

            kpi1a.setKquarters(List.of(kquarter1aa, kquarter1ab, kquarter1ac, kquarter1ad));
            kpi1b.setKquarters(List.of(kquarter1ba, kquarter1bb, kquarter1bc, kquarter1bd));
            kpi1c.setKquarters(List.of(kquarter1ca, kquarter1cb, kquarter1cc, kquarter1cd));
            kpi2a.setKquarters(List.of(kquarter2aa, kquarter2ab, kquarter2ac, kquarter2ad));
            kpi2b.setKquarters(List.of(kquarter2ba, kquarter2bb, kquarter2bc, kquarter2bd));
            kpi2c.setKquarters(List.of(kquarter2ca, kquarter2cb, kquarter2cc, kquarter2cd));
            kpi3a.setKquarters(List.of(kquarter3aa, kquarter3ab, kquarter3ac, kquarter3ad));
            kpi3b.setKquarters(List.of(kquarter3ba, kquarter3bb, kquarter3bc, kquarter3bd));
            kpi3c.setKquarters(List.of(kquarter3ca, kquarter3cb, kquarter3cc, kquarter3cd));
            kpi4a.setKquarters(List.of(kquarter4aa, kquarter4ab, kquarter4ac, kquarter4ad));
            kpi4b.setKquarters(List.of(kquarter4ba, kquarter4bb, kquarter4bc, kquarter4bd));
            kpi4c.setKquarters(List.of(kquarter4ca, kquarter4cb, kquarter4cc, kquarter4cd));
            kpi5a.setKquarters(List.of(kquarter5aa, kquarter5ab, kquarter5ac, kquarter5ad));
            kpi5b.setKquarters(List.of(kquarter5ba, kquarter5bb, kquarter5bc, kquarter5bd));
            kpi5c.setKquarters(List.of(kquarter5ca, kquarter5cb, kquarter5cc, kquarter5cd));
            kpi6a.setKquarters(List.of(kquarter6aa, kquarter6ab, kquarter6ac, kquarter6ad));
            kpi6b.setKquarters(List.of(kquarter6ba, kquarter6bb, kquarter6bc, kquarter6bd));
            kpi6c.setKquarters(List.of(kquarter6ca, kquarter6cb, kquarter6cc, kquarter6cd));
            kpi7a.setKquarters(List.of(kquarter7aa, kquarter7ab, kquarter7ac, kquarter7ad));
            kpi7b.setKquarters(List.of(kquarter7ba, kquarter7bb, kquarter7bc, kquarter7bd));
            kpi7c.setKquarters(List.of(kquarter7ca, kquarter7cb, kquarter7cc, kquarter7cd));
            kpi8a.setKquarters(List.of(kquarter8aa, kquarter8ab, kquarter8ac, kquarter8ad));
            kpi8b.setKquarters(List.of(kquarter8ba, kquarter8bb, kquarter8bc, kquarter8bd));
            kpi8c.setKquarters(List.of(kquarter8ca, kquarter8cb, kquarter8cc, kquarter8cd));
            kpi9a.setKquarters(List.of(kquarter9aa, kquarter9ab, kquarter9ac, kquarter9ad));
            kpi9b.setKquarters(List.of(kquarter9ba, kquarter9bb, kquarter9bc, kquarter9bd));
            kpi9c.setKquarters(List.of(kquarter9ca, kquarter9cb, kquarter9cc, kquarter9cd));

            member1a.setKpi(kpi1a);
            member1b.setKpi(kpi1b);
            member1c.setKpi(kpi1c);
            member2a.setKpi(kpi2a);
            member2b.setKpi(kpi2b);
            member2c.setKpi(kpi2c);
            member3a.setKpi(kpi3a);
            member3b.setKpi(kpi3b);
            member3c.setKpi(kpi3c);
            member4a.setKpi(kpi4a);
            member4b.setKpi(kpi4b);
            member4c.setKpi(kpi4c);
            member5a.setKpi(kpi5a);
            member5b.setKpi(kpi5b);
            member5c.setKpi(kpi5c);
            member6a.setKpi(kpi6a);
            member6b.setKpi(kpi6b);
            member6c.setKpi(kpi6c);
            member7a.setKpi(kpi7a);
            member7b.setKpi(kpi7b);
            member7c.setKpi(kpi7c);
            member8a.setKpi(kpi8a);
            member8b.setKpi(kpi8b);
            member8c.setKpi(kpi8c);
            member9a.setKpi(kpi9a);
            member9b.setKpi(kpi9b);
            member9c.setKpi(kpi9c);

            member1a.setSubtasks(List.of(subtask1aa, subtask1ab, subtask1ac));
            member1b.setSubtasks(List.of(subtask1ba, subtask1bb, subtask1bc));
            member1c.setSubtasks(List.of(subtask1ca, subtask1cb, subtask1cc));
            member2a.setSubtasks(List.of(subtask2aa, subtask2ab, subtask2ac));
            member2b.setSubtasks(List.of(subtask2ba, subtask2bb, subtask2bc));
            member2c.setSubtasks(List.of(subtask2ca, subtask2cb, subtask2cc));
            member3a.setSubtasks(List.of(subtask3aa, subtask3ab, subtask3ac));
            member3b.setSubtasks(List.of(subtask3ba, subtask3bb, subtask3bc));
            member3c.setSubtasks(List.of(subtask3ca, subtask3cb, subtask3cc));
            member4a.setSubtasks(List.of(subtask4aa, subtask4ab, subtask4ac));
            member4b.setSubtasks(List.of(subtask4ba, subtask4bb, subtask4bc));
            member4c.setSubtasks(List.of(subtask4ca, subtask4cb, subtask4cc));
            member5a.setSubtasks(List.of(subtask5aa, subtask5ab, subtask5ac));
            member5b.setSubtasks(List.of(subtask5ba, subtask5bb, subtask5bc));
            member5c.setSubtasks(List.of(subtask5ca, subtask5cb, subtask5cc));
            member6a.setSubtasks(List.of(subtask6aa, subtask6ab, subtask6ac));
            member6b.setSubtasks(List.of(subtask6ba, subtask6bb, subtask6bc));
            member6c.setSubtasks(List.of(subtask6ca, subtask6cb, subtask6cc));
            member7a.setSubtasks(List.of(subtask7aa, subtask7ab, subtask7ac));
            member7b.setSubtasks(List.of(subtask7ba, subtask7bb, subtask7bc));
            member7c.setSubtasks(List.of(subtask7ca, subtask7cb, subtask7cc));
            member8a.setSubtasks(List.of(subtask8aa, subtask8ab, subtask8ac));
            member8b.setSubtasks(List.of(subtask8ba, subtask8bb, subtask8bc));
            member8c.setSubtasks(List.of(subtask8ca, subtask8cb, subtask8cc));
            member9a.setSubtasks(List.of(subtask9aa, subtask9ab, subtask9ac));
            member9b.setSubtasks(List.of(subtask9ba, subtask9bb, subtask9bc));
            member9c.setSubtasks(List.of(subtask9ca, subtask9cb, subtask9cc));

            feature1a.setSubtasks(List.of(subtask1aa, subtask1ab, subtask1ac));
            feature1b.setSubtasks(List.of(subtask1ba, subtask1bb, subtask1bc));
            feature1c.setSubtasks(List.of(subtask1ca, subtask1cb, subtask1cc));
            feature2a.setSubtasks(List.of(subtask2aa, subtask2ab, subtask2ac));
            feature2b.setSubtasks(List.of(subtask2ba, subtask2bb, subtask2bc));
            feature2c.setSubtasks(List.of(subtask2ca, subtask2cb, subtask2cc));
            feature3a.setSubtasks(List.of(subtask3aa, subtask3ab, subtask3ac));
            feature3b.setSubtasks(List.of(subtask3ba, subtask3bb, subtask3bc));
            feature3c.setSubtasks(List.of(subtask3ca, subtask3cb, subtask3cc));
            feature4a.setSubtasks(List.of(subtask4aa, subtask4ab, subtask4ac));
            feature4b.setSubtasks(List.of(subtask4ba, subtask4bb, subtask4bc));
            feature4c.setSubtasks(List.of(subtask4ca, subtask4cb, subtask4cc));
            feature5a.setSubtasks(List.of(subtask5aa, subtask5ab, subtask5ac));
            feature5b.setSubtasks(List.of(subtask5ba, subtask5bb, subtask5bc));
            feature5c.setSubtasks(List.of(subtask5ca, subtask5cb, subtask5cc));
            feature6a.setSubtasks(List.of(subtask6aa, subtask6ab, subtask6ac));
            feature6b.setSubtasks(List.of(subtask6ba, subtask6bb, subtask6bc));
            feature6c.setSubtasks(List.of(subtask6ca, subtask6cb, subtask6cc));
            feature7a.setSubtasks(List.of(subtask7aa, subtask7ab, subtask7ac));
            feature7b.setSubtasks(List.of(subtask7ba, subtask7bb, subtask7bc));
            feature7c.setSubtasks(List.of(subtask7ca, subtask7cb, subtask7cc));
            feature8a.setSubtasks(List.of(subtask8aa, subtask8ab, subtask8ac));
            feature8b.setSubtasks(List.of(subtask8ba, subtask8bb, subtask8bc));
            feature8c.setSubtasks(List.of(subtask8ca, subtask8cb, subtask8cc));
            feature9a.setSubtasks(List.of(subtask9aa, subtask9ab, subtask9ac));
            feature9b.setSubtasks(List.of(subtask9ba, subtask9bb, subtask9bc));
            feature9c.setSubtasks(List.of(subtask9ca, subtask9cb, subtask9cc));

            product1.setFeatures(List.of(feature1a, feature1b, feature1c));
            product2.setFeatures(List.of(feature2a, feature2b, feature2c));
            product3.setFeatures(List.of(feature3a, feature3b, feature3c));
            product4.setFeatures(List.of(feature4a, feature4b, feature4c));
            product5.setFeatures(List.of(feature5a, feature5b, feature5c));
            product6.setFeatures(List.of(feature6a, feature6b, feature6c));
            product7.setFeatures(List.of(feature7a, feature7b, feature7c));
            product8.setFeatures(List.of(feature8a, feature8b, feature8c));
            product9.setFeatures(List.of(feature9a, feature9b, feature9c));

            productowner1.setProduct(product1);
            productowner2.setProduct(product2);
            productowner3.setProduct(product3);
            productowner4.setProduct(product4);
            productowner5.setProduct(product5);
            productowner6.setProduct(product6);
            productowner7.setProduct(product7);
            productowner8.setProduct(product8);
            productowner9.setProduct(product9);

            member1a.setProductowner(productowner1);
            member1b.setProductowner(productowner1);
            member1c.setProductowner(productowner1);
            member2a.setProductowner(productowner2);
            member2b.setProductowner(productowner2);
            member2c.setProductowner(productowner2);
            member3a.setProductowner(productowner3);
            member3b.setProductowner(productowner3);
            member3c.setProductowner(productowner3);
            member4a.setProductowner(productowner4);
            member4b.setProductowner(productowner4);
            member4c.setProductowner(productowner4);
            member5a.setProductowner(productowner5);
            member5b.setProductowner(productowner5);
            member5c.setProductowner(productowner5);
            member6a.setProductowner(productowner6);
            member6b.setProductowner(productowner6);
            member6c.setProductowner(productowner6);
            member7a.setProductowner(productowner7);
            member7b.setProductowner(productowner7);
            member7c.setProductowner(productowner7);
            member8a.setProductowner(productowner8);
            member8b.setProductowner(productowner8);
            member8c.setProductowner(productowner8);
            member9a.setProductowner(productowner9);
            member9b.setProductowner(productowner9);
            member9c.setProductowner(productowner9);

            product1.setProductowner(productowner1);
            product2.setProductowner(productowner2);
            product3.setProductowner(productowner3);
            product4.setProductowner(productowner4);
            product5.setProductowner(productowner5);
            product6.setProductowner(productowner6);
            product7.setProductowner(productowner7);
            product8.setProductowner(productowner8);
            product9.setProductowner(productowner9);

            product1.setPquarters(List.of(pQuarter1a, pQuarter1b, pQuarter1c, pQuarter1d));
            product2.setPquarters(List.of(pQuarter2a, pQuarter2b, pQuarter2c, pQuarter2d));
            product3.setPquarters(List.of(pQuarter3a, pQuarter3b, pQuarter3c, pQuarter3d));
            product4.setPquarters(List.of(pQuarter4a, pQuarter4b, pQuarter4c, pQuarter4d));
            product5.setPquarters(List.of(pQuarter5a, pQuarter5b, pQuarter5c, pQuarter5d));
            product6.setPquarters(List.of(pQuarter6a, pQuarter6b, pQuarter6c, pQuarter6d));
            product7.setPquarters(List.of(pQuarter7a, pQuarter7b, pQuarter7c, pQuarter7d));
            product8.setPquarters(List.of(pQuarter8a, pQuarter8b, pQuarter8c, pQuarter8d));
            product9.setPquarters(List.of(pQuarter9a, pQuarter9b, pQuarter9c, pQuarter9d));

            productowner1.setMembers(List.of(member1a, member1b, member1c));
            productowner2.setMembers(List.of(member2a, member2b, member2c));
            productowner3.setMembers(List.of(member3a, member3b, member3c));
            productowner4.setMembers(List.of(member4a, member4b, member4c));
            productowner5.setMembers(List.of(member5a, member5b, member5c));
            productowner6.setMembers(List.of(member6a, member6b, member6c));
            productowner7.setMembers(List.of(member7a, member7b, member7c));
            productowner8.setMembers(List.of(member8a, member8b, member8c));
            productowner9.setMembers(List.of(member9a, member9b, member9c));

            pmo1.setProductowners(List.of(productowner1, productowner2, productowner3, productowner4, productowner5));
            pmo2.setProductowners(List.of(productowner6, productowner7, productowner8, productowner9));

            List<PMO> pmoList = new ArrayList<>();
            pmoList.add(pmo1);
            pmoList.add(pmo2);

            pmoRepository.saveAll(pmoList);
        };
    }

    @Bean
    List<ProductDb> productDBThirdParty(){
        SubtaskDb subtask1aa = new SubtaskDb("S001", "BITCOIN PURCHASING", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2024, Calendar.JANUARY, 5).getTime(), "U13");
        SubtaskDb subtask1ab = new SubtaskDb("S002", "SOLANA PURCHASING", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 4).getTime(), new GregorianCalendar(2024, Calendar.JANUARY, 16).getTime(), "U13");
        SubtaskDb subtask1ac = new SubtaskDb("S003", "SUI PURCHASING", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 10).getTime(), new GregorianCalendar(2024, Calendar.JANUARY, 20).getTime(), "U13");
        SubtaskDb subtask1ba = new SubtaskDb("S004", "HYPERLIQUID PURCHASING", "In Progress", new GregorianCalendar(2024, Calendar.JANUARY, 22).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 1).getTime(), "U14");
        SubtaskDb subtask1bb = new SubtaskDb("S005", "ORCA PURCHASING", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 25).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 5).getTime(), "U14");
        SubtaskDb subtask1bc = new SubtaskDb("S006", "RAYDIUM PURCHASING", "In Progress", new GregorianCalendar(2024, Calendar.FEBRUARY, 1).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 10).getTime(), "U14");
        SubtaskDb subtask1ca = new SubtaskDb("S007", "ARBITRUM PURCHASING", "Done", new GregorianCalendar(2024, Calendar.FEBRUARY, 15).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime(), "U15");
        SubtaskDb subtask1cb = new SubtaskDb("S008", "MANTA PURCHASING", "In Progress", new GregorianCalendar(2024, Calendar.FEBRUARY, 20).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 10).getTime(), "U15");
        SubtaskDb subtask1cc = new SubtaskDb("S009", "OPTIMISTIC PURCHASING", "Done", new GregorianCalendar(2024, Calendar.MARCH, 1).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 25).getTime(), "U15");

        FeatureDb feature1a = new FeatureDb("FPRO1", "Feature L1", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JANUARY, 1).getTime(), new GregorianCalendar(2024, Calendar.JANUARY, 20).getTime(), List.of(subtask1aa, subtask1ab, subtask1ac));
        FeatureDb feature1b = new FeatureDb("FPRO2", "Feature DECENTRALIZED FINANCE", "In Progress", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JANUARY, 22).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 10).getTime(), List.of(subtask1ba, subtask1bb, subtask1bc));
        FeatureDb feature1c = new FeatureDb("FPRO3", "Feature L2", "In Progress", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.FEBRUARY, 15).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 25).getTime(), List.of(subtask1ca, subtask1cb, subtask1cc));

        ProductDb productDb1 = new ProductDb("BTCUSD", "Q1", "Q2", "Q3", "Q4", 3, 0, 0, 0, 1, 0, 0, 0, List.of(feature1a, feature1b, feature1c));

        ArrayList<ProductDb> productDbArrayList = new ArrayList<>();
        productDbArrayList.add(productDb1);
        return productDbArrayList;
    }
}
