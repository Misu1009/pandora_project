package com.pandora.pandora_project.controller;

import com.pandora.pandora_project.dto.*;
import com.pandora.pandora_project.model.Member;
import com.pandora.pandora_project.service.*;
import jakarta.transaction.Transactional;
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

    @GetMapping("/productowner/getmemberkpis")
    public LaporanMemberKPIDTO getMemberKPIs(@RequestParam long productOwnerId) {
        return userService.getAllMemberKPIByProductOwner(productOwnerId);
    }

    @GetMapping("/pmo/getallproductowner")
    public ListProductOwnerDTO getAllProductOwner(@RequestParam long pmoId) {
        return userService.getAllProductOwnerByPMO(pmoId);
    }

    @GetMapping("/pmo/getalluser")
    public MasterUserDTO getAllUser(@RequestParam long pmoId) {
        return userService.getAllUserByPMO(pmoId);
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
    public MemberMainPageDTO getOtherMember(@RequestParam long memberId, @RequestParam String period) {
        return userService.getOtherMember(memberId, period);
    }

    public void updateUser(long userId, String name, String division, String biro, String eselon_tier){
        userService.updateUser(userId, name, division, biro, eselon_tier);
    }
}