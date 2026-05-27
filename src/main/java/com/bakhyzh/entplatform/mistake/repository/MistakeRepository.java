package com.bakhyzh.entplatform.mistake.repository;

import com.bakhyzh.entplatform.mistake.entity.Mistake;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MistakeRepository extends JpaRepository<Mistake, UUID> {

    List<Mistake> findByUserId(UUID userId);
}