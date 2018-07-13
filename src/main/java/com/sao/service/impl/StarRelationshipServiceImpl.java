package com.sao.service.impl;

import com.sao.domain.model.StarRelationship;
import com.sao.domain.repository.StarRelationshipRepository;
import com.sao.service.StarRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class StarRelationshipServiceImpl implements StarRelationshipService {

    @Autowired
    private StarRelationshipRepository starRelationshipRepository;

    @Override
    public Boolean existStarRelationship(Long uid, Long aid) {
        for (StarRelationship starRelationship : starRelationshipRepository.findAll()) {
            if (starRelationship.getAid().equals(aid) && starRelationship.getUid().equals(uid)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterable<StarRelationship> findAll() {
        return starRelationshipRepository.findAll();
    }

    @Override
    public Iterable<StarRelationship> findAllByUid(Long uid) {
        LinkedList<StarRelationship> starRelationships = new LinkedList<>();
        for (StarRelationship starRelationship : starRelationshipRepository.findAll()) {
            if (starRelationship.getUid().equals(uid)) {
                starRelationships.add(starRelationship);
            }
        }
        return starRelationships;
    }

    @Override
    public Iterable<StarRelationship> findAllByAid(Long aid) {
        LinkedList<StarRelationship> starRelationships = new LinkedList<>();
        for (StarRelationship starRelationship : starRelationshipRepository.findAll()) {
            if (starRelationship.getAid().equals(aid)) {
                starRelationships.add(starRelationship);
            }
        }
        return starRelationships;
    }

    @Override
    public void addStarRelationship(Long uid, Long aid) {
        StarRelationship starRelationship = new StarRelationship();
        starRelationship.setAid(aid);
        starRelationship.setUid(uid);;
        starRelationshipRepository.save(starRelationship);
    }

}
