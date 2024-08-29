package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.PMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PMORepository extends JpaRepository<PMO, Long> {
}
