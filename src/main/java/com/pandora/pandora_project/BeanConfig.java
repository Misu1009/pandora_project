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
// Skenario full (q1-q4)
@Configuration
public class BeanConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            PMORepository pmoRepository
    ){
        return args-> {
            PMO pmo1 = new PMO("PMO 1", "U1", "GPOL", "pmo1@xyz.com", "PMO", "S5", "pass123");

            ProductOwner productowner1 = new ProductOwner("Product Owner 1", "U4", "ABCD", "productowner1@xyz.com", "ABC", "s2", "pass123");
            ProductOwner productowner2 = new ProductOwner("Product Owner 2", "U5", "EFGH", "productowner2@xyz.com", "DEF", "s2", "pass123");

            Member member1a = new Member("Member 1a", "U13", "ABCD", "member1a@xyz.com", "ABC", "s7", "pass123");
            Member member1b = new Member("Member 1b", "U14", "ABCD", "member1b@xyz.com", "ABC", "s7", "pass123");
//            Member member1c = new Member("Member 1c", "U17", "ABCD", "member1b@xyz.com", "ABC", "s7", "pass123");

            Member member2a = new Member("Member 2a", "U15", "EFGH", "member2a@xyz.com", "DEF", "s7", "pass123");
            Member member2b = new Member("Member 2b", "U16", "EFGH", "member2b@xyz.com", "DEF", "s7", "pass123");

            Product product1 = new Product("PR1", "MyBCA", "Mico External", 0.0);
            Product product2 = new Product("PR2", "MyCrypto", "Mico Internal", 0.0);

            Feature feature1aQ1 = new Feature("FPRO1", "Feature 1a Q1", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JANUARY, 15).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 28).getTime());
            Feature feature1bQ1 = new Feature("FPRO2", "Feature 1b Q1", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JANUARY, 10).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 20).getTime());
            Feature feature1aQ2 = new Feature("FPRO3", "Feature 1a Q2", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.APRIL, 5).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime());
            Feature feature1bQ2 = new Feature("FPRO4", "Feature 1b Q2", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime());
            Feature feature1cQ2 = new Feature("FPRO5", "Feature 1c Q2", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 20).getTime());
            Feature feature1dQ2 = new Feature("FPRO6", "Feature 1d Q2", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.APRIL, 20).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime());
            Feature feature1aQ3 = new Feature("FPRO7", "Feature 1a Q3", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 25).getTime());
            Feature feature1bQ3 = new Feature("FPRO8", "Feature 1b Q3", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JULY, 15).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime());
            Feature feature1cQ3 = new Feature("FPRO9", "Feature 1c Q3", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 20).getTime());
            Feature feature1aQ4 = new Feature("FPRO10", "Pengelolaan Keuangan yang Lebih Baik", "In Progress", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.OCTOBER, 1).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime());
            Feature feature1bQ4 = new Feature("FPRO11", "Pembelian Aset Kripto dengan Sumber Dana dari Rekening BCA", "In Progress", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.OCTOBER, 22).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime());
            Feature feature1cQ4 = new Feature("FPRO12", "Tampilan Portofolio Kripto di MyBCA", "In Progress", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.NOVEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime());

            Feature feature2aQ1 = new Feature("FPRO13", "Feature 2a Q1", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JANUARY, 8).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime());
            Feature feature2bQ1 = new Feature("FPRO14", "Feature 2b Q1", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.FEBRUARY, 1).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 15).getTime());
            Feature feature2aQ2 = new Feature("FPRO15", "Feature 2a Q2", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.APRIL, 10).getTime(), new GregorianCalendar(2024, Calendar.MAY, 30).getTime());
            Feature feature2bQ2 = new Feature("FPRO16", "Feature 2b Q2", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 20).getTime());
            Feature feature2cQ2 = new Feature("FPRO17", "Feature 2c Q2", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime());
            Feature feature2dQ2 = new Feature("FPRO18", "Feature 2d Q2", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.MAY, 10).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime());
            Feature feature2aQ3 = new Feature("FPRO19", "Feature 2a Q3", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JULY, 12).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 30).getTime());
            Feature feature2bQ3 = new Feature("FPRO20", "Feature 2b Q3", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 15).getTime());
            Feature feature2cQ3 = new Feature("FPRO21", "Feature 2c Q3", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime());
            Feature feature2aQ4 = new Feature("FPRO22", "Staking dan Yield FarmingT", "In Progress", "Strategic Topic 2", new GregorianCalendar(2024, Calendar.OCTOBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime());
            Feature feature2bQ4 = new Feature("FPRO23", "Peningkatan Keamanan dengan MFA", "In Progress", "Strategic Topic 2", new GregorianCalendar(2024, Calendar.NOVEMBER, 1).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime());
            Feature feature2cQ4 = new Feature("FPRO24", "Edukasi Kripto dalam AplikasiT", "In Progress", "Strategic Topic 2", new GregorianCalendar(2024, Calendar.NOVEMBER, 1).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime());

            Subtask subtask1aaQ1 = new Subtask("S001", "Subtask 1aa Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 15).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 30).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 28).getTime(), "U13");
            Subtask subtask1abQ1 = new Subtask("S002", "Subtask 1ab Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 16).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 30).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 28).getTime(), "U13");

            Subtask subtask1baQ1 = new Subtask("S003", "Subtask 1ba Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 10).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 20).getTime(), "U14");
            Subtask subtask1bbQ1 = new Subtask("S004", "Subtask 1bb Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 11).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 1).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 20).getTime(), "U14");
            Subtask subtask1bcQ1 = new Subtask("S005", "Subtask 1bc Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 12).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 10).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 20).getTime(), "U14");

            Subtask subtask1aaQ2 = new Subtask("S006", "Subtask 1aa Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 5).getTime(), new GregorianCalendar(2024, Calendar.MAY, 10).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), "U13");
            Subtask subtask1abQ2 = new Subtask("S007", "Subtask 1ab Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 6).getTime(), new GregorianCalendar(2024, Calendar.MAY, 15).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), "U13");

            Subtask subtask1baQ2 = new Subtask("S008", "Subtask 1ba Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "U14");
            Subtask subtask1bbQ2 = new Subtask("S009", "Subtask 1bb Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 16).getTime(), new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "U14");
            Subtask subtask1bcQ2 = new Subtask("S010", "Subtask 1bc Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 17).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 5).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "U14");

            Subtask subtask1caQ2 = new Subtask("S011", "Subtask 1ca Q2", "Done", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), "U14");
            Subtask subtask1cbQ2 = new Subtask("S012", "Subtask 1cb Q2", "Done", new GregorianCalendar(2024, Calendar.MAY, 2).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), "U14");

            Subtask subtask1daQ2 = new Subtask("S013", "Subtask 1da Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 20).getTime(), new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), "U14");
            Subtask subtask1dbQ2 = new Subtask("S014", "Subtask 1db Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 21).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 5).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), "U14");
            Subtask subtask1dcQ2 = new Subtask("S015", "Subtask 1dc Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 22).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), "U14");

            Subtask subtask1aaQ3 = new Subtask("S016", "Subtask 1aa Q3", "Done", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 15).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 25).getTime(), "U13");
            Subtask subtask1abQ3 = new Subtask("S017", "Subtask 1ab Q3", "Done", new GregorianCalendar(2024, Calendar.JULY, 6).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 25).getTime(), "U13");

            Subtask subtask1baQ3 = new Subtask("S018", "Subtask 1ba Q3", "Done", new GregorianCalendar(2024, Calendar.JULY, 15).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 25).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), "U13");
            Subtask subtask1bbQ3 = new Subtask("S019", "Subtask 1bb Q3", "Done", new GregorianCalendar(2024, Calendar.JULY, 16).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 1).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), "U13");
            Subtask subtask1bcQ3 = new Subtask("S020", "Subtask 1bc Q3", "Done", new GregorianCalendar(2024, Calendar.JULY, 17).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 5).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), "U13");

            Subtask subtask1caQ3 = new Subtask("S021", "Subtask 1ca Q3", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 20).getTime(), "U14");
            Subtask subtask1cbQ3 = new Subtask("S022", "Subtask 1cb Q3", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 2).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 20).getTime(), "U14");

            Subtask subtask1aaQ4 = new Subtask("S023", "Pengembangan fitur kategorisasi otomatis transaksi", "To Do", new GregorianCalendar(2024, Calendar.OCTOBER, 17).getTime(), new GregorianCalendar(2024, Calendar.NOVEMBER, 30).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U13");
            Subtask subtask1abQ4 = new Subtask("S024", "Pembuatan grafik dan laporan pengeluaran", "To Do", new GregorianCalendar(2024, Calendar.OCTOBER, 17).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U13");
            Subtask subtask1acQ4 = new Subtask("S025", "Implementasi fitur budgeting dan notifikasi jika anggaran terlampaui", "In Progress", new GregorianCalendar(2024, Calendar.OCTOBER, 17).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U13");

            Subtask subtask1baQ4 = new Subtask("S026", "Pengembangan sistem otorisasi transaksi antara MyBCA dan MyKripto", "In Progress", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13");
            Subtask subtask1bbQ4 = new Subtask("S027", "Implementasi fitur pemilihan sumber dana dari rekening BCA yang berbeda", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13");
            Subtask subtask1bcQ4 = new Subtask("S028", "Pengembangan mekanisme refund jika transaksi gagal", "In Progress", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 18).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13");
            Subtask subtask1bdQ4 = new Subtask("S029", "Pengujian user acceptance test (UAT) untuk memastikan kemudahan penggunaan", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13");

            Subtask subtask1caQ4 = new Subtask("S030", "Pengembangan API untuk mengambil data portofolio dari MyKripto", "In Progress", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14");
            Subtask subtask1cbQ4 = new Subtask("S031", "Pembuatan dashboard di MyBCA untuk menampilkan nilai aset kripto dalam Rupiah", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 18).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14");
            Subtask subtask1ccQ4 = new Subtask("S032", "Implementasi fitur refresh otomatis untuk memperbarui data portofolio", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14");
            Subtask subtask1cdQ4 = new Subtask("S033", "Pengembangan fitur notifikasi jika terjadi perubahan signifikan pada nilai portofolio", "In Progress", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14");

            Subtask subtask2aaQ1 = new Subtask("S034", "Subtask 2aa Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 8).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 10).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime(), "U15");
            Subtask subtask2abQ1 = new Subtask("S035", "Subtask 2ab Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 9).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 15).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime(), "U15");
            Subtask subtask2acQ1 = new Subtask("S036", "Subtask 2ac Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 10).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 20).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime(), "U15");

            Subtask subtask2baQ1 = new Subtask("S037", "Subtask 2ba Q1", "Done", new GregorianCalendar(2024, Calendar.FEBRUARY, 1).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 5).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 15).getTime(), "U16");
            Subtask subtask2bbQ1 = new Subtask("S038", "Subtask 2bb Q1", "Done", new GregorianCalendar(2024, Calendar.FEBRUARY, 2).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 10).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 15).getTime(), "U16");

            Subtask subtask2aaQ2 = new Subtask("S039", "Subtask 2aa Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 10).getTime(), new GregorianCalendar(2024, Calendar.MAY, 15).getTime(), new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "U15");
            Subtask subtask2abQ2 = new Subtask("S040", "Subtask 2ab Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 11).getTime(), new GregorianCalendar(2024, Calendar.MAY, 20).getTime(), new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "U15");
            Subtask subtask2acQ2 = new Subtask("S041", "Subtask 2ac Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 12).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), "U15");

            Subtask subtask2baQ2 = new Subtask("S042", "Subtask 2ba Q2", "Done", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), "U15");
            Subtask subtask2bbQ2 = new Subtask("S043", "Subtask 2bb Q2", "Done", new GregorianCalendar(2024, Calendar.MAY, 2).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), "U15");

            Subtask subtask2caQ2 = new Subtask("S044", "Subtask 2ca Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), new GregorianCalendar(2024, Calendar.MAY, 15).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), "U16");
            Subtask subtask2cbQ2 = new Subtask("S045", "Subtask 2cb Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 16).getTime(), new GregorianCalendar(2024, Calendar.MAY, 18).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), "U16");
            Subtask subtask2ccQ2 = new Subtask("S046", "Subtask 2cc Q2", "Done", new GregorianCalendar(2024, Calendar.APRIL, 17).getTime(), new GregorianCalendar(2024, Calendar.MAY, 20).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), "U16");

            Subtask subtask2daQ2 = new Subtask("S047", "Subtask 2da Q2", "Done", new GregorianCalendar(2024, Calendar.MAY, 10).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 5).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), "U16");
            Subtask subtask2dbQ2 = new Subtask("S048", "Subtask 2db Q2", "Done", new GregorianCalendar(2024, Calendar.MAY, 11).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), "U16");

            Subtask subtask2aaQ3 = new Subtask("S049", "Subtask 2aa Q3", "Done", new GregorianCalendar(2024, Calendar.JULY, 12).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 15).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 30).getTime(), "U15");
            Subtask subtask2abQ3 = new Subtask("S050", "Subtask 2ab Q3", "Done", new GregorianCalendar(2024, Calendar.JULY, 13).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 30).getTime(), "U15");
            Subtask subtask2acQ3 = new Subtask("S051", "Subtask 2ac Q3", "Done", new GregorianCalendar(2024, Calendar.JULY, 14).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 25).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 30).getTime(), "U15");

            Subtask subtask2baQ3 = new Subtask("S052", "Subtask 2ba Q3", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 5).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 15).getTime(), "U15");
            Subtask subtask2bbQ3 = new Subtask("S053", "Subtask 2bb Q3", "Done", new GregorianCalendar(2024, Calendar.AUGUST, 2).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 15).getTime(), "U15");

            Subtask subtask2caQ3 = new Subtask("S054", "Subtask 2ca Q3", "Done", new GregorianCalendar(2024, Calendar.JULY, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 25).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), "U16");
            Subtask subtask2cbQ3 = new Subtask("S055", "Subtask 2cb Q3", "Done", new GregorianCalendar(2024, Calendar.JULY, 21).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 1).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), "U16");
            Subtask subtask2ccQ3 = new Subtask("S056", "Subtask 2cc Q3", "Done", new GregorianCalendar(2024, Calendar.JULY, 22).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 5).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), "U16");

            Subtask subtask2aaQ4 = new Subtask("S057", "Penelitian dan pemilihan protokol staking dan yield farming yang sesuai.", "In Progress", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U15");
            Subtask subtask2abQ4 = new Subtask("S058", "Pengembangan smart contract untuk mengelola proses staking dan yield farming.", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 18).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U15");
            Subtask subtask2acQ4 = new Subtask("S059", "Pembuatan antarmuka pengguna untuk memilih aset kripto yang akan di-stake atau digunakan dalam yield farming.", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U15");
            Subtask subtask2adQ4 = new Subtask("S060", "Pengembangan sistem perhitungan dan distribusi reward.", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U15");
            Subtask subtask2aeQ4 = new Subtask("S061", "Audit keamanan smart contract oleh pihak ketiga.", "In Progress", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U15");

//            Subtask subtask2baQ4 = new Subtask("S062", "Implementasi MFA menggunakan aplikasi autentikator (seperti Google Authenticator atau Authy", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U16");
//            Subtask subtask2bbQ4 = new Subtask("S063", "Pengembangan fitur backup code untuk pemulihan akun.", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 18).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U16");
//            Subtask subtask2bcQ4 = new Subtask("S064", "Pengujian keamanan MFA untuk mencegah akses yang tidak sah.", "In Progress", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U16");
//            Subtask subtask2bdQ4 = new Subtask("S065", "Pengembangan antiphising", "In Progress", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U16");

            Subtask subtask2caQ4 = new Subtask("S066", "Pembuatan konten edukasi tentang kripto dalam berbagai format (artikel, video, infografis).", "In Progress", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U16");
            Subtask subtask2cbQ4 = new Subtask("S067", "Pengembangan fitur quiz untuk menguji pemahaman pengguna.", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 18).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U16");
            Subtask subtask2ccQ4 = new Subtask("S068", "Integrasi dengan komunitas kripto untuk menyediakan informasi terbaru.", "In Progress", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U16");


            KQuarter kquarter1aa = new KQuarter("Q1", 2, 2, 4.0, 3.2, 3.2, 2.9, 0, 0);
            KQuarter kquarter1ab = new KQuarter("Q2", 4, 4, 3.5, 4.0, 3.2, 3.4, 0, 0);
            KQuarter kquarter1ac = new KQuarter("Q3", 3, 3, 4.0, 2.8, 2.9, 3.9, 0, 0);
            KQuarter kquarter1ad = new KQuarter("Q4", 3, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter1ba = new KQuarter("Q1", 2, 2, 4.0, 2.5, 3.0, 4.0, 0, 0);
            KQuarter kquarter1bb = new KQuarter("Q2", 4, 4, 3.7, 4.0, 3.0, 3.0, 0, 0);
            KQuarter kquarter1bc = new KQuarter("Q3", 3, 3, 2.9, 4.0, 3.0, 3.1, 0, 0);
            KQuarter kquarter1bd = new KQuarter("Q4", 3, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);

            KQuarter kquarter2aa = new KQuarter("Q1", 2, 2, 4.0, 3.5, 4.0, 3.5, 0, 0);
            KQuarter kquarter2ab = new KQuarter("Q2", 4, 4, 3.2, 4.0, 3.5, 4.0, 0, 0);
            KQuarter kquarter2ac = new KQuarter("Q3", 3, 3, 3.2, 3.2, 4.0, 3.5, 0, 0);
            KQuarter kquarter2ad = new KQuarter("Q4", 3, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
            KQuarter kquarter2ba = new KQuarter("Q1", 2, 2, 3.5, 3.5, 4.0, 4.0, 0, 0);
            KQuarter kquarter2bb = new KQuarter("Q2", 4, 4, 3.1, 4.0, 4.0, 3.1, 0, 0);
            KQuarter kquarter2bc = new KQuarter("Q3", 3, 3, 4.0, 3.1, 4.0, 3.1, 0, 0);
            KQuarter kquarter2bd = new KQuarter("Q4", 3, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);

            KPI kpi1a = new KPI();
            KPI kpi1b = new KPI();
            KPI kpi2a = new KPI();
            KPI kpi2b = new KPI();

            PQuarter pQuarter1a = new PQuarter("Q1", 2, 2);
            PQuarter pQuarter1b = new PQuarter("Q2", 4, 4);
            PQuarter pQuarter1c = new PQuarter("Q3", 3, 3);
            PQuarter pQuarter1d = new PQuarter("Q4", 3, 0);

            PQuarter pQuarter2a = new PQuarter("Q1", 2, 2);
            PQuarter pQuarter2b = new PQuarter("Q2", 4, 4);
            PQuarter pQuarter2c = new PQuarter("Q3", 3, 3);
            PQuarter pQuarter2d = new PQuarter("Q4", 3, 0);

            kpi1a.setKquarters(List.of(kquarter1aa, kquarter1ab, kquarter1ac, kquarter1ad));
            kpi1b.setKquarters(List.of(kquarter1ba, kquarter1bb, kquarter1bc, kquarter1bd));
            kpi2a.setKquarters(List.of(kquarter2aa, kquarter2ab, kquarter2ac, kquarter2ad));
            kpi2b.setKquarters(List.of(kquarter2ba, kquarter2bb, kquarter2bc, kquarter2bd));

            member1a.setKpi(kpi1a);
            member1b.setKpi(kpi1b);
            member2a.setKpi(kpi2a);
            member2b.setKpi(kpi2b);

            member1a.setSubtasks(List.of(subtask1aaQ1, subtask1abQ1,
                    subtask1aaQ2, subtask1abQ2
                    , subtask1aaQ3, subtask1abQ3, subtask1baQ3, subtask1bbQ3, subtask1bcQ3
                    , subtask1aaQ4, subtask1abQ4, subtask1acQ4, subtask1baQ4, subtask1bbQ4, subtask1bcQ4, subtask1bdQ4
            ));

            member1b.setSubtasks(List.of(subtask1baQ1, subtask1bbQ1, subtask1bcQ1,
                    subtask1baQ2, subtask1bbQ2, subtask1bcQ2, subtask1caQ2, subtask1cbQ2, subtask1daQ2, subtask1dbQ2, subtask1dcQ2
                    , subtask1caQ3, subtask1cbQ3
                    , subtask1caQ4, subtask1cbQ4, subtask1ccQ4, subtask1cdQ4
            ));

            member2a.setSubtasks(List.of(subtask2aaQ1, subtask2abQ1, subtask2acQ1,
                    subtask2aaQ2, subtask2abQ2, subtask2acQ2, subtask2baQ2, subtask2bbQ2
                    , subtask2aaQ3, subtask2abQ3, subtask2acQ3, subtask2baQ3, subtask2bbQ3
                    , subtask2aaQ4, subtask2abQ4, subtask2acQ4, subtask2adQ4, subtask2aeQ4
            ));

            member2b.setSubtasks(List.of(subtask2baQ1, subtask2bbQ1,
                    subtask2caQ2, subtask2cbQ2, subtask2ccQ2, subtask2daQ2, subtask2dbQ2
                    , subtask2caQ3, subtask2cbQ3, subtask2ccQ3
                    , subtask2caQ4, subtask2cbQ4, subtask2ccQ4
            ));

            feature1aQ1.setSubtasks(List.of(subtask1aaQ1, subtask1abQ1));
            feature1bQ1.setSubtasks(List.of(subtask1baQ1, subtask1bbQ1, subtask1bcQ1));
            feature1aQ2.setSubtasks(List.of(subtask1aaQ2, subtask1abQ2));
            feature1bQ2.setSubtasks(List.of(subtask1baQ2, subtask1bbQ2, subtask1bcQ2));
            feature1cQ2.setSubtasks(List.of(subtask1caQ2, subtask1cbQ2));
            feature1dQ2.setSubtasks(List.of(subtask1daQ2, subtask1dbQ2, subtask1dcQ2));
            feature1aQ3.setSubtasks(List.of(subtask1aaQ3, subtask1abQ3));
            feature1bQ3.setSubtasks(List.of(subtask1baQ3, subtask1bbQ3, subtask1bcQ3));
            feature1cQ3.setSubtasks(List.of(subtask1caQ3, subtask1cbQ3));
            feature1aQ4.setSubtasks(List.of(subtask1aaQ4, subtask1abQ4, subtask1acQ4));
            feature1bQ4.setSubtasks(List.of(subtask1baQ4, subtask1bbQ4, subtask1bcQ4, subtask1bdQ4));
            feature1cQ4.setSubtasks(List.of(subtask1caQ4, subtask1cbQ4, subtask1ccQ4, subtask1cdQ4));

            feature2aQ1.setSubtasks(List.of(subtask2aaQ1, subtask2abQ1, subtask2acQ1));
            feature2bQ1.setSubtasks(List.of(subtask2baQ1, subtask2bbQ1));
            feature2aQ2.setSubtasks(List.of(subtask2aaQ2, subtask2abQ2, subtask2acQ2));
            feature2bQ2.setSubtasks(List.of(subtask2baQ2, subtask2bbQ2));
            feature2cQ2.setSubtasks(List.of(subtask2caQ2, subtask2cbQ2, subtask2ccQ2));
            feature2dQ2.setSubtasks(List.of(subtask2daQ2, subtask2dbQ2));
            feature2aQ3.setSubtasks(List.of(subtask2aaQ3, subtask2abQ3, subtask2acQ3));
            feature2bQ3.setSubtasks(List.of(subtask2baQ3, subtask2bbQ3));
            feature2cQ3.setSubtasks(List.of(subtask2caQ3, subtask2cbQ3, subtask2ccQ3));
            feature2aQ4.setSubtasks(List.of(subtask2aaQ4, subtask2abQ4, subtask2acQ4, subtask2adQ4, subtask2aeQ4));
            feature2cQ4.setSubtasks(List.of(subtask2caQ4, subtask2cbQ4, subtask2ccQ4));

            product1.setFeatures(List.of(
                    feature1aQ1, feature1bQ1,      // Features Q1
                    feature1aQ2, feature1bQ2, feature1cQ2, feature1dQ2,    // Features Q2
                    feature1aQ3, feature1bQ3, feature1cQ3,    // Features Q3
                    feature1aQ4, feature1bQ4, feature1cQ4
            ));

            product2.setFeatures(List.of(
                    feature2aQ1, feature2bQ1,      // Features Q1
                    feature2aQ2, feature2bQ2, feature2cQ2, feature2dQ2,    // Features Q2
                    feature2aQ3, feature2bQ3, feature2cQ3,    // Features Q3
                    feature2aQ4, feature2bQ4, feature2cQ4
            ));

            productowner1.setProduct(product1);
            productowner2.setProduct(product2);

            member1a.setProductowner(productowner1);
            member1b.setProductowner(productowner1);
            member2a.setProductowner(productowner2);
            member2b.setProductowner(productowner2);

            product1.setProductowner(productowner1);
            product2.setProductowner(productowner2);

            product1.setPquarters(List.of(pQuarter1a, pQuarter1b, pQuarter1c, pQuarter1d));
            product2.setPquarters(List.of(pQuarter2a, pQuarter2b, pQuarter2c, pQuarter2d));

            productowner1.setMembers(List.of(member1a, member1b));
            productowner2.setMembers(List.of(member2a, member2b));

            pmo1.setProductowners(List.of(productowner1, productowner2));

            List<PMO> pmoList = new ArrayList<>();
            pmoList.add(pmo1);

            pmoRepository.saveAll(pmoList);
        };
    }

    @Bean
    List<ProductDb> productDBThirdParty(){
        // u13 5 on schedule late 2
        // u14 2 on schedule late 2
        SubtaskDb subtask1aaQ4 = new SubtaskDb("S023", "Pengembangan fitur kategorisasi otomatis transaksi", "Done", new GregorianCalendar(2024, Calendar.OCTOBER, 17).getTime(), new GregorianCalendar(2024, Calendar.NOVEMBER, 30).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U13"); // on schedule
        SubtaskDb subtask1abQ4 = new SubtaskDb("S024", "Pembuatan grafik dan laporan pengeluaran", "Done", new GregorianCalendar(2024, Calendar.OCTOBER, 17).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U13"); // on schedule
        SubtaskDb subtask1acQ4 = new SubtaskDb("S025", "Implementasi fitur budgeting dan notifikasi jika anggaran terlampaui", "Done", new GregorianCalendar(2024, Calendar.OCTOBER, 17).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U13"); // on schedule
        SubtaskDb subtask1baQ4 = new SubtaskDb("S026", "Pengembangan sistem otorisasi transaksi antara MyBCA dan MyKripto", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13"); // on schedule
        SubtaskDb subtask1bbQ4 = new SubtaskDb("S027", "Implementasi fitur pemilihan sumber dana dari rekening BCA yang berbeda", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13"); // on schedule
        SubtaskDb subtask1bcQ4 = new SubtaskDb("S028", "Pengembangan mekanisme refund jika transaksi gagal", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 24).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13"); // late
        SubtaskDb subtask1bdQ4 = new SubtaskDb("S029", "Pengujian user acceptance test (UAT) untuk memastikan kemudahan penggunaan", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13"); // on schedule
        SubtaskDb subtask1caQ4 = new SubtaskDb("S030", "Pengembangan API untuk mengambil data portofolio dari MyKripto", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14"); // on schedule
        SubtaskDb subtask1cbQ4 = new SubtaskDb("S031", "Pembuatan dashboard di MyBCA untuk menampilkan nilai aset kripto dalam Rupiah", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 18).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14"); // on schedule
        SubtaskDb subtask1ccQ4 = new SubtaskDb("S032", "Implementasi fitur refresh otomatis untuk memperbarui data portofolio", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 28).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14"); // late
        SubtaskDb subtask1cdQ4 = new SubtaskDb("S033", "Pengembangan fitur notifikasi jika terjadi perubahan signifikan pada nilai portofolio", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 27).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14"); // late

        FeatureDb feature1aQ4 = new FeatureDb("FPRO10", "Pengelolaan Keuangan yang Lebih Baik", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.OCTOBER, 1).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), List.of(subtask1aaQ4, subtask1abQ4, subtask1acQ4));
        FeatureDb feature1bQ4 = new FeatureDb("FPRO11", "Pembelian Aset Kripto dengan Sumber Dana dari Rekening BCA", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.OCTOBER, 22).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), List.of(subtask1baQ4, subtask1bbQ4, subtask1bcQ4, subtask1bdQ4));
        FeatureDb feature1cQ4 = new FeatureDb("FPRO12", "Tampilan Portofolio Kripto di MyBCA", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.NOVEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), List.of(subtask1caQ4, subtask1cbQ4, subtask1ccQ4, subtask1cdQ4));

        ProductDb productDb1 = new ProductDb("PR1",
                "Q1", "Q2", "Q3", "Q4",
                2, 4, 3, 3,
                2, 4, 3, 3,
                List.of(feature1aQ4, feature1bQ4, feature1cQ4)
        );

        // U15 = 2 on schedule 3 late
        // U16 = 3 on schedule 4 late
        SubtaskDb subtask2aaQ4 = new SubtaskDb("S057", "Penelitian dan pemilihan protokol staking dan yield farming yang sesuai.", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U15"); // on schedule
        SubtaskDb subtask2abQ4 = new SubtaskDb("S058", "Pengembangan smart contract untuk mengelola proses staking dan yield farming.", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 24).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U15"); // late
        SubtaskDb subtask2acQ4 = new SubtaskDb("S059", "Pembuatan antarmuka pengguna untuk memilih aset kripto yang akan di-stake atau digunakan dalam yield farming.", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 21).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U15"); // late
        SubtaskDb subtask2adQ4 = new SubtaskDb("S060", "Pengembangan sistem perhitungan dan distribusi reward.", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U15"); // late
        SubtaskDb subtask2aeQ4 = new SubtaskDb("S061", "Audit keamanan smart contract oleh pihak ketiga.", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 18).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U15"); // on schedule
        SubtaskDb subtask2baQ4 = new SubtaskDb("S062", "Implementasi MFA menggunakan aplikasi autentikator (seperti Google Authenticator atau Authy", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U16"); // on schedule
        SubtaskDb subtask2bbQ4 = new SubtaskDb("S063", "Pengembangan fitur backup code untuk pemulihan akun.", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 18).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U16"); // on schedule
        SubtaskDb subtask2bcQ4 = new SubtaskDb("S064", "Pengujian keamanan MFA untuk mencegah akses yang tidak sah.", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 26).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U16"); // late
        SubtaskDb subtask2bdQ4 = new SubtaskDb("S065", "Pengembangan antiphising", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 23).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U16"); // late
        SubtaskDb subtask2caQ4 = new SubtaskDb("S066", "Pembuatan konten edukasi tentang kripto dalam berbagai format (artikel, video, infografis).", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 30).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U16"); // late
        SubtaskDb subtask2cbQ4 = new SubtaskDb("S067", "Pengembangan fitur quiz untuk menguji pemahaman pengguna.", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 26).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U16"); // late
        SubtaskDb subtask2ccQ4 = new SubtaskDb("S068", "Integrasi dengan komunitas kripto untuk menyediakan informasi terbaru.", "Done", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 9).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U16"); // on schedule

        FeatureDb feature2aQ4 = new FeatureDb("FPRO22", "Staking dan Yield Farming", "Done", "Strategic Topic 2", new GregorianCalendar(2024, Calendar.OCTOBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), List.of(subtask2aaQ4, subtask2abQ4, subtask2acQ4, subtask2adQ4, subtask2aeQ4));
        FeatureDb feature2bQ4 = new FeatureDb("FPRO23", "Peningkatan Keamanan dengan MFA", "Done", "Strategic Topic 2", new GregorianCalendar(2024, Calendar.NOVEMBER, 1).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), List.of(subtask2baQ4, subtask2bbQ4, subtask2bcQ4, subtask2bdQ4));
        FeatureDb feature2cQ4 = new FeatureDb("FPRO24", "Edukasi Kripto dalam Aplikasi", "Done", "Strategic Topic 2", new GregorianCalendar(2024, Calendar.NOVEMBER, 1).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), List.of(subtask2caQ4, subtask2cbQ4, subtask2ccQ4));

        ProductDb productDb2 = new ProductDb("PR2",
                "Q1", "Q2", "Q3", "Q4",
                2, 4, 3, 3,
                2, 4, 3, 3,
                List.of(feature2aQ4, feature2bQ4, feature2cQ4)
        );

        ArrayList<ProductDb> productDbArrayList = new ArrayList<>();
        productDbArrayList.add(productDb1);
        productDbArrayList.add(productDb2);
        return productDbArrayList;
    }
}

// only q1
//@Configuration
//public class BeanConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(
//            PMORepository pmoRepository
//    ){
//        return args-> {
//            PMO pmo1 = new PMO("PMO 1", "U1", "GPOL", "pmo1@xyz.com", "PMO", "S5", "pass123");
//
//            ProductOwner productowner1 = new ProductOwner("Product Owner 1", "U4", "ABCD", "productowner1@xyz.com", "ABC", "s2", "pass123");
//
//            Member member1a = new Member("Member 1a", "U13", "ABCD", "member1a@xyz.com", "ABC", "s7", "pass123");
//            Member member1b = new Member("Member 1b", "U14", "ABCD", "member1b@xyz.com", "ABC", "s7", "pass123");
//
//            Product product1 = new Product("PR1", "MyBCA", "Mico External", 0.0);
//            Product product2 = new Product("PR2", "MyCrypto", "Mico Internal", 0.0);
//
//            Feature feature1aQ1 = new Feature("FPRO1", "Feature 1a Q1", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JANUARY, 15).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 28).getTime());
//            Feature feature1bQ1 = new Feature("FPRO2", "Feature 1b Q1", "Done", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JANUARY, 10).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 20).getTime());
//            Feature feature1aQ2 = new Feature("FPRO3", "Feature 1a Q2", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.APRIL, 5).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime());
//            Feature feature1bQ2 = new Feature("FPRO4", "Feature 1b Q2", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime());
//            Feature feature1cQ2 = new Feature("FPRO5", "Feature 1c Q2", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 20).getTime());
//            Feature feature1dQ2 = new Feature("FPRO6", "Feature 1d Q2", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.APRIL, 20).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime());
//            Feature feature1aQ3 = new Feature("FPRO7", "Feature 1a Q3", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 25).getTime());
//            Feature feature1bQ3 = new Feature("FPRO8", "Feature 1b Q3", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.JULY, 15).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime());
//            Feature feature1cQ3 = new Feature("FPRO9", "Feature 1c Q3", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 20).getTime());
//            Feature feature1aQ4 = new Feature("FPRO10", "Pengelolaan Keuangan yang Lebih Baik", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.OCTOBER, 1).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime());
//            Feature feature1bQ4 = new Feature("FPRO11", "Pembelian Aset Kripto dengan Sumber Dana dari Rekening BCA", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.OCTOBER, 22).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime());
//            Feature feature1cQ4 = new Feature("FPRO12", "Tampilan Portofolio Kripto di MyBCA", "To Do", "Strategic Topic 1", new GregorianCalendar(2024, Calendar.NOVEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime());
//
//            Subtask subtask1aaQ1 = new Subtask("S001", "Subtask 1aa Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 15).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 30).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 28).getTime(), "U13");
//            Subtask subtask1abQ1 = new Subtask("S002", "Subtask 1ab Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 16).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 30).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 28).getTime(), "U13");
//
//            Subtask subtask1baQ1 = new Subtask("S003", "Subtask 1ba Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 10).getTime(), new GregorianCalendar(2024, Calendar.FEBRUARY, 25).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 20).getTime(), "U14");
//            Subtask subtask1bbQ1 = new Subtask("S004", "Subtask 1bb Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 11).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 1).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 20).getTime(), "U14");
//            Subtask subtask1bcQ1 = new Subtask("S005", "Subtask 1bc Q1", "Done", new GregorianCalendar(2024, Calendar.JANUARY, 12).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 10).getTime(), new GregorianCalendar(2024, Calendar.MARCH, 20).getTime(), "U14");
//
//            Subtask subtask1aaQ2 = new Subtask("S006", "Subtask 1aa Q2", "To Do", new GregorianCalendar(2024, Calendar.APRIL, 5).getTime(), new GregorianCalendar(2024, Calendar.MAY, 10).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), "U13");
//            Subtask subtask1abQ2 = new Subtask("S007", "Subtask 1ab Q2", "To Do", new GregorianCalendar(2024, Calendar.APRIL, 6).getTime(), new GregorianCalendar(2024, Calendar.MAY, 15).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), "U13");
//
//            Subtask subtask1baQ2 = new Subtask("S008", "Subtask 1ba Q2", "To Do", new GregorianCalendar(2024, Calendar.APRIL, 15).getTime(), new GregorianCalendar(2024, Calendar.MAY, 25).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "U14");
//            Subtask subtask1bbQ2 = new Subtask("S009", "Subtask 1bb Q2", "To Do", new GregorianCalendar(2024, Calendar.APRIL, 16).getTime(), new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "U14");
//            Subtask subtask1bcQ2 = new Subtask("S010", "Subtask 1bc Q2", "To Do", new GregorianCalendar(2024, Calendar.APRIL, 17).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 5).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "U14");
//
//            Subtask subtask1caQ2 = new Subtask("S011", "Subtask 1ca Q2", "To Do", new GregorianCalendar(2024, Calendar.MAY, 1).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), "U14");
//            Subtask subtask1cbQ2 = new Subtask("S012", "Subtask 1cb Q2", "To Do", new GregorianCalendar(2024, Calendar.MAY, 2).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 20).getTime(), "U14");
//
//            Subtask subtask1daQ2 = new Subtask("S013", "Subtask 1da Q2", "To Do", new GregorianCalendar(2024, Calendar.APRIL, 20).getTime(), new GregorianCalendar(2024, Calendar.MAY, 30).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), "U14");
//            Subtask subtask1dbQ2 = new Subtask("S014", "Subtask 1db Q2", "To Do", new GregorianCalendar(2024, Calendar.APRIL, 21).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 5).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), "U14");
//            Subtask subtask1dcQ2 = new Subtask("S015", "Subtask 1dc Q2", "To Do", new GregorianCalendar(2024, Calendar.APRIL, 22).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), new GregorianCalendar(2024, Calendar.JUNE, 15).getTime(), "U14");
//
//            Subtask subtask1aaQ3 = new Subtask("S016", "Subtask 1aa Q3", "To Do", new GregorianCalendar(2024, Calendar.JULY, 5).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 15).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 25).getTime(), "U13");
//            Subtask subtask1abQ3 = new Subtask("S017", "Subtask 1ab Q3", "To Do", new GregorianCalendar(2024, Calendar.JULY, 6).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 20).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 25).getTime(), "U13");
//
//            Subtask subtask1baQ3 = new Subtask("S018", "Subtask 1ba Q3", "To Do", new GregorianCalendar(2024, Calendar.JULY, 15).getTime(), new GregorianCalendar(2024, Calendar.AUGUST, 25).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), "U13");
//            Subtask subtask1bbQ3 = new Subtask("S019", "Subtask 1bb Q3", "To Do", new GregorianCalendar(2024, Calendar.JULY, 16).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 1).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), "U13");
//            Subtask subtask1bcQ3 = new Subtask("S020", "Subtask 1bc Q3", "To Do", new GregorianCalendar(2024, Calendar.JULY, 17).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 5).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), "U13");
//
//            Subtask subtask1caQ3 = new Subtask("S021", "Subtask 1ca Q3", "To Do", new GregorianCalendar(2024, Calendar.AUGUST, 1).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 10).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 20).getTime(), "U14");
//            Subtask subtask1cbQ3 = new Subtask("S022", "Subtask 1cb Q3", "To Do", new GregorianCalendar(2024, Calendar.AUGUST, 2).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.SEPTEMBER, 20).getTime(), "U14");
//
//            Subtask subtask1aaQ4 = new Subtask("S023", "Pengembangan fitur kategorisasi otomatis transaksi", "To Do", new GregorianCalendar(2024, Calendar.OCTOBER, 17).getTime(), new GregorianCalendar(2024, Calendar.NOVEMBER, 30).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U13");
//            Subtask subtask1abQ4 = new Subtask("S024", "Pembuatan grafik dan laporan pengeluaran", "To Do", new GregorianCalendar(2024, Calendar.OCTOBER, 17).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U13");
//            Subtask subtask1acQ4 = new Subtask("S025", "Implementasi fitur budgeting dan notifikasi jika anggaran terlampaui", "To Do", new GregorianCalendar(2024, Calendar.OCTOBER, 17).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), "U13");
//
//            Subtask subtask1baQ4 = new Subtask("S026", "Pengembangan sistem otorisasi transaksi antara MyBCA dan MyKripto", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 10).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13");
//            Subtask subtask1bbQ4 = new Subtask("S027", "Implementasi fitur pemilihan sumber dana dari rekening BCA yang berbeda", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13");
//            Subtask subtask1bcQ4 = new Subtask("S028", "Pengembangan mekanisme refund jika transaksi gagal", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 18).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13");
//            Subtask subtask1bdQ4 = new Subtask("S029", "Pengujian user acceptance test (UAT) untuk memastikan kemudahan penggunaan", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), "U13");
//
//            Subtask subtask1caQ4 = new Subtask("S030", "Pengembangan API untuk mengambil data portofolio dari MyKripto", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 15).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14");
//            Subtask subtask1cbQ4 = new Subtask("S031", "Pembuatan dashboard di MyBCA untuk menampilkan nilai aset kripto dalam Rupiah", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 18).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14");
//            Subtask subtask1ccQ4 = new Subtask("S032", "Implementasi fitur refresh otomatis untuk memperbarui data portofolio", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 20).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14");
//            Subtask subtask1cdQ4 = new Subtask("S033", "Pengembangan fitur notifikasi jika terjadi perubahan signifikan pada nilai portofolio", "To Do", new GregorianCalendar(2024, Calendar.NOVEMBER, 3).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 22).getTime(), new GregorianCalendar(2024, Calendar.DECEMBER, 25).getTime(), "U14");
//
//            KQuarter kquarter1aa = new KQuarter("Q1", 2, 2, 4.0, 3.2, 3.2, 2.9, 0, 2);
//            KQuarter kquarter1ab = new KQuarter("Q2", 4, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
//            KQuarter kquarter1ac = new KQuarter("Q3", 3, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
//            KQuarter kquarter1ad = new KQuarter("Q4", 3, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
//            KQuarter kquarter1ba = new KQuarter("Q1", 2, 0, 0.0, 0.0, 0.0, 0.0, 3, 0);
//            KQuarter kquarter1bb = new KQuarter("Q2", 4, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
//            KQuarter kquarter1bc = new KQuarter("Q3", 3, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
//            KQuarter kquarter1bd = new KQuarter("Q4", 3, 0, 0.0, 0.0, 0.0, 0.0, 0, 0);
//
//            KPI kpi1a = new KPI();
//            KPI kpi1b = new KPI();
//
//            PQuarter pQuarter1a = new PQuarter("Q1", 2, 2);
//            PQuarter pQuarter1b = new PQuarter("Q2", 4, 4);
//            PQuarter pQuarter1c = new PQuarter("Q3", 3, 3);
//            PQuarter pQuarter1d = new PQuarter("Q4", 3, 0);
//
//            PQuarter pQuarter2a = new PQuarter("Q1", 2, 2);
//            PQuarter pQuarter2b = new PQuarter("Q2", 4, 4);
//            PQuarter pQuarter2c = new PQuarter("Q3", 3, 3);
//            PQuarter pQuarter2d = new PQuarter("Q4", 3, 0);
//
//            kpi1a.setKquarters(List.of(kquarter1aa, kquarter1ab, kquarter1ac, kquarter1ad));
//            kpi1b.setKquarters(List.of(kquarter1ba, kquarter1bb, kquarter1bc, kquarter1bd));
//
//            member1a.setKpi(kpi1a);
//            member1b.setKpi(kpi1b);
//
//            member1a.setSubtasks(List.of(subtask1aaQ1, subtask1abQ1,
//                    subtask1aaQ2, subtask1abQ2
//                    , subtask1aaQ3, subtask1abQ3, subtask1baQ3, subtask1bbQ3, subtask1bcQ3
//                    , subtask1aaQ4, subtask1abQ4, subtask1acQ4, subtask1baQ4, subtask1bbQ4, subtask1bcQ4, subtask1bdQ4
//            ));
//
//            member1b.setSubtasks(List.of(subtask1baQ1, subtask1bbQ1, subtask1bcQ1,
//                    subtask1baQ2, subtask1bbQ2, subtask1bcQ2, subtask1caQ2, subtask1cbQ2, subtask1daQ2, subtask1dbQ2, subtask1dcQ2
//                    , subtask1caQ3, subtask1cbQ3
//                    , subtask1caQ4, subtask1cbQ4, subtask1ccQ4, subtask1cdQ4
//            ));
//
//            feature1aQ1.setSubtasks(List.of(subtask1aaQ1, subtask1abQ1));
//            feature1bQ1.setSubtasks(List.of(subtask1baQ1, subtask1bbQ1, subtask1bcQ1));
//            feature1aQ2.setSubtasks(List.of(subtask1aaQ2, subtask1abQ2));
//            feature1bQ2.setSubtasks(List.of(subtask1baQ2, subtask1bbQ2, subtask1bcQ2));
//            feature1cQ2.setSubtasks(List.of(subtask1caQ2, subtask1cbQ2));
//            feature1dQ2.setSubtasks(List.of(subtask1daQ2, subtask1dbQ2, subtask1dcQ2));
//            feature1aQ3.setSubtasks(List.of(subtask1aaQ3, subtask1abQ3));
//            feature1bQ3.setSubtasks(List.of(subtask1baQ3, subtask1bbQ3, subtask1bcQ3));
//            feature1cQ3.setSubtasks(List.of(subtask1caQ3, subtask1cbQ3));
//            feature1aQ4.setSubtasks(List.of(subtask1aaQ4, subtask1abQ4, subtask1acQ4));
//            feature1bQ4.setSubtasks(List.of(subtask1baQ4, subtask1bbQ4, subtask1bcQ4, subtask1bdQ4));
//            feature1cQ4.setSubtasks(List.of(subtask1caQ4, subtask1cbQ4, subtask1ccQ4, subtask1cdQ4));
//
//            product1.setFeatures(List.of(
//                    feature1aQ1, feature1bQ1,
//                    feature1aQ2, feature1bQ2, feature1cQ2, feature1dQ2,
//                    feature1aQ3, feature1bQ3, feature1cQ3,
//                    feature1aQ4, feature1bQ4, feature1cQ4
//            ));
//
//            productowner1.setProduct(product1);
//
//            member1a.setProductowner(productowner1);
//            member1b.setProductowner(productowner1);
//
//            product1.setProductowner(productowner1);
//
//            product1.setPquarters(List.of(pQuarter1a, pQuarter1b, pQuarter1c, pQuarter1d));
//            product2.setPquarters(List.of(pQuarter2a, pQuarter2b, pQuarter2c, pQuarter2d));
//
//            productowner1.setMembers(List.of(member1a, member1b));
//
//            pmo1.setProductowners(List.of(productowner1));
//
//            List<PMO> pmoList = new ArrayList<>();
//            pmoList.add(pmo1);
//
//            pmoRepository.saveAll(pmoList);
//        };
//    }
//}