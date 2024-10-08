package com.pandora.pandora_project.service;

import com.pandora.pandora_project.dto.UserProductD;
import com.pandora.pandora_project.model.Member;
import com.pandora.pandora_project.model.PMO;
import com.pandora.pandora_project.model.Product;
import com.pandora.pandora_project.model.ProductOwner;
import com.pandora.pandora_project.repository.MemberRepository;
import com.pandora.pandora_project.repository.PMORepository;
import com.pandora.pandora_project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PmoService{
    private final PMORepository pmoRepository;
    private final MemberRepository memberRepository;
    private final ProductRepository productRepository;

    @Autowired
    public PmoService(PMORepository pmoRepository, MemberRepository memberRepository, ProductRepository productRepository){
        this.pmoRepository = pmoRepository;
        this.memberRepository = memberRepository;
        this.productRepository = productRepository;
    }

    public void updateProduct(long id, String name, String mico, double score){
        Product product = productRepository.getReferenceById(id);

        product.setName(name);
        product.setMico(mico);
        product.setKpi_product_score(score);

        productRepository.save(product);
    }

    public void updateUser(long id, String name, String division, String biro, String eselon_tier){
        Member member = memberRepository.getReferenceById(id);

        member.setName(name);
        member.setDivision(division);
        member.setBiro(biro);
        member.setEselon_tier(eselon_tier);

        memberRepository.save(member);
    }

    public List<UserProductD> getUserProduct(long id){
        PMO pmo = pmoRepository.getReferenceById(id);
        List<ProductOwner> productowner = pmo.getProductowners();

        List<Member> members;
        Product product;
        UserProductD userproduct;
        List<UserProductD> listUserProduct = new ArrayList<>();

        for(ProductOwner po: productowner){
            members = po.getMembers();
            product = po.getProduct();

            for(Member user: members){
                userproduct = new UserProductD(user.getName(), user.getUdomain(), product.getId_blueprint(), product.getName());
                listUserProduct.add(userproduct);
            }
        }

        return listUserProduct;
    }
}
