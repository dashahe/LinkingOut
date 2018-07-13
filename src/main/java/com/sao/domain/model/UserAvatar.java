package com.sao.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class UserAvatar {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long uid;

    @NotEmpty
    public String avatarUrl;
}
