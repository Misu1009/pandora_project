package com.pandora.pandora_project.controller;

import com.pandora.pandora_project.dto.*;
import com.pandora.pandora_project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/pandora")
public class UserController {

    private final UserService userService;
    private final ProductOwnerService productOwnerService;

    private final PmoService pmoService;

    @Autowired
    public UserController(UserService userService, ProductOwnerService productOwnerService, PmoService pmoService){
        this.userService = userService;
        this.productOwnerService = productOwnerService;

        this.pmoService = pmoService;
    }

    @GetMapping("/login")
    public LoginDTO login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    @PostMapping("/member/register")
    public void register(@RequestParam String name, @RequestParam String email,
                                             @RequestParam String password, @RequestParam long productOwnerId) {
        userService.register(name, email, password, productOwnerId);
    }

    @GetMapping("/productowner/getAll")
    public ListProductOwnerDTO getAllProductOwner() {
        return userService.getAllProductOwner();
    }

    @PutMapping("/productowner/synchronize")
    public void synchronize(@RequestParam long productOwnerId) {
        productOwnerService.synchronize(productOwnerId);
    }

    @PutMapping("/pmo/synchronize")
    public void synchronizedByPmo(@RequestParam long pmoId) {
        productOwnerService.synchronizedByPmo(pmoId);
    }

    @GetMapping("/productowner/getproducts")
    public LaporanProductDTO getProduct(@RequestParam long productOwnerId) {
        return userService.getProductByProductOwner(productOwnerId);
    }

    @GetMapping("/productowner/getmembers")
    public LaporanMemberDTO getAllMember(@RequestParam long productOwnerId) {
        return userService.getAllMemberByProductOwner(productOwnerId);
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

    @GetMapping("/productowner/getmemberkpis")
    public LaporanMemberKPIDTO getMemberKPIs(@RequestParam long productOwnerId) {
        return userService.getAllMemberKPIByProductOwner(productOwnerId);
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

    @GetMapping("/pmo/getallproductowner")
    public ListProductOwnerDTO getAllProductOwner(@RequestParam long pmoId) {
        return userService.getAllProductOwnerByPMO(pmoId);
    }

    @GetMapping("/pmo/getalluser")
    public MasterUserDTO getAllUser(@RequestParam long pmoId) {
        return userService.getAllUserByPMO(pmoId);
    }

    @PutMapping("/edit")
    public void editUser(@RequestParam long userId, @RequestParam String name,
                                         @RequestParam String division, @RequestParam String biro,
                                         @RequestParam String eselonTier) {
        pmoService.updateUser(userId, name, division, biro, eselonTier);
    }

    @GetMapping("/pmo/getallproduct")
    public MasterProductDTO getAllProduct(@RequestParam long pmoId) {
        return userService.getAllProductByPMO(pmoId);
    }

    @GetMapping("/getuserproduct")
    public MasterUserProductDTO getAllUserProduct(@RequestParam long pmoId) {
        return userService.getAllUserJoinProduct(pmoId);
    }



    @GetMapping("/getothermember")
    public MemberMainPageDTO getOtherMember(@RequestParam long memberId) {
        return userService.getOtherMember(memberId);
    }
}