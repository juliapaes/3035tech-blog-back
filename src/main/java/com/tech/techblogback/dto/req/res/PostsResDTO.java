package com.tech.techblogback.dto.req.res;

import com.tech.techblogback.model.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostsResDTO {

    private Users users;

    private String title;

    private String description;

    private String photoLink;

    private boolean privatePost;
}
