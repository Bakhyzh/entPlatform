package com.bakhyzh.entplatform.question.repository;

import com.bakhyzh.entplatform.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {

    List<Question> findBySubject(String subject);
}