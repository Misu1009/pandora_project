package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.KPI;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KpiRepository extends JpaRepository<KPI, Long> {
}
