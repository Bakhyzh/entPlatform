package com.bakhyzh.entplatform.mistake.service;

import com.bakhyzh.entplatform.mistake.entity.Mistake;
import com.bakhyzh.entplatform.mistake.repository.MistakeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MistakeService {

    private final MistakeRepository mistakeRepository;

    public void saveMistake(Mistake mistake) {
        mistakeRepository.save(mistake);
    }

    public List<Mistake> getUserMistakes(UUID userId) {
        return mistakeRepository.findByUserId(userId);
    }
}