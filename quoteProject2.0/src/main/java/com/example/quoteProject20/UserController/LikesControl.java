package com.example.quoteProject20.UserController;

import com.example.quoteProject20.Model.Likes;
import com.example.quoteProject20.Services.LikesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Likes")
public class LikesControl {
public LikesService likesService;

public LikesControl (LikesService likesService){
    this.likesService = likesService;
}

@PostMapping
    public Likes createLikeForPost(@RequestBody Likes like){
    return likesService.createLikePost(like);
}
}
