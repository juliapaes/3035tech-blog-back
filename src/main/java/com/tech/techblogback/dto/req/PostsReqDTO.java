package com.tech.techblogback.dto.req;


import lombok.Data;


@Data
public class PostsReqDTO {

    private Long usersId;

    private String title;

    private String description;

    private String photoLink;

    private boolean privatePost;




}
