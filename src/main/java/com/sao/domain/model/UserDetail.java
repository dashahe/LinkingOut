package com.sao.domain.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * UserDetail is the entity of user's detail information.
 *
 * @author xvvx
 */
@Entity
public class UserDetail {

    /**
     * User id.
     */
    @Id
    private Long uid;

    /**
     * Email address of user and it should be unique.
     */
    @Email
    private String email;

    /**
     * Collage id of user's university. Optional.
     */
    private String university;

    /**
     * The major of user. Optional.
     */
    private String major;

    /**
     * The hobby of user. Optional.
     */
    private String hobby;

    /**
     * The String of user's photo. The picture is stored in a cloud disk.
     */
    private String image;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
