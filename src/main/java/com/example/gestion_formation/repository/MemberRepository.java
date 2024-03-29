package com.example.gestion_formation.repository;

import com.example.gestion_formation.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    List<Member> findByTrainingId(Long trainingId);
}
