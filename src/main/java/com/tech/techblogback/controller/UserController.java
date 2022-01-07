package com.tech.techblogback.controller;


import com.tech.techblogback.dto.req.UsersReqDTO;
import com.tech.techblogback.dto.req.res.UserResDTO;
import com.tech.techblogback.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UsersService usersService;


    @PostMapping("/sign-up")
    public UserResDTO signUp(@RequestBody UsersReqDTO newUser) {
        return this.usersService.createUsers(newUser);
    }
}
