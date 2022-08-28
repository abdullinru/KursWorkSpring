package com.example.kursworkspring.repository.impl;

import com.example.kursworkspring.Question;
import com.example.kursworkspring.repository.QuestionRepository;
import com.example.kursworkspring.service.QuestionNotFoundException;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;
    private final Random random = new Random();

    public JavaQuestionRepository() {
        questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        questions.add(new Question("Java question first", "Answer on Java question first"));
        questions.add(new Question("Java question second", "Answer on Java question second"));
        questions.add(new Question("Java question third", "Answer on Java question third"));
        questions.add(new Question("Java question forth", "Answer on Java question forth"));
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

}
