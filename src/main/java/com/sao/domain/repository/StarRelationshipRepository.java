package com.sao.domain.repository;

import com.sao.domain.model.StarRelationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRelationshipRepository
        extends JpaRepository<StarRelationship, Long> {
}
