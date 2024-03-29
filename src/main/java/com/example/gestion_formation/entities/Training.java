package com.example.gestion_formation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="training")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;
    @JsonIgnore
    @OneToMany(mappedBy = "training", cascade = CascadeType.REMOVE)
    private Set<Member> members;

}
