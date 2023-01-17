package com.tech.techblogback.controller;


import com.tech.techblogback.dto.req.UserReqDTO;
import com.tech.techblogback.dto.res.UserResDTO;
import com.tech.techblogback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public UserResDTO create(@RequestBody UserReqDTO newUser) {
        return this.userService.create(newUser);
    }

    @GetMapping
    public List<UserResDTO> findAllNotDeleted(){
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResDTO findById(@PathVariable("id") Long id) {
        return this.userService.findById(id);
    }

    @PutMapping("/{id}")
    public UserResDTO update(@PathVariable("id") Long id, @Validated @RequestBody UserReqDTO dto) {
        return this.userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void logicalExclusion(@PathVariable("id") Long id) {
        this.userService.logicalExclusion(id);
    }

}