package com.example.gestion_formation.services.implementation;

import com.example.gestion_formation.entities.Member;
import com.example.gestion_formation.entities.Training;
import com.example.gestion_formation.repository.MemberRepository;
import com.example.gestion_formation.repository.TrainingResository;
import com.example.gestion_formation.services.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl  implements MemberService {
    private final MemberRepository memberRepository;
    private  final TrainingResository trainingResository;
    @Override
    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public void updateMember(Long id, Member member) {
        Member existingMember = memberRepository.findById(id).orElse(null);
        if (existingMember != null) {
            member.setId(existingMember.getId());
            memberRepository.save(member);
        }
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public Member addMemberWithTrainingId(Member member, Long trainingId) {
        // Retrieve the training by ID
        Training training = trainingResository.findById(trainingId)
                .orElseThrow(() -> new IllegalArgumentException("Training not found with ID: " + trainingId));

        // Set the training for the member
        member.setTraining(training);
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getAllMembersByTrainingId(Long trainingId) {
        return memberRepository.findByTrainingId(trainingId);
    }
}
