package com.example.kursworkspring.сontroller;

import com.example.kursworkspring.ExaminerService;
import com.example.kursworkspring.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExaminerService examinerService;

    // dependency Enjection
    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    // method for getting collection of questions in count of amount
    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable Integer amount) {
        return examinerService.getQuestions(amount);
    }
}

