package com.sao.service;


import com.sao.domain.model.StarRelationship;

public interface StarRelationshipService {

    Boolean existStarRelationship(Long uid, Long aid);

    Iterable<StarRelationship> findAll();

    Iterable<StarRelationship> findAllByUid(Long uid);

    Iterable<StarRelationship> findAllByAid(Long aid);

    void addStarRelationship(Long uid, Long aid);
}
