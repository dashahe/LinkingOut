package com.sao.domain.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Activity {

    @EmbeddedId
    private ActivityUserId activityUserId;

    private Date created;

    @Column(length = 300)
    private String content;

    private Long likes;

    public Long getAid() {
        return activityUserId.getAid();
    }

    public void setAid(Long aid) {
        this.activityUserId.setAid(aid);
    }

    public Long getUid() {
        return activityUserId.getUid();
    }

    public void setUid(Long uid) {
        this.activityUserId.setUid(uid);
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

}
