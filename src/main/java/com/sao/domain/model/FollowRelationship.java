package com.sao.domain.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@IdClass(FollowId.class)
public class FollowRelationship {

    @Id
    private Long starUid;

    @Id
    private Long fansUid;

    public Long getStarUid() {
        return starUid;
    }

    public void setStarUid(Long starUid) {
        this.starUid = starUid;
    }

    public Long getFansUid() {
        return fansUid;
    }

    public void setFansUid(Long fansUid) {
        this.fansUid =fansUid;
    }
}
