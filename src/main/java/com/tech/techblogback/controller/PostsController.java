package com.tech.techblogback.controller;


import com.tech.techblogback.dto.req.PostsReqDTO;
import com.tech.techblogback.model.Posts;
import com.tech.techblogback.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostsController {

    @Autowired
    PostsService postsService;

    @PostMapping("/create-post")
    public Posts createPost(@Validated @RequestBody PostsReqDTO newPost) {
        return this.postsService.createPost(newPost);
    }
}
