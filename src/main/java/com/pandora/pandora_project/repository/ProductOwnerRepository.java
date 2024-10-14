package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.ProductOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOwnerRepository extends JpaRepository<ProductOwner, Long> {
    ProductOwner findByEmail(String email);

    ProductOwner findByUdomain(String udomain);
}
