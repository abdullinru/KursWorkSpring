package com.example.kursworkspring.service;

import com.example.kursworkspring.ExaminerService;
import com.example.kursworkspring.Question;
import com.example.kursworkspring.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;
    private final Random random;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        random = new Random();
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount < 0) {
            throw new ExceptionIncorrectAmount();
        }
        List<QuestionService> questionServicesList = new ArrayList<>(List.of(javaQuestionService, mathQuestionService));
        int sizeAllQuestions = 0;
        for (QuestionService questionService : questionServicesList) {
            sizeAllQuestions += questionService.getAll().size();
        }

        if (sizeAllQuestions < amount) {
            throw new CollectionLessAmountException("В коллекции не хватает вопросов");
        }
        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount){
            int indexRand = random.nextInt(questionServicesList.size()-1);
            questions.add(questionServicesList.get(indexRand).getRandom());
        }
        return questions;
    }
}
