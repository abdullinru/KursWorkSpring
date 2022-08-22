package com.example.kursworkspring.Service;

import com.example.kursworkspring.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    Question q1 = new Question("Question1", "Answer1");
    Question q2 = new Question("Question2", "Answer2");
    Question q3 = new Question("Question3", "Answer3");
    Question q4 = new Question("Question4", "Answer4");
    Question q5 = new Question("Question5", "Answer5");
    Set<Question> questionsExample;


    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void init() {
        Set<Question> questionsExample = new HashSet<>(Set.of(q1, q2, q3, q4, q5));
        Mockito.when(javaQuestionServiceMock.getAll()).thenReturn(questionsExample);
        Mockito.when(javaQuestionServiceMock.getRandom())
                .thenReturn(questionsExample.stream().findAny().orElseThrow());

    }
    @Test
    public void getQuestionsTest() {
        Assertions.assertThat(questionsExample).containsAll(out.getQuestions(5));

    }


}