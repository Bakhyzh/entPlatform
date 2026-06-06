package com.bakhyzh.entplatform.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class UniversalController {
    @GetMapping("/")
    public ResponseEntity<List<String>> getall(){
        List<String> lists = new ArrayList<>();
        return ResponseEntity.ok(lists);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getbyid(@PathVariable(name="id")Integer id){
        List<String> lists = new ArrayList<>();
        return ResponseEntity.ok(lists.get(id));
    }

}
