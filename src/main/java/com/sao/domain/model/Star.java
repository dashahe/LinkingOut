package com.sao.domain.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Star {


    @EmbeddedId
    public StarKey key;

}
