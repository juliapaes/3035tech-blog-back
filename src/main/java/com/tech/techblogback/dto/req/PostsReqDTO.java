package com.tech.techblogback.dto.req;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsReqDTO {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Long userId;

    private String photoLink;

}
