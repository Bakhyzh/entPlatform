package com.bakhyzh.entplatform.result.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;

    private UUID testId;

    private int totalScore;

    private int correctAnswers;

    private int wrongAnswers;

    private LocalDateTime startedAt;

    private LocalDateTime finishedAt;
}