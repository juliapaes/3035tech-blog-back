package com.tech.techblogback.dto.req;


import com.sun.istack.NotNull;
import com.tech.techblogback.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDTO {

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private String email;

    private String profileLink;


}
