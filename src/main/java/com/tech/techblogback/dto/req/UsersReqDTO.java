package com.tech.techblogback.dto.req;


import com.tech.techblogback.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersReqDTO {

    private String name;

    private String phone;

    private String email;

    private String Password;

    private String passwordConfirmation;

    private String profileLink;



}
