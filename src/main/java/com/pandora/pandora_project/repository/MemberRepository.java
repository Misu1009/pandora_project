package com.pandora.pandora_project.repository;

import com.pandora.pandora_project.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    Member findByUdomain(String udomain);
}
