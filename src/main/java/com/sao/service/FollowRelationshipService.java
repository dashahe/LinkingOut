package com.sao.service;

import com.sao.domain.model.User;

public interface FollowRelationshipService {

    Iterable<User> findAllFansByUid(Long uid);

    Iterable<User> findAllStarByUid(Long uid);

    Boolean isFansOf(Long uid1, Long uid2);

    Boolean isStarOf(Long uid1, Long uid2);

    Boolean existRelationship(Long fans, Long star);

    void setFansOf(Long star, Long fans);

    void setStarOf(Long fans, Long star);

    void addFollowRelationship(Long fans, Long star);


}
