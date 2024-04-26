package com.example.quoteProject20.Services;

import com.example.quoteProject20.Model.Likes;
import com.example.quoteProject20.Respository.LikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikesService {
    private final LikeRepository likeRepository;

    public LikesService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public Likes createLikePost(Likes like){
        Likes likee = mapToLikeRequestToLike(like);
        return likeRepository.save(likee);
    }



    private Likes mapToLikeRequestToLike(Likes like) {
        return Likes.builder()
                .isLikes(like.isLikes())
                .quote(like.getQuote())
                .user(like.getUser())
                .build();
    }


}
