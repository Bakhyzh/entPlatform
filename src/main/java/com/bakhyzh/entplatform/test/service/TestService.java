package com.bakhyzh.entplatform.test.service;

import com.bakhyzh.entplatform.question.entity.Question;
import com.bakhyzh.entplatform.question.repository.QuestionRepository;
import com.bakhyzh.entplatform.result.entity.Result;
import com.bakhyzh.entplatform.result.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestService {

    private final QuestionRepository questionRepository;
    private final ResultRepository resultRepository;

    public Result submitTest(UUID userId, List<String> userAnswers) {

        List<Question> questions = questionRepository.findAll();

        int correct = 0;
        int wrong = 0;

        for (int i = 0; i < questions.size(); i++) {

            Question q = questions.get(i);

            if (q.getCorrectAnswer().equals(userAnswers.get(i))) {
                correct++;
            } else {
                wrong++;
            }
        }

        Result result = new Result();
        result.setUserId(userId);
        result.setTotalScore(correct); // 1 вопрос = 1 балл
        result.setCorrectAnswers(correct);
        result.setWrongAnswers(wrong);
        result.setStartedAt(LocalDateTime.now());
        result.setFinishedAt(LocalDateTime.now());

        return resultRepository.save(result);
    }
}