package com.example.gestion_formation.services;

import com.example.gestion_formation.entities.Member;
import com.example.gestion_formation.entities.Training;

import java.util.List;

public interface TrainingService {
    Training addTraining(Training training);

    Training getTrainingById(Long id);

    List<Training> getAllTrainings();

    void updateTraining(Long id, Training training);
    Training addMemberToTraining(Long trainingId, Member member);
    void deleteTraining(Long id);
}

