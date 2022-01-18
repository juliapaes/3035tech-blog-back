package com.tech.techblogback.service;

import com.tech.techblogback.config.security.AuthUtil;
import com.tech.techblogback.dto.req.PostsReqDTO;
import com.tech.techblogback.dto.req.UsersReqDTO;
import com.tech.techblogback.dto.req.res.PostsResDTO;
import com.tech.techblogback.model.Posts;
import com.tech.techblogback.model.Users;
import com.tech.techblogback.repository.PostsRepository;
import com.tech.techblogback.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Log4j2
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    private final UsersRepository usersRepository;

    private final UsersService usersService;

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

    private Optional<Posts> findPostDeleted(Long id){return this.postsRepository.findDeletedById(id);}

    private  Optional<Posts> findPrivatePost(Long id){return this.postsRepository.findByPrivatePost(id);}


    public Posts findByPostId(Long id) {
        if (findPostDeleted(id).isPresent()){
            throw new ServiceException("Post deletado");
        }
        return this.postsRepository.findById(id).orElseThrow(() -> new ServiceException("id não encontrado"));
    }
    
    public void logicalExclusion(Long id, PostsReqDTO dto) {
        Optional<Users> user = this.findById(dto.getUserId());
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Usuário não cadastrado");}
        if (findByPostId(id) == null){
             this.postsRepository.findById(id).orElseThrow(() -> new ServiceException("id não encontrado"));
        }
         this.postsRepository.softDelete(id);
    }

     public Posts findByPostsId(Long id) {
         if (findPostDeleted(id).isPresent()){
            throw new ServiceException("Post deletado");
        }
         if (findPrivatePost(id).isPresent()){
             throw new ServiceException("Post Privado!");
         }
        return this.postsRepository.findById(id).orElseThrow(() -> new ServiceException("id não encontrado"));
    }

    public Posts save(PostsReqDTO dto, Long id){
        Optional<Users> user = this.findById(dto.getUserId());
        if(user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Usuário não cadastrado");}
        if (findByPostId(id) == null){
            return this.postsRepository.findById(id).orElseThrow(() -> new ServiceException("id não encontrado"));
        }
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

    public Posts findByPostsUsers(Long id) {
        Posts Posts = this.postsRepository.findByIdAndUserId(id, AuthUtil.getUserId())
                .orElseThrow(() -> new ServiceException("Não foi possivel encontrar o post"));
        if (Posts == null){
            if (findPrivatePost(id).isPresent()){
                throw new ServiceException("Post Privado!");
            }
        }
        if (findPostDeleted(id).isPresent()){
            throw new ServiceException("Post deletado");
        }
        return this.postsRepository.findById(id).orElseThrow(() -> new ServiceException("id não encontrado"));
    }

    public List<PostsResDTO> findAllPostsNotPrivate() {return this.postsRepository.findAllPosts();}
}
