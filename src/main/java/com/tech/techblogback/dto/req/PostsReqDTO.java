package com.tech.techblogback.dto.req;


import com.sun.istack.NotNull;
import com.tech.techblogback.model.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsReqDTO {

    @NotNull
    private String title;

    private String description;

    private String photoLink;

    private boolean privatePost;

    private Long userId;

    private LocalDateTime dateReg;

    private LocalDateTime updateDate;

    public Posts toEntity(Posts entity) {
        entity.setDescription(this.description);
        entity.setPhotoLink(this.photoLink);
        entity.setTitle(this.title);
        entity.setPrivatePost(this.privatePost);
        return entity;
    }




}
