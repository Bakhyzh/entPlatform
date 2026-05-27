package com.bakhyzh.entplatform.result.controller;

import com.bakhyzh.entplatform.result.entity.Result;
import com.bakhyzh.entplatform.result.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    // 📌 сохранить результат теста
    @PostMapping
    public Result saveResult(
            @RequestParam UUID userId,
            @RequestParam UUID testId,
            @RequestParam int correctAnswers,
            @RequestParam int wrongAnswers
    ) {
        return resultService.saveResult(userId, testId, correctAnswers, wrongAnswers);
    }

    // 📊 история результатов пользователя
    @GetMapping("/{userId}")
    public List<Result> getUserResults(@PathVariable UUID userId) {
        return resultService.getUserResults(userId);
    }

    // 🏆 лучший результат
    @GetMapping("/best/{userId}")
    public Result getBestResult(@PathVariable UUID userId) {
        return resultService.getBestResult(userId);
    }
}