package com.bakhyzh.entplatform.result.service;

import com.bakhyzh.entplatform.result.entity.Result;
import com.bakhyzh.entplatform.result.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;

    // сохранить результат теста
    public Result saveResult(UUID userId, UUID testId, int correctAnswers, int wrongAnswers) {

        Result result = new Result();

        result.setUserId(userId);
        result.setTestId(testId);

        result.setCorrectAnswers(correctAnswers);
        result.setWrongAnswers(wrongAnswers);

        // ЕНТ логика: 1 правильный = 1 балл
        result.setTotalScore(correctAnswers);

        result.setStartedAt(LocalDateTime.now());
        result.setFinishedAt(LocalDateTime.now());

        return resultRepository.save(result);
    }

    // история пользователя
    public List<Result> getUserResults(UUID userId) {
        return resultRepository.findByUserId(userId);
    }

    // лучший результат
    public Result getBestResult(UUID userId) {
        return resultRepository.findByUserId(userId)
                .stream()
                .max((r1, r2) -> Integer.compare(r1.getTotalScore(), r2.getTotalScore()))
                .orElse(null);
    }
}