package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.PQuarter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PQuarterRepository extends JpaRepository<PQuarter, Long> {
}
