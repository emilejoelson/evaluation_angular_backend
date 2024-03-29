package com.example.gestion_formation.services.implementation;

import com.example.gestion_formation.entities.Member;
import com.example.gestion_formation.entities.Training;
import com.example.gestion_formation.repository.TrainingResository;
import com.example.gestion_formation.services.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {
    private final TrainingResository trainingRepository;

    @Override
    public Training addTraining(Training training) {
        return trainingRepository.save(training);
    }

    @Override
    public Training getTrainingById(Long id) {
        return trainingRepository.findById(id).orElse(null);
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public void updateTraining(Long id, Training training) {
        Training existingTraining = trainingRepository.findById(id).orElse(null);
        if (existingTraining != null) {
            training.setId(existingTraining.getId());
            trainingRepository.save(training);
        }
    }

    @Override
    public Training addMemberToTraining(Long trainingId, Member member) {
        Optional<Training> optionalTraining = trainingRepository.findById(trainingId);
        if (optionalTraining.isPresent()) {
            Training training = optionalTraining.get();
            training.getMembers().add(member);
            member.setTraining(training);
            return trainingRepository.save(training);
        } else {
            throw new IllegalArgumentException("Training not found with ID: " + trainingId);
        }
    }

    @Override
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }
}