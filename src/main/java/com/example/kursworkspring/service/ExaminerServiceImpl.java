package com.example.kursworkspring.service;

import com.example.kursworkspring.ExaminerService;
import com.example.kursworkspring.Question;
import com.example.kursworkspring.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final JavaQuestionService javaQuestionService;
    private final MathQuestionService mathQuestionService;
    private final Random random;

    // DA
    public ExaminerServiceImpl( JavaQuestionService javaQuestionService,
                               MathQuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
        random = new Random();
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        // If argument is uncorrect
        if (amount < 0) {
            throw new ExceptionIncorrectAmount();
        }
        // Create new List of questions for math and Java
        List<QuestionService> questionServicesList = new ArrayList<>(List.of(javaQuestionService, mathQuestionService));
        Set<Question> questions = new HashSet<>();

        while (questions.size() < amount){

            int indexRand = random.nextInt(questionServicesList.size());// 0 or 1
            questions.add(questionServicesList.get(indexRand).getRandom()); // save to questions random question
        }
        return questions;
    }
}
