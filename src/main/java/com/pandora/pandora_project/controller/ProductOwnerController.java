package com.pandora.pandora_project.controller;

import com.pandora.pandora_project.service.ProductOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/pandora")
public class ProductOwnerController {
    private final ProductOwnerService productOwnerService;

    @Autowired
    public ProductOwnerController(ProductOwnerService productOwnerService) {
        this.productOwnerService = productOwnerService;
    }
    @PostMapping("/productowner/setkpiproductscore")
    public boolean setKPIProductScore(@RequestParam long productOwnerId, @RequestParam double score) {
        return productOwnerService.setKpiProductScore(productOwnerId, score);
    }
    @RequestMapping("/productowner/downloadproduct")
    public ResponseEntity<Resource> downloadProductExcel(@RequestParam long productOwnerId) throws IOException {

        String filename = "product.xlsx";

        ByteArrayInputStream actualData = productOwnerService.downloadProduct(productOwnerId);
        InputStreamResource file = new InputStreamResource(actualData);

        ResponseEntity<Resource> body = ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);

        return body;
    }
    @RequestMapping("/productowner/downloadmember")
    public ResponseEntity<Resource> downloadMemberExcel(@RequestParam long productOwnerId) throws IOException {

        String filename = "member.xlsx";

        ByteArrayInputStream actualData = productOwnerService.downloadMember(productOwnerId);
        InputStreamResource file = new InputStreamResource(actualData);

        ResponseEntity<Resource> body = ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);

        return body;
    }
    @RequestMapping("/productowner/downloadmemberkpi")
    public ResponseEntity<Resource> downloadMemberKPIExcel(@RequestParam long productOwnerId) throws IOException {

        String filename = "member_kpi.xlsx";

        ByteArrayInputStream actualData = productOwnerService.downloadKpiExcel(productOwnerId);
        InputStreamResource file = new InputStreamResource(actualData);

        ResponseEntity<Resource> body = ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);

        return body;
    }
    @PutMapping("/productowner/synchronize")
    public void synchronize(@RequestParam long productOwnerId) {
        productOwnerService.synchronize(productOwnerId);
    }
}
