package com.example.kursworkspring.Service;

import com.example.kursworkspring.Question;
import com.example.kursworkspring.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;
    Random random = new Random();

    public JavaQuestionService() {
        questions = new HashSet<>();
    }

    private void validateQuestion(String question, String answer) {
        if (question == null || answer == null) {
            throw new QuestionOrAnswerNullException("Не введен вопрос или ответ!");
        }
    }
    private void validateQuestion(Question question) {
        if (question == null) {
            throw new QuestionOrAnswerNullException("Не введен вопрос или ответ!");
        }
    }
    @Override
    public Question add(String question, String answer) {
        validateQuestion(question, answer);
        Question question1 = new Question(question, answer);
        questions.add(question1);

        return question1;
    }
    @Override
    public Question add(Question question) {
        validateQuestion(question);
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        validateQuestion(question);
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        throw new QuestionNotFoundException();
    }
    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
    @Override
    public Question getRandom() {
        return questions.stream()
                .skip(random.nextInt(questions.size() - 1))
                .findFirst()
                .orElseThrow(BadRequestQuestionException::new);
    }
}

