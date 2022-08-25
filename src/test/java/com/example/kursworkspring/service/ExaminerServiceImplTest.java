package com.example.kursworkspring.service;

import com.example.kursworkspring.Question;
import com.example.kursworkspring.QuestionService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

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
    Set<Question> questionsExample5Java, questionsExample5Math, questionsAll;
    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @Mock
    private MathQuestionService mathQuestionServiceMock;

//    @Mock
//    private Random randomMock;
    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void init() {
        questionsExample5Java = new HashSet<>(Set.of(q1Java,q2Java,q3Java,q4Java,q5Java));
        questionsExample5Math = new HashSet<>(Set.of(q1Math,q2Math,q3Math,q4Math,q5Math));
        questionsAll = new HashSet<>(Set.of(q1Java,q2Java,q3Java,q4Java,q5Java, q1Math,q2Math,q3Math,q4Math,q5Math));


        Mockito.when(javaQuestionServiceMock.getAll()).thenReturn(questionsExample5Java);
        Mockito.when(mathQuestionServiceMock.getAll()).thenReturn(questionsExample5Math);

    }
    @Test
    public void getQuestionsTest() {


        Mockito.when(javaQuestionServiceMock.getRandom())
                .thenReturn(q1Java,q5Java,q3Java,q1Java,q5Java, q4Java,q2Java,q4Java);
        Mockito.when(mathQuestionServiceMock.getRandom())
                .thenReturn(q2Math,q3Math,q4Math, q1Math,q5Math, q1Math,q5Math,q2Math,q3Math,q4Math);
//        Mockito.when(randomMock.nextInt(anyInt()))
//                .thenReturn(0, 1, 0, 1, 0, 1, 0, 1, 0, 1);
        Assertions.assertThat(out.getQuestions(10))
                .containsExactlyInAnyOrder(q1Java, q2Java, q3Java, q4Java, q5Java, q1Math, q2Math, q3Math, q4Math, q5Math);
//                .containsExactlyInAnyOrder(q1Java, q2Math, q5Java, q3Math, q3Java);
//        Assertions.assertThat(out.getQuestions(5)).containsExactlyInAnyOrder(q1,q2,q3);
        Assertions.assertThatExceptionOfType(ExceptionIncorrectAmount.class)
                .isThrownBy(() -> out.getQuestions(-5));
        Assertions.assertThatExceptionOfType(CollectionLessAmountException.class)
                .isThrownBy(() -> out.getQuestions(100));
    }
}