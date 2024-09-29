package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.KQuarter;
import com.pandora.pandora_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findbyId_blueprint(String idBlurprint);
}
