package com.sao.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Embeddable
public class ActivityUserId implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotEmpty
    private Long aid;

    @NotEmpty
    private Long uid;

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
}
