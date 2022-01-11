package com.tech.techblogback.service;

import com.tech.techblogback.dto.req.PostsReqDTO;
import com.tech.techblogback.model.Posts;
import com.tech.techblogback.model.Users;
import com.tech.techblogback.repository.PostsRepository;
import com.tech.techblogback.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@AllArgsConstructor
@Log4j2
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    private final UsersRepository usersRepository;

    public Posts createPost(PostsReqDTO dto){

        Optional<Users> user = this.findById(dto.getUserId());

        if(user.isEmpty())
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Usuário não cadastrado");

        Posts posts = Posts
                .builder()
                .description(dto.getDescription())
                .privatePost(dto.isPrivatePost())
                .photoLink(dto.getPhotoLink())
                .title(dto.getTitle())
                .users(user.get())
                .build();

         return this.postsRepository.save(posts);

    }
    private Optional<Users> findById(Long id){
        return this.usersRepository.findById(id);
    }


}
