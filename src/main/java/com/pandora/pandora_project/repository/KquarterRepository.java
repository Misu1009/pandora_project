package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.KQuarter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KquarterRepository extends JpaRepository<KQuarter, Long> {
}
