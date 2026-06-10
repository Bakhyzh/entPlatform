package com.bakhyzh.entplatform.auth.controller;

import com.bakhyzh.entplatform.question.entity.Question;
import com.bakhyzh.entplatform.result.service.ResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class UniversalController {
    private ResultService resultService;
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
    @PostMapping("/create")
    public ResponseEntity<Map<String,Question>> createQuestion(@RequestBody Map<String,Question> requestBody){
        Question question = resultService.saveResult(requestBody.get("UUID"),);
    }@PostMapping("/create")
    public ResponseEntity<Map<String,Question>> createQuestion(@RequestBody Map<String,Question> requestBody){
        Question question = resultService.saveResult(requestBody.get("UUID"),);
    }

}
