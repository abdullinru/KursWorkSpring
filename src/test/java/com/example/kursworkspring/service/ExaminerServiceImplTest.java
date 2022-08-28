package com.example.kursworkspring.service;

import com.example.kursworkspring.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    Question q1Java = new Question("Java1", "Answer1");
    Question q2Java = new Question("Java2", "Answer2");
    Question q3Java = new Question("Java3", "Answer3");
    Question q4Java = new Question("Java4", "Answer4");
    Question q5Java = new Question("Java5", "Answer5");

    Question q1Math = new Question("Math1", "Answer1");
    Question q2Math = new Question("Math2", "Answer2");
    Question q3Math = new Question("Math3", "Answer3");
    Question q4Math = new Question("Math4", "Answer4");
    Question q5Math = new Question("Math5", "Answer5");

    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @Mock
    private MathQuestionService mathQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl out;
    @Test
    public void getQuestionsTest() {
        when(javaQuestionServiceMock.getRandom())
                .thenReturn(q1Java,q5Java,q3Java,q1Java,q5Java, q4Java,q2Java,q4Java);
        when(mathQuestionServiceMock.getRandom())
                .thenReturn(q2Math,q3Math,q4Math, q1Math,q5Math, q1Math,q5Math,q2Math,q3Math,q4Math);
        assertThat(out.getQuestions(10))
                .containsExactlyInAnyOrder(q1Java, q2Java, q3Java, q4Java, q5Java, q1Math, q2Math, q3Math, q4Math, q5Math);
        assertThatExceptionOfType(ExceptionIncorrectAmount.class)
                .isThrownBy(() -> out.getQuestions(-5));

    }
}