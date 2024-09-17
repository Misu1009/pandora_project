package com.pandora.pandora_project.service;

import com.pandora.pandora_project.repository.PMORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmoService{
    private final PMORepository pmoRepository;

    @Autowired
    public PmoService(PMORepository pmoRepository){
        this.pmoRepository = pmoRepository;
    }

//    public boolean updateProduct(String name, String mico, double score){
//
//    }
//
//    public boolean updateUser(String name, String eselon_tier){
//
//    }
//    // bikin class baru UserProduct
//    public UserProduct getUserProduct(){
//
//    }
}
