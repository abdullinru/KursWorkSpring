package com.example.kursworkspring;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
