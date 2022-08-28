package com.example.kursworkspring.сontroller;

import com.example.kursworkspring.ExaminerService;
import com.example.kursworkspring.Question;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/get")
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable Integer amount) {

        return examinerService.getQuestions(amount);
    }
}

