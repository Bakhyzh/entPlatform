package com.bakhyzh.entplatform.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class UniversalController {
    @GetMapping("/")
    public ResponseEntity<List<String>> getall(){
        return null;
    }

}
