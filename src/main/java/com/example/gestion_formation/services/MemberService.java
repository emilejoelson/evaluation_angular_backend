package com.example.gestion_formation.services;

import com.example.gestion_formation.entities.Member;
import com.example.gestion_formation.entities.Training;

import java.util.List;

public interface MemberService {
    Member addMember(Member member);

    Member getMemberById(Long id);

    List<Member> getAllMembers();

    void updateMember(Long id, Member member);

    void deleteMember(Long id);
    Member addMemberWithTrainingId(Member member, Long trainingId);
    List<Member> getAllMembersByTrainingId(Long trainingId);
}
