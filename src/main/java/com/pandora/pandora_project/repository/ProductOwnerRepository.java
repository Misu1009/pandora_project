package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.ProductOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOwnerRepository extends JpaRepository<ProductOwner, Long> {
    ProductOwner findbyemail(String email);

    ProductOwner findbyudomain(String udomain);
}
