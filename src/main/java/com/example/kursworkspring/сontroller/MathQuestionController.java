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
@RequestMapping("/math")
public class MathQuestionController {

    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Question addQuestion(@RequestParam(name = "question") String question,
                                @RequestParam(name = "answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam(name = "question") String question,
                                   @RequestParam(name = "answer") String answer) {
        return questionService.remove(new Question(question, answer));
    }
    @GetMapping
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}

