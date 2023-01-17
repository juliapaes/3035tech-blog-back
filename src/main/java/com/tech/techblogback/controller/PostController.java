package com.tech.techblogback.controller;


import com.tech.techblogback.dto.req.PostsReqDTO;
import com.tech.techblogback.dto.res.PostResDTO;
import com.tech.techblogback.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public PostResDTO create(@Validated @RequestBody PostsReqDTO newPost) {
        return this.postService.create(newPost);
    }

    @DeleteMapping("/{id}")
    public void logicalExclusion(@PathVariable("id") Long id) {
        this.postService.logicalExclusion(id);
    }

    @GetMapping("/{id}")
    public PostResDTO findById(@PathVariable("id") Long id) {
        return PostResDTO.of(this.postService.findById(id));
    }

    @PutMapping("/{id}")
    public PostResDTO update(@PathVariable("id") Long id, @Validated @RequestBody PostsReqDTO dto) {
        return PostResDTO.of(this.postService.update(id, dto));
    }

    @GetMapping("/findAll")
    public List<PostResDTO> findAllNotDeleted() {
        return this.postService.findAll();
    }

}