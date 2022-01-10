package com.tech.techblogback.dto.req.res;


import com.tech.techblogback.model.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class UserResDTO {

    private Long id;

    private LocalDateTime dateReg;

    private String name;

    private String email;

    private String phone;

    private String profileLink;

    public UserResDTO (Users u) {

        super();
        this.id = u.getId();
        this.dateReg = u.getCreatedAt();
        this.name = u.getName();
        this.email = u.getEmail();
        this.phone = u.getPhone();
        this.profileLink = u.getProfileLink();
    }
    public static UserResDTO of(Users entity) {
        return entity == null ? null : new UserResDTO(entity);
    }
    public static List<Users> all(Users entity) {
        return (List<Users>) new UserResDTO(entity);
    }
}
