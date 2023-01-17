package com.tech.techblogback.dto.res;

import com.tech.techblogback.model.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PostResDTO {

    private Long id;

    private String title;

    private String description;

    private String photoLink;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Boolean deleted;

    public PostResDTO(Post post) {

        this.id = post.getId();
        this.description = post.getDescription();
        this.title = post.getTitle();
        this.photoLink = post.getPhotoLink();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.deleted = post.isDeleted();

    }

    public static PostResDTO of(Post entity) {
        return entity == null ? null : new PostResDTO(entity);
    }
}