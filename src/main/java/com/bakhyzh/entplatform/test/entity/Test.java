package com.bakhyzh.entplatform.test.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;
import com.bakhyzh.entplatform.question.entity.Question;

@Entity
@Table(name = "tests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private int durationMinutes;

    @ManyToMany
    @JoinTable(
            name = "test_questions",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;
}