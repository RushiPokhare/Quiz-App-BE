package org.example.quizapp.service;

import org.example.quizapp.DTO.AnswerDTO;
import org.example.quizapp.dao.QuestionDao;
import lombok.AllArgsConstructor;
import org.example.quizapp.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class QuestionService {
    private final QuestionDao questionDao;

    public List<Question> getAllQuestions(){
       return questionDao.findAll();
    }

    public Question addQuestion(Question question){
        return questionDao.save(question);
    }

    public int calculateScore(List<AnswerDTO> answers){
        int score = 0;
        for (AnswerDTO ans : answers) {
            Question q = questionDao.findById(ans.getQuestionId()).orElse(null);
            if (q != null && q.getCorrectAnswer().equalsIgnoreCase(ans.getGivenAnswer())) {
                score++;
            }
        }
        return score;
    }
}
