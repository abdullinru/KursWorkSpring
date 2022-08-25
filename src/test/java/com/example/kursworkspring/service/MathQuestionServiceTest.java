package com.example.kursworkspring.service;

import com.example.kursworkspring.Question;
import com.example.kursworkspring.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static com.example.kursworkspring.service.Constanty.QUESTION_1;
import static com.example.kursworkspring.service.Constanty.QUESTION_2;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepositoryMock;

    @InjectMocks
    private MathQuestionService out;

    @Test
    public void getRandomPositiveTest1() {
        Set<Question> questionExampl = new HashSet<>(Set.of(QUESTION_1, QUESTION_2));

        Mockito.when(questionRepositoryMock.getAll()).thenReturn(questionExampl);
        out.add(QUESTION_1);
        out.add(QUESTION_2);
        assertThat(questionRepositoryMock.getAll()).contains(out.getRandom());
    }

}