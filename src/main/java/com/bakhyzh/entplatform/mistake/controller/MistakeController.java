package com.bakhyzh.entplatform.mistake.controller;

import com.bakhyzh.entplatform.mistake.entity.Mistake;
import com.bakhyzh.entplatform.mistake.service.MistakeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/mistakes")
@RequiredArgsConstructor
public class MistakeController {

    private final MistakeService mistakeService;

    @GetMapping("/{userId}")
    public List<Mistake> getUserMistakes(@PathVariable UUID userId) {
        return mistakeService.getUserMistakes(userId);
    }

    @PostMapping
    public void save(@RequestBody Mistake mistake) {
        mistakeService.saveMistake(mistake);
    }
}