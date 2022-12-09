package com.swapp.swapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swapp.swapp.model.Books;
import com.swapp.swapp.model.Swipe;
import com.swapp.swapp.model.Users;
import com.swapp.swapp.repository.SwipeRepository;

@Service
public class SwipeService {

    @Autowired
    SwipeRepository swipeRepository;


    public void saveSwipe(Books b, Users u, Boolean like){
        Swipe swipe = new Swipe();
        swipe.setShownBook(b);
        swipe.setSwiperUser(u);
        swipe.setLiked(like);

        swipeRepository.save(swipe);
    }
    
}
