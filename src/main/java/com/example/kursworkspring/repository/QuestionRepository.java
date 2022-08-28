package com.example.kursworkspring.repository;

import com.example.kursworkspring.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
//    Question getRandom();
}
