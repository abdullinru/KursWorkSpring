package com.example.kursworkspring.repository.impl;

import com.example.kursworkspring.Question;
import com.example.kursworkspring.service.QuestionNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.example.kursworkspring.service.Constanty.QUESTION_1;
import static com.example.kursworkspring.service.Constanty.QUESTION_2;
import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {

    MathQuestionRepository out = new MathQuestionRepository();

    @Test
    public void addRemoveGetAllTest() {
        Question actual = out.add(QUESTION_1);
        Assertions.assertThat(out.getAll()).contains(QUESTION_1);
        Assertions.assertThat(actual).isEqualTo(QUESTION_1);

        actual = out.remove(QUESTION_1);
        Assertions.assertThat(out.getAll()).isEmpty();
        Assertions.assertThat(actual).isEqualTo(QUESTION_1);
        Assertions.assertThatExceptionOfType(QuestionNotFoundException.class).isThrownBy(() -> out.remove(QUESTION_1));

        out.add(QUESTION_1);
        out.add(QUESTION_2);
        Assertions.assertThat(out.getAll()).containsExactlyInAnyOrder(QUESTION_1, QUESTION_2);
    }
}