package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.KPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KpiRepository extends JpaRepository<KPI, Long> {
}
