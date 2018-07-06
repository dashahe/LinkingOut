package com.sao.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aid;

    @NotEmpty
    private Long uid;

    @NotEmpty
    private Timestamp created;

    @Column(length = 300)
    private String content;

    @NotEmpty
    private Long likes;

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

//    public SimpleDateFormat getCreated() {
//        return created;
//    }
//
//    public void setCreated(SimpleDateFormat created) {
//        this.created = created;
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getLike() {
        return likes;
    }

    public void setLike(Long likes) {
        this.likes = likes;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}
