package com.pandora.pandora_project.controller;

import com.pandora.pandora_project.repository.MemberRepository;
import com.pandora.pandora_project.repository.PMORepository;
import com.pandora.pandora_project.repository.ProductRepository;
import com.pandora.pandora_project.service.PmoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/pandora")
public class PMOController {
    private final PmoService pmoService;

    private final ProductController productController;
    private final UserController userController;

    @Autowired
    public PMOController(PmoService pmoService, ProductController productController, UserController userController) {
        this.pmoService = pmoService;
        this.productController = productController;
        this.userController = userController;
    }

    @PutMapping("/product/edit")
    public void updateProduct(@RequestParam long productId, @RequestParam String name,
                            @RequestParam String mico) {
        productController.updateProduct(productId, name, mico);
    }

    @PutMapping("/edit")
    public void updateUser(@RequestParam long userId, @RequestParam String role, @RequestParam String name,
                           @RequestParam String division, @RequestParam String biro,
                           @RequestParam String eselonTier) {
        userController.updateUser(userId, role, name, division, biro, eselonTier);
    }
}
