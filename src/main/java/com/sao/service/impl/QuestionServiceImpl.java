package com.sao.service.impl;

import com.sao.domain.model.Question;
import com.sao.domain.repository.QuestionRepository;
import com.sao.service.QuesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class QuestionServiceImpl implements QuesionService {

    QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository repository){
        this.questionRepository = repository;
    }

    @Override
    public Iterable<Question> getQuestion() {
        return questionRepository.findAll();
    }
}
