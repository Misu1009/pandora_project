package com.pandora.pandora_project.service;

import com.pandora.pandora_project.controller.ProductController;
import com.pandora.pandora_project.dto.KQuarterD;
import com.pandora.pandora_project.jira.FeatureDb;
import com.pandora.pandora_project.jira.ProductDb;
import com.pandora.pandora_project.jira.SubtaskDb;
import com.pandora.pandora_project.model.*;
import com.pandora.pandora_project.repository.*;
import jakarta.transaction.Transactional;
import jdk.jfr.Category;
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
import java.util.*;

@Service
public class ProductOwnerService{
    private final PMORepository pmoRepository;
    private final ProductOwnerRepository productownerRepository;
    private final ProductRepository productRepository;
    private final MemberRepository memberRepository;
    private final List<ProductDb> productDb;
    private final FeatureRepository featureRepository;
    private final PQuarterRepository pQuarterRepository;
    private final SubtaskRepository subtaskRepository;
    private final KquarterRepository kquarterRepository;

    private final ProductController productController;
//    private final FeatureDb featureDb;
//    private final SubtaskDb subtaskDb;

    @Autowired
    public ProductOwnerService(
            PMORepository pmoRepository,
            ProductOwnerRepository productownerRepository,
            ProductRepository productRepository,
            MemberRepository memberRepository,
            FeatureRepository featureRepository,
            PQuarterRepository pQuarterRepository,
            SubtaskRepository subtaskRepository,
            KquarterRepository kquarterRepository,
            List<ProductDb> productDb,
            ProductController productController
    ){
        this.pmoRepository = pmoRepository;
        this.productownerRepository = productownerRepository;
        this.productRepository = productRepository;
        this.memberRepository = memberRepository;
        this.featureRepository = featureRepository;
        this.pQuarterRepository = pQuarterRepository;
        this.subtaskRepository = subtaskRepository;
        this.kquarterRepository = kquarterRepository;
        this.productDb = productDb;
        this.productController = productController;
    }

    public static String[] PRODUCTHEADERS= {
            "idblueprint",
            "name",
            "mico",
            "kpi_product_score"
    };

    public static String[] MEMBERHEADERS = {
            "name",
            "udomain",
            "division",
            "email",
            "biro",
            "eselon_tier",
    };

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

    public static String PRODUCT_SHEET_NAME = "Product_Data";

    public static String MEMBER_SHEET_NAME = "Member_Data";

    public static String MEMBERKPI_SHEET_NAME = "Member_KPI_Data";

    @Transactional
    public void setKpiProductScore(long id,  double score){
        long productId = productownerRepository.getReferenceById(id).getProduct().getId();

        Product product = productRepository.getReferenceById(productId);
        product.setKpi_product_score(score);
        productRepository.save(product);
    }

    public Feature findFeatureByCode(Product product, String code){
        for(Feature feature: product.getFeatures()){
            if(feature.getCode().equals(code)){
                return feature;
            }
        }
        return null;
    }

    public Subtask findSubtaskByCode(Feature feature, String code){
        for(Subtask subtask: feature.getSubtasks()){
            if(subtask.getCode().equals(code)){
                return subtask;
            }
        }
        return null;
    }

    @Transactional
    public void updateProductDB(ProductDb productDb){
        Product product = productRepository.findByIdblueprint(productDb.getId_blueprint());

        // Pquarter
        List<PQuarter> pquarters = product.getPquarters();
        PQuarter pQuarter;

        pQuarter = pquarters.get(0);
        pQuarter.setDone(productDb.getDone1());
        pQuarter.setTarget(productDb.getTarget1());
        pQuarterRepository.save(pQuarter);

        pQuarter = pquarters.get(1);
        pQuarter.setDone(productDb.getDone2());
        pQuarter.setTarget(productDb.getTarget2());
        pQuarterRepository.save(pQuarter);

        pQuarter = pquarters.get(2);
        pQuarter.setDone(productDb.getDone3());
        pQuarter.setTarget(productDb.getTarget3());
        pQuarterRepository.save(pQuarter);

        pQuarter = pquarters.get(3);
        pQuarter.setDone(productDb.getDone4());
        pQuarter.setTarget(productDb.getTarget4());
        pQuarterRepository.save(pQuarter);


        // Feature + Subtask

        for(FeatureDb featureDB: productDb.getFeatures()){
            if(findFeatureByCode(product, featureDB.getCode()) != null){
                Feature feature = findFeatureByCode(product, featureDB.getCode());
                feature.setName(featureDB.getName());
                feature.setStatus(featureDB.getStatus());
                feature.setStrategic_topic(featureDB.getStrategic_topic());
                feature.setStart_date(featureDB.getStart_date());
                feature.setEnd_date(featureDB.getEnd_date());

                featureRepository.save(feature);

                for(SubtaskDb subtaskDB: featureDB.getSubtasks()){
                    if(findSubtaskByCode(feature, subtaskDB.getCode()) != null){
                        Subtask subtask = findSubtaskByCode(feature, subtaskDB.getCode());
                        subtask.setName(subtaskDB.getName());
                        subtask.setStatus(subtaskDB.getStatus());
                        subtask.setStart_date(subtaskDB.getStart_date());
                        subtask.setEnd_date(subtaskDB.getEnd_date());
                        subtask.setUdomain(subtaskDB.getUdomain());
                        subtaskRepository.save(subtask);
                    } else{
                        Subtask subtask = new Subtask(
                                subtaskDB.getCode(),
                                subtaskDB.getName(),
                                subtaskDB.getStatus(),
                                subtaskDB.getStart_date(),
                                subtaskDB.getEnd_date(),
                                subtaskDB.getUdomain()
                        );
                        feature.getSubtasks().add(subtask);
                        featureRepository.save(feature);
                    }
                }
            }else{
                List<Subtask> subtasks = new ArrayList<>();
                for(SubtaskDb subtaskDB: featureDB.getSubtasks()){
                    Subtask subtask = new Subtask(
                            subtaskDB.getCode(),
                            subtaskDB.getName(),
                            subtaskDB.getStatus(),
                            subtaskDB.getStart_date(),
                            subtaskDB.getEnd_date(),
                            subtaskDB.getUdomain()
                    );
                    subtasks.add(subtask);
                }
                Feature feature = new Feature();
                feature.setCode(featureDB.getCode());
                feature.setName(featureDB.getName());
                feature.setStatus(featureDB.getStatus());
                feature.setStrategic_topic(featureDB.getStrategic_topic());
                feature.setStart_date(featureDB.getStart_date());
                feature.setEnd_date(featureDB.getEnd_date());
                feature.setSubtasks(subtasks);

                product.getFeatures().add(feature);
                productRepository.save(product);
            }
        }
    }

    private String getQuarter(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        int quarter = Math.min(((month / 3) + 1), 4); // Memastikan nilai maksimal adalah 4
        return String.format("Q%d", quarter);
    }

    @Transactional
    public void updateMemberDB(long id){
        ProductOwner productOwner = productownerRepository.getReferenceById(id);

        Product product = productOwner.getProduct();
        List<Feature> features = product.getFeatures();

        for(Feature feature: features){ // loop feature to get each subtask
            for(Subtask subtask: feature.getSubtasks()){ // bind every subtask to it's member
                Member findMember = memberRepository.findByUdomain(subtask.getUdomain());
                if(!checkSubtaskMember(findMember, subtask.getCode())){
                    findMember.getSubtasks().add(subtask);
                    memberRepository.save(findMember);
                }
            }
        }
        // target + done
        List<Member> memberList = productOwner.getMembers();
        List<PQuarter> pQuarterList = product.getPquarters();
        pQuarterList.sort(Comparator.comparing(PQuarter::getPeriod));

        for(Member member: memberList){
            List<KQuarter> kquarters = member.getKpi().getKquarters();
            kquarters.sort(Comparator.comparing(KQuarter::getPeriod));

            for(int i=0; i<4; i++){
                kquarters.get(i).setTarget(pQuarterList.get(i).getTarget());
                kquarters.get(i).setDone(pQuarterList.get(i).getDone());
            }
//            // on schedule + late
            Map<String, Integer> onScheduleResult = new HashMap<>();
            Map<String, Integer> lateResult = new HashMap<>();
            onScheduleResult.put("Q1", 0);
            onScheduleResult.put("Q2", 0);
            onScheduleResult.put("Q3", 0);
            onScheduleResult.put("Q4", 0);

            lateResult.put("Q1", 0);
            lateResult.put("Q2", 0);
            lateResult.put("Q3", 0);
            lateResult.put("Q4", 0);

            for(Subtask subtask: member.getSubtasks()){
                String period = getQuarter(subtask.getEnd_date());
                if(subtask.getStatus().equals("In Progress") || subtask.getStatus().equals("To Do")){
                    lateResult.put(period, lateResult.get(period)+1);
                }else{
                    onScheduleResult.put(period, onScheduleResult.get(period)+1);
                }
            }

            kquarters.get(0).setOn_schedule(onScheduleResult.get("Q1"));
            kquarters.get(1).setOn_schedule(onScheduleResult.get("Q2"));
            kquarters.get(2).setOn_schedule(onScheduleResult.get("Q3"));
            kquarters.get(3).setOn_schedule(onScheduleResult.get("Q4"));

            kquarters.get(0).setLate(lateResult.get("Q1"));
            kquarters.get(1).setLate(lateResult.get("Q2"));
            kquarters.get(2).setLate(lateResult.get("Q3"));
            kquarters.get(3).setLate(lateResult.get("Q4"));

            kquarterRepository.saveAll(kquarters);
        }
    }

    public boolean checkSubtaskMember(Member findMember, String code){
        for(Subtask subtaskMember: findMember.getSubtasks()){
            if(subtaskMember.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    @Transactional
    public void synchronize(long id){
        ProductOwner productOwner = productownerRepository.getReferenceById(id);

        ProductDb productDb1 = findProductDBByid_blueprint(productOwner.getProduct().getIdblueprint());

        updateProductDB(productDb1);
        updateMemberDB(id);
    }

    @Transactional
    public void synchronizedByPmo(long pmoId){
        PMO pmo = pmoRepository.getReferenceById(pmoId);
        for(ProductOwner productOwner: pmo.getProductowners()){
            synchronize(productOwner.getId());
        }
    }

    @Transactional
    public ProductDb findProductDBByid_blueprint(String id_blueprint){
        for(ProductDb productDb: this.productDb){
            if(productDb.getId_blueprint().equals(id_blueprint)){
                return productDb;
            }
        }
        return null;
    }

    public List<Member> getAllMemberByProductOwnerId(long poId){
        ProductOwner productOwner = productownerRepository.getReferenceById(poId);
        List<Member> memberList = memberRepository.findByProductowner(productOwner);

        return memberList;
    }
    public ByteArrayInputStream downloadProduct(long poId) throws IOException {
        ProductOwner productOwner = productownerRepository.getReferenceById(poId);
        return productController.convertToExcel(productOwner.getProduct());
    }
    public ByteArrayInputStream downloadMember(long poId) throws IOException {
        List<Member> memberList = getAllMemberByProductOwnerId(poId);

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
    public ByteArrayInputStream downloadKpiExcel(long poId) throws IOException{
        List<Member> memberList = getAllMemberByProductOwnerId(poId);

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
                dataRow.createCell(0).setCellValue(member.getName());
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
