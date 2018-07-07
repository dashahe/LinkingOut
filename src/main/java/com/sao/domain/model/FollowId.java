package com.sao.domain.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Embeddable
public class FollowId implements Serializable {
    @NotEmpty
    private Long starUid;

    @NotEmpty
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
        this.fansUid = fansUid;
    }
}
