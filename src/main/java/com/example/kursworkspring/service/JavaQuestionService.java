package com.example.kursworkspring.service;

import com.example.kursworkspring.Question;
import com.example.kursworkspring.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;
    private final Random random = new Random();

    public JavaQuestionService() {
        questions = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }
    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();
    }
    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
    @Override
    public Question getRandom() {
        return questions.stream()
                .skip(random.nextInt(questions.size() - 1))
                .findFirst()
                .orElseThrow(BadRequestQuestionException::new);
    }
}

