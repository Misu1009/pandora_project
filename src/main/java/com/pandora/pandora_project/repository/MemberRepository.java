package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
