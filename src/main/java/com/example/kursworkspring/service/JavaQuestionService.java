package com.example.kursworkspring.service;

import com.example.kursworkspring.Question;
import com.example.kursworkspring.QuestionService;
import com.example.kursworkspring.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final QuestionRepository questionRepository;
    private final Random random = new Random();

    // DA
    public JavaQuestionService(@Qualifier("javaQuestionRepository") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question add(String question, String answer) {

        return questionRepository.add(question, answer);
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    // method gor getting random question from collection of questions for Java
    @Override
    public Question getRandom() {
        Collection<Question> questions = questionRepository.getAll();
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}

