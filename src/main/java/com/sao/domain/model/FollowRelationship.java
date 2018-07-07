package com.sao.domain.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
public class FollowRelationship {

    @EmbeddedId
    private FollowId followId;

    public Long getStarUid() {
        return followId.getStarUid();
    }

    public void setStarUid(Long starUid) {
        this.followId.setStarUid(starUid);
    }

    public Long getFansUid() {
        return followId.getFansUid();
    }

    public void setFansUid(Long fansUid) {
        this.followId.setFansUid(fansUid);
    }
}
