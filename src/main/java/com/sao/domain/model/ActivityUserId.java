package com.sao.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ActivityUserId implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long aid;

    @Id
    private Long uid;

    public ActivityUserId() {

    }

    public ActivityUserId(Long aid, Long uid) {
        this.aid = aid;
        this.uid = uid;
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

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((aid == null) ? 0 : aid.hashCode());
        result = PRIME * result + ((uid == null) ? 0 : uid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) {
            return true;
        }
        if(obj == null) {
            return false;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }

        final ActivityUserId other = (ActivityUserId) obj;
        if(uid == null){
            if(other.uid != null){
                return false;
            }
        } else if(!uid.equals(other.uid)){
            return false;
        }
        if(aid == null) {
            if(other.aid != null) {
                return false;
            }
        } else if(!aid.equals(other.aid)) {
            return false;
        }
        return true;
    }
}
