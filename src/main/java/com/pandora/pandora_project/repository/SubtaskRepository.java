package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.Subtask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {
}
