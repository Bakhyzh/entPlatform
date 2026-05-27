package com.bakhyzh.entplatform.question.service;

import com.bakhyzh.entplatform.question.entity.Question;
import com.bakhyzh.entplatform.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getBySubject(String subject) {
        return questionRepository.findBySubject(subject);
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }
}