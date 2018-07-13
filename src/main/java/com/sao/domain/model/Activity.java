package com.sao.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(ActivityUserId.class)
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long aid;

    @Id
    private Long uid;

    private Date created;

    @Column(length = 300)
    private String content;

    private String title;

    private Long likes;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAid() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long like) {
        this.likes = like;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
