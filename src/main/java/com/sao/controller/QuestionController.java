package com.sao.controller;


import com.sao.domain.model.Question;
import com.sao.service.QuesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/question")
public class QuestionController {

    QuesionService quesionService;


    @Autowired
    public QuestionController(QuesionService quesionService){
        this.quesionService=quesionService;
    }

    @GetMapping
    public String getQuestion(Model model){
        Iterable<Question> iterable = quesionService.getQuestion();
        model.addAttribute("questionList",iterable);
        return "home";
    }
}
