package com.swapp.swapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapp.swapp.model.Books;
import com.swapp.swapp.model.Swipe;
import com.swapp.swapp.model.*;
import com.swapp.swapp.repository.SwipeRepository;

@Service
public class SwipeService {

    @Autowired
    SwipeRepository swipeRepository;

    @Autowired
    MatchService matchService;


    public void saveSwipe(Books b, Users u, Boolean like){
        Swipe swipe = new Swipe();
        swipe.setShownBook(b);
        swipe.setSwiperUser(u);
        swipe.setLiked(like);

        if (like){
            List<Swipe> list = swipeRepository.isMatch(u.getId(), b.getUser().getId());
            if (!list.isEmpty()){
                Swipe s = list.get(0);
                matchService.saveMatch(u, b.getUser(), s.getShownBook(), b);

            }
        }

        swipeRepository.save(swipe);
    }
    
}
