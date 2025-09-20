package org.example.quizapp.controller;


import org.example.quizapp.DTO.AnswerDTO;
import lombok.AllArgsConstructor;
import org.example.quizapp.model.Question;
import org.springframework.web.bind.annotation.*;
import org.example.quizapp.service.QuestionService;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/app")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/questions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @PostMapping("/questions")
    public Question addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @PostMapping("/quiz/submit")
    public String submitQuiz(@RequestBody List<AnswerDTO> answers) {
        int score = questionService.calculateScore(answers);
        return "Your Score: " + score + " / " + answers.size();
    }
}