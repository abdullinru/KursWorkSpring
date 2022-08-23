package com.example.kursworkspring.service;

import com.example.kursworkspring.ExaminerService;
import com.example.kursworkspring.Question;
import com.example.kursworkspring.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 0) {
            throw new ExceptionIncorrectAmount();
        }
        if (questionService.getAll().size() < amount) {
            throw new CollectionLessAmountException("В коллекции не хватает вопросов");
        }
        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount){
            questions.add(questionService.getRandom());
        }
        return questions;
    }
}
