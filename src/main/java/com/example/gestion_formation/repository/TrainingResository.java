package com.example.gestion_formation.repository;

import com.example.gestion_formation.entities.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingResository extends JpaRepository<Training,Long> {
}
