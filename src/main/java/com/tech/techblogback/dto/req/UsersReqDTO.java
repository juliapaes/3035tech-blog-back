package com.tech.techblogback.dto.req;


import com.sun.istack.NotNull;
import com.tech.techblogback.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersReqDTO {

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    @NotNull
    private String Password;

    private String passwordConfirmation;

    private String profileLink;

    private LocalDateTime dateReg;

    private LocalDateTime updateDate;

    public Users toEntity(Users entity) {
        entity.setName(this.name);
        entity.setEmail(this.email);
        entity.setPhone(this.phone);
        entity.setPassword(this.Password);
        entity.setProfileLink(this.profileLink);

        return entity;
    }



}
