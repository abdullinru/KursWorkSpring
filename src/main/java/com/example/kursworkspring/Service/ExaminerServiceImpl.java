package com.example.kursworkspring.Service;

import com.example.kursworkspring.ExaminerService;
import com.example.kursworkspring.Question;
import com.example.kursworkspring.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new CollectionLessAmountException("В коллекции не хватает вопросов");
        }
        Set<Question> questions = new HashSet<>();
        if (amount == questionService.getAll().size()) {
            return questionService.getAll();
        }
        while (questions.size() != amount){
            questions.add(questionService.getRandom());
        }
        return questions;
    }
}
