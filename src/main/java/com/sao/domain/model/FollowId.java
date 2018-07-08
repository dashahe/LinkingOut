package com.sao.domain.model;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class FollowId implements Serializable {

    @Id
    private Long starUid;

    @Id
    private Long fansUid;

    public FollowId() {
        
    }
    
    public FollowId(Long starUid, Long fansUid) {
        this.starUid = starUid;
        this.fansUid = fansUid;
    }

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

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((starUid == null) ? 0 : starUid.hashCode());
        result = PRIME * result + ((fansUid == null) ? 0 : fansUid.hashCode());
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

        final FollowId other = (FollowId) obj;
        if(fansUid == null){
            if(other.fansUid != null){
                return false;
            }
        } else if(!fansUid.equals(other.fansUid)){
            return false;
        }
        if(starUid == null) {
            if(other.starUid != null) {
                return false;
            }
        } else if(!starUid.equals(other.starUid)) {
            return false;
        }
        return true;
    }
    
}
