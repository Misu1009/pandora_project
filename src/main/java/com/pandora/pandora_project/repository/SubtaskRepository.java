package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtaskRepository extends JpaRepository<Subtask, Long> {
}
