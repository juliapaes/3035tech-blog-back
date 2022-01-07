package com.tech.techblogback.dto.req;

import com.tech.techblogback.model.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsReqDTO {

    private Users users;

    private String title;

    private String description;

    private String photoLink;

    private boolean privatePost;


}
