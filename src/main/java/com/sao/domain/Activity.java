package com.sao.domain;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aid;

    @NotEmpty
    @Column(unique = true)
    private Long uid;

    @NotEmpty
    private SimpleDateFormat created;

    @Column(length = 300, unique = true)
    private String content;

    @NotEmpty
    private Long like;    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public SimpleDateFormat getCreated() {
        return created;
    }

    public void setCreated(SimpleDateFormat created) {
        this.created = created;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }
}
