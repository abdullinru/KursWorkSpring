package com.example.kursworkspring.Service;

import com.example.kursworkspring.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static com.example.kursworkspring.Service.Constanty.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    JavaQuestionService out = new JavaQuestionService();
    Set<Question> questionExampl = new HashSet<>(Set.of(QUESTION_1, QUESTION_2));
    @Test
    public void addNegativeTest() {
        assertThrows(QuestionOrAnswerNullException.class, ()->out.add(STRING_NULL, STRING_NULL));
//        Assertions.assertThatThrownBy(QuestionOrAnswerNullException.class, ()->out.add(STRING_NULL, STRING_NULL));
    }
    @Test
    public void addNegativetest2() {
        assertThrows(QuestionOrAnswerNullException.class, () -> out.add(QUESTION_NULL));
    }
    @Test
    public void removeNegativetest() {
        assertThrows(QuestionOrAnswerNullException.class, () -> out.remove(QUESTION_NULL));
    }
    @Test
    public void removeNegativetest2() {
        out.add(QUESTION_ONE, ANSWER_ONE);
        Question question1 = new Question(QUESTION_TWO, ANSWER_TWO);
        assertThrows(QuestionNotFoundException.class, () -> out.remove(question1));
    }
    @Test
    public void addPositiveTest1() {
        Question expected = QUESTION_1;
        assertEquals(expected, out.add(QUESTION_1));
    }
    @Test
    public void addPositiveTest2() {
        Question expected = QUESTION_1;
        assertEquals(expected, out.add(QUESTION_ONE, ANSWER_ONE));
    }
    @Test
    public void removePositiveTest1() {
        Question expected = QUESTION_1;
        out.add(QUESTION_1);
        assertEquals(expected, out.remove(QUESTION_1));
    }
    @Test
    public void getAllPositiveTest1() {
//        Question expected = QUESTION_1;
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        Set<Question> expected = questionExampl;
        Assertions.assertThat(expected).containsAll(out.getAll());
//        assertEquals(expected, out.getAll());
    }
    @Test
    public void getRandomPositiveTest1() {
//        Question expected = QUESTION_1;
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        out.add(QUESTION_2);
        assertTrue(out.getAll().contains(out.getRandom()));
    }

}