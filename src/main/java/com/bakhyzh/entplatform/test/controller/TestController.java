package com.bakhyzh.entplatform.test.controller;

import com.bakhyzh.entplatform.result.entity.Result;
import com.bakhyzh.entplatform.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tests")
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/submit/{userId}")
    public Result submitTest(
            @PathVariable UUID userId,
            @RequestBody List<String> answers
    ) {
        return testService.submitTest(userId, answers);
    }
}