package com.example.kursworkspring.service;

import com.example.kursworkspring.Question;
import org.junit.jupiter.api.Test;
import static com.example.kursworkspring.service.Constanty.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


class MathQuestionServiceTest {
    MathQuestionService out = new MathQuestionService();
    @Test
    public void getRandomPositiveTest1() {
        assertThat(out.getRandom()).isNotNull();
        assertThat(out.getRandom()).isOfAnyClassIn(Question.class);
    }

    @Test
    public void addRemoveGetNegativeTest() {
        assertThatExceptionOfType(ExceptionMetodNotAllowed.class).isThrownBy(() -> out.add(QUESTION_1));
        assertThatExceptionOfType(ExceptionMetodNotAllowed.class).isThrownBy(() -> out.add(QUESTION_ONE,ANSWER_ONE));
        assertThatExceptionOfType(ExceptionMetodNotAllowed.class).isThrownBy(() -> out.remove(QUESTION_1));
        assertThatExceptionOfType(ExceptionMetodNotAllowed.class).isThrownBy(() -> out.getAll());
    }
}