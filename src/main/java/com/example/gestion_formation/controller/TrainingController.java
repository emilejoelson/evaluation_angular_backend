package com.example.gestion_formation.controller;

import com.example.gestion_formation.entities.Member;
import com.example.gestion_formation.entities.Training;
import com.example.gestion_formation.services.TrainingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping
    public ResponseEntity<Training> createTraining(@RequestBody Training training) {
        Training createdTraining = trainingService.addTraining(training);
        return new ResponseEntity<>(createdTraining, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable Long id) {
        Training training = trainingService.getTrainingById(id);
        if (training != null) {
            return new ResponseEntity<>(training, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Training>> getAllTrainings() {
        List<Training> trainings = trainingService.getAllTrainings();
        return new ResponseEntity<>(trainings, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateTraining(@PathVariable Long id, @RequestBody Training training) {
        trainingService.updateTraining(id, training);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        trainingService.deleteTraining(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{trainingId}/members")
    public ResponseEntity<Training> addMemberToTraining(@PathVariable Long trainingId, @RequestBody Member member) {
        Training updatedTraining = trainingService.addMemberToTraining(trainingId, member);
        return new ResponseEntity<>(updatedTraining, HttpStatus.OK);
    }
}

