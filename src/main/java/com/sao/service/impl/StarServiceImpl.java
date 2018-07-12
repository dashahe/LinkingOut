package com.sao.service.impl;

import com.sao.domain.model.Star;
import com.sao.domain.model.StarKey;
import com.sao.service.StarRepository;
import com.sao.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StarServiceImpl implements StarService {


    private StarRepository starRepository;

    @Autowired
    public StarServiceImpl(StarRepository starRepository){
        this.starRepository = starRepository;
    }


    @Override
    public void createStar(long uid, String url) {
        StarKey starKey = new StarKey();
        starKey.setUid(uid);
        starKey.setStarUrl(url);

        Star star = new Star();
        star.key = starKey;
        starRepository.save(star);

    }
}
