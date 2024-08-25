package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
