package com.tech.techblogback.dto.res;


import com.tech.techblogback.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserResDTO {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String profileLink;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean deleted;

    public UserResDTO(User user) {

        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.profileLink = user.getProfileLink();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.deleted = user.isDeleted();

    }

    public static UserResDTO of(User entity) {
        return entity == null ? null : new UserResDTO(entity);
    }

}
