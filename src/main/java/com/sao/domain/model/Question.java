package com.sao.domain.model;


import org.jetbrains.annotations.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long qid;

    @NotEmpty
    public  String questionName;


    @NotNull
    public String questionDetail;


    public String getQuestionName(){
        return questionName;
    }

    public String getQuestionDetail(){
        return questionDetail;
    }
}
