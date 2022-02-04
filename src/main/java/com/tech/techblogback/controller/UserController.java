package com.tech.techblogback.controller;


import com.tech.techblogback.dto.req.UsersReqDTO;
import com.tech.techblogback.dto.req.res.UserResDTO;
import com.tech.techblogback.model.Users;
import com.tech.techblogback.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<Users> listGet(){return this.usersService.findAll();}


    @PostMapping("/sign-up")
    public UserResDTO signUp(@RequestBody UsersReqDTO newUser) {
        return this.usersService.createUsers(newUser);
    }


    @GetMapping("/{id}")
    public UserResDTO show(@PathVariable("id") Long id) {
        return UserResDTO.of(this.usersService.findById(id));
    }


    @DeleteMapping("/destroy/{id}")
    public void permanentDestroy(@PathVariable("id") Long id) {
        this.usersService.permanentDestroy(id);
    }


    @PutMapping("/{id}")
    public UserResDTO update(@PathVariable("id") Long id, @Validated @RequestBody UsersReqDTO dto) {
        return UserResDTO.of(this.usersService.save(dto.toEntity(this.usersService.findById(id))));
    }

    @DeleteMapping("/{id}")
    public void logicalExclusion(@PathVariable("id") Long id) {
        this.usersService.logicalExclusion(id);
    }

}