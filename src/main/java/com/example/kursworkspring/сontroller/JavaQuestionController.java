package com.example.kursworkspring.сontroller;

import com.example.kursworkspring.Question;
import com.example.kursworkspring.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/java")
public class JavaQuestionController {

    private final QuestionService questionService;

    // DA
    public JavaQuestionController(@Qualifier("javaQuestionService")QuestionService questionService) {
        this.questionService = questionService;
    }
    // Method for add question
    @GetMapping("/add")
    public Question addQuestion(@RequestParam(name = "question") String question,
                                @RequestParam(name = "answer") String answer) {
        return questionService.add(question, answer);
    }

    //// Method for remove question
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(name = "question") String question,
                                   @RequestParam(name = "answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }
    // Method for getting all questions
    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}

