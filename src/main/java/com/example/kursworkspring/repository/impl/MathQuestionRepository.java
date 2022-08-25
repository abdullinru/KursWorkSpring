package com.example.kursworkspring.repository.impl;

import com.example.kursworkspring.Question;
import com.example.kursworkspring.repository.QuestionRepository;
import com.example.kursworkspring.service.QuestionNotFoundException;
import com.fasterxml.jackson.databind.util.ArrayBuilders;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
@Repository
public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;
    private final Random random = new Random();

    public MathQuestionRepository() {
        questions = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        questions.add(new Question("Math question first", "Answer on Math question first"));
        questions.add(new Question("Math question second", "Answer on Math question second"));
        questions.add(new Question("Math question third", "Answer on Math question third"));
        questions.add(new Question("Math question forth", "Answer on Math question forth"));
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


//    @Override
//    public Question getRandom() {
//        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
//    }
}
