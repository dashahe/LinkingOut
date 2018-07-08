package com.sao.domain.repository;

import com.sao.domain.model.FollowRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRelationshipRepository extends
        JpaRepository<FollowRelationship, Long> {

}
