package com.example.kursworkspring.service;

import com.example.kursworkspring.Question;
import com.example.kursworkspring.QuestionService;
import com.example.kursworkspring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class MathQuestionService implements QuestionService {

//    private final QuestionRepository questionRepository;
    private final Random random;

    public MathQuestionService() {
        random = new Random();
    }
    @Override
    public Question add(String question, String answer) {
        throw new ExceptionMetodNotAllowed();
    }
    @Override
    public Question add(Question question) {
        throw new ExceptionMetodNotAllowed();
    }
    @Override
    public Question remove(Question question) {
        throw new ExceptionMetodNotAllowed();
    }
    @Override
    public Collection<Question> getAll() {
        throw new ExceptionMetodNotAllowed();
    }

    // Methog for generation random question for Math
    @Override
    public Question getRandom() {
        String questionRandom = String.format("Question for math %d", random.nextInt(1000));
        String answerRandom = String.format("Answer %d", random.nextInt(1000));
        return new Question(questionRandom, answerRandom);
    }
}

