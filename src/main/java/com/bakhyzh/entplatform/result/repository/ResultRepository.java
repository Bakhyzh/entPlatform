package com.bakhyzh.entplatform.result.repository;

import com.bakhyzh.entplatform.result.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ResultRepository extends JpaRepository<Result, UUID> {

    List<Result> findByUserId(UUID userId);
}