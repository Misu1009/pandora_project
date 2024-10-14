package com.pandora.pandora_project.controller;

import com.pandora.pandora_project.dto.*;
import com.pandora.pandora_project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pandora/")
public class UserController {

    private final UserService userService;
    private final ProductOwnerService productOwnerService;
    private final MemberService memberService;
    private final PmoService pmoService;

    @Autowired
    public UserController(UserService userService, ProductOwnerService productOwnerService, MemberService memberService, PmoService pmoService){
        this.userService = userService;
        this.productOwnerService = productOwnerService;
        this.memberService = memberService;
        this.pmoService = pmoService;
    }

    @GetMapping("/login")
    public LoginDTO getUserLogin(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password);
    }

    @PostMapping("/member/register")
    public void createMember(@RequestParam String name, @RequestParam String email,
                                             @RequestParam String password, @RequestParam long productOwnerId) {
        try{
            userService.register(name, email, password, productOwnerId);
        } catch (Exception e) {
//            throw new RuntimeException(e);
        }

    }

    @GetMapping("/productowner/getAll")
    public ListProductOwnerDTO getAllProductOwner() {
        return userService.getAllProductOwner();
    }

    @PutMapping("/productowner/synchronize")
    public void synchronize(@RequestParam long productOwnerId) {
        productOwnerService.synchronize(productOwnerId);
    }

    @GetMapping("/productowner/getproducts")
    public LaporanProductDTO getProduct(@RequestParam long productOwnerId) {
        return userService.getProductByProductOwner(productOwnerId);
    }

    @PostMapping("/productowner/setkpiproductscore")
    public void setKPIProductScore(@RequestParam long productOwnerId, @RequestParam double score) {
        productOwnerService.setKpiProductScore(productOwnerId, score);
    }

    @GetMapping("/productowner/downloadproduct")
    public void downloadProductExcel(@RequestParam long productOwnerId) {
        productOwnerService.downloadProduct(productOwnerId);
    }

    @GetMapping("/productowner/getmembers")
    public LaporanMemberDTO getAllMember(@RequestParam long productOwnerId) {
        return userService.getAllMemberByProductOwner(productOwnerId);
    }

    @GetMapping("/productowner/downloadmember")
    public void downloadMemberExcel(@RequestParam long productOwnerId) {
        productOwnerService.downloadMember(productOwnerId);
    }

    @GetMapping("/productowner/getmemberkpis")
    public LaporanMemberKPIDTO getMemberKPIs(@RequestParam long productOwnerId) {
        return userService.getAllMemberKPIByProductOwner(productOwnerId);
    }

    @GetMapping("/productowner/downloadmemberkpi")
    public void downloadMemberKPIExcel(@RequestParam long productOwnerId) {
        productOwnerService.downloadKpiExcel(productOwnerId);
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

    @PutMapping("/ratemember")
    public void rateMember(@RequestParam long memberId, @RequestParam String period, @RequestParam double custFocus,
                                           @RequestParam double integrity, @RequestParam double teamwork,
                                           @RequestParam double cpoe) {
        memberService.rate(memberId, period, custFocus, integrity, teamwork, cpoe);
    }

    @GetMapping("/getothermember")
    public MemberMainPageDTO getOtherMember(@RequestParam long memberId) {
        return userService.getOtherMember(memberId);
    }
}