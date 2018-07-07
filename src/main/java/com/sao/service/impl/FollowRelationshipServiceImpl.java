package com.sao.service.impl;

import com.sao.domain.model.FollowRelationship;
import com.sao.domain.model.User;
import com.sao.domain.repository.FollowRelationshipRepository;
import com.sao.domain.repository.UserRepository;
import com.sao.service.FollowRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class FollowRelationshipServiceImpl implements FollowRelationshipService {

    @Autowired
    private FollowRelationshipRepository followRelationshipRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAllFansByUid(Long uid) {
        LinkedList<User> result = new LinkedList<>();
        for (FollowRelationship followRelationship :
                followRelationshipRepository.findAll()) {
            if (followRelationship.getStarUid().equals(uid)) {
                result.add(userRepository.findById(followRelationship.getFansUid()).get());
            }
        }
        return result;
    }

    @Override
    public Iterable<User> findAllStarByUid(Long uid) {
        LinkedList<User> result = new LinkedList<>();
        for (FollowRelationship followRelationship :
                followRelationshipRepository.findAll()) {
            if (followRelationship.getFansUid().equals(uid)) {
                result.add(userRepository.findById(followRelationship.getStarUid()).get());
            }
        }
        return result;
    }

    @Override
    public Boolean isFansOf(Long uid1, Long uid2) {
        for (FollowRelationship followRelationship :
                followRelationshipRepository.findAll()) {
            if (followRelationship.getFansUid().equals(uid1)
                    && followRelationship.getStarUid().equals(uid2)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean isStarOf(Long uid1, Long uid2) {
        return isFansOf(uid2, uid1);
    }

    @Override
    public void setFansOf(Long star, Long fans) {
        for (FollowRelationship followRelationship :
                followRelationshipRepository.findAll()) {
            if (followRelationship.getStarUid().equals(star)) {
                followRelationship.setFansUid(fans);
                return;
            }
        }
    }

    @Override
    public void setStarOf(Long fans, Long star) {
        for (FollowRelationship followRelationship :
                followRelationshipRepository.findAll()) {
            if (followRelationship.getFansUid().equals(fans)) {
                followRelationship.setStarUid(star);
                return;
            }
        }
    }

    public void setFollowRelationshipRepository(FollowRelationshipRepository followRelationshipRepository) {
        this.followRelationshipRepository = followRelationshipRepository;
    }

    @Override
    public void addFollowRelationship(Long fans, Long star) {
        FollowRelationship followRelationship = new FollowRelationship();
        followRelationship.setStarUid(star);
        followRelationship.setFansUid(fans);
        if (!existRelationship(fans, star)) {
            followRelationshipRepository.save(followRelationship);
        }
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean existRelationship(Long fans, Long star) {
        for (FollowRelationship followRelationship :
                followRelationshipRepository.findAll()) {
            if (followRelationship.getFansUid().equals(fans)
                    && followRelationship.getStarUid().equals(star)) {
                return true;
            }
        }
        return false;
    }
}
