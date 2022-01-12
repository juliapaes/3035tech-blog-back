package com.tech.techblogback.controller;


import com.tech.techblogback.dto.req.PostsReqDTO;
import com.tech.techblogback.dto.req.UsersReqDTO;
import com.tech.techblogback.dto.req.res.PostsResDTO;
import com.tech.techblogback.dto.req.res.UserResDTO;
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

    @DeleteMapping("/{id}")
    public void logicalExclusion(@PathVariable("id") Long id) {
        this.postsService.logicalExclusion(id);
    }

    @GetMapping("/{id}")
    public PostsResDTO showPostsNotPrivate(@PathVariable("id") Long id) {
        return PostsResDTO.of(this.postsService.findByPostsId(id));
    }
}