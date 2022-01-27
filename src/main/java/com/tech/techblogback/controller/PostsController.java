package com.tech.techblogback.controller;


import com.tech.techblogback.dto.req.PostsReqDTO;
import com.tech.techblogback.dto.req.UsersReqDTO;
import com.tech.techblogback.dto.req.res.PostsResDTO;
import com.tech.techblogback.dto.req.res.UserResDTO;
import com.tech.techblogback.model.Posts;
import com.tech.techblogback.service.PostsService;
import com.tech.techblogback.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @Autowired
    private UsersService usersService;

    @PostMapping("/create-post")
    public Posts createPost(@Validated @RequestBody PostsReqDTO newPost) {
        return this.postsService.createPost(newPost);
    }

    @DeleteMapping("/{id}")
    public void logicalExclusion(@PathVariable("id") Long id, PostsReqDTO idUser) {
        this.postsService.logicalExclusion(id, idUser);
    }

    @GetMapping("/{id}")
    public PostsResDTO showPostsById(@PathVariable("id") Long id) {
        return PostsResDTO.of(this.postsService.findByPostsId(id));
    }

    @PutMapping("/{id}")
      public PostsResDTO update(@PathVariable("id") Long id, @Validated @RequestBody PostsReqDTO dto) {
        return PostsResDTO.of(this.postsService.save(dto.toEntity(this.postsService.findByPostId(id))));
    }

    @GetMapping("/UserMustBeLogged")
    @PreAuthorize("hasAuthority('ADMIN')")
    public PostsResDTO showPostsOfUsersBeLogged(@PathVariable("id") Long id) {
        return PostsResDTO.of(this.postsService.findByPostsUsers(id));
    }

    @GetMapping("/AllPosts")
     public List<PostsResDTO> AllPosts() {
        return this.postsService.findAllPostsNotPrivate();
      }
}