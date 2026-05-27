package com.bakhyzh.entplatform.question.controller;

import com.bakhyzh.entplatform.question.entity.Question;
import com.bakhyzh.entplatform.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/{subject}")
    public List<Question> getBySubject(@PathVariable String subject) {
        return questionService.getBySubject(subject);
    }

    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.save(question);
    }
}