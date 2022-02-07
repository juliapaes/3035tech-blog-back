package com.tech.techblogback.dto.req.res;

import com.tech.techblogback.model.Posts;
import com.tech.techblogback.model.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostsResDTO {
    private Long id;

    private String title;

    private String description;

    private String photoLink;

    private LocalDateTime dateReg;

    private boolean privatePost;

    private Users userId;

    public PostsResDTO(Posts p) {

        super();
        this.privatePost = p.isPrivatePost();
        this.userId = p.getUsers();
        this.description = p.getDescription();
        this.userId = p.getUsers();
        this.title = p.getTitle();
        this.photoLink = p.getPhotoLink();
        this.id = p.getId();
        this.dateReg = p.getCreatedAt();

    }
    public static PostsResDTO of(Posts entity) {
        return entity == null ? null : new PostsResDTO(entity);
    }
}