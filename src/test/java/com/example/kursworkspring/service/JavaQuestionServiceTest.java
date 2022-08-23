package com.example.kursworkspring.service;

import com.example.kursworkspring.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static com.example.kursworkspring.service.Constanty.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService out = new JavaQuestionService();
    Set<Question> questionExampl = new HashSet<>(Set.of(QUESTION_1, QUESTION_2));

    @Test
    public void addPositiveTest1() {
        Question expected = QUESTION_1;
        assertEquals(expected, out.add(QUESTION_1));
        assertThat(out.getAll()).contains(expected);
    }
    @Test
    public void addPositiveTest2() {
        Question expected = QUESTION_1;
        assertEquals(expected, out.add(QUESTION_ONE, ANSWER_ONE));
        assertThat(out.getAll()).contains(expected);
    }
    @Test
    public void removePositiveTest1() {
        Question expected = QUESTION_1;
        out.add(QUESTION_1);
        assertEquals(expected, out.remove(QUESTION_1));
        assertThat(out.getAll()).isEmpty();
    }
    @Test
    public void removeNegativeTest() {
        Question expected = QUESTION_1;
        out.add(QUESTION_1);
        assertThatExceptionOfType(QuestionNotFoundException.class).isThrownBy(() -> out.remove(QUESTION_2));
    }
    @Test
    public void getAllPositiveTest1() {
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        assertThat(out.getAll()).containsExactlyInAnyOrder(QUESTION_1, QUESTION_2);
    }
    @Test
    public void getRandomPositiveTest1() {
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        out.add(QUESTION_2);
        assertTrue(out.getAll().contains(out.getRandom()));
    }

}