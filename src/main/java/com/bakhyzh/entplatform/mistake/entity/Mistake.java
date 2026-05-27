package com.bakhyzh.entplatform.mistake.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "mistakes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mistake {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;

    private UUID questionId;

    private String selectedAnswer;

    private String correctAnswer;

    private String subject;
}