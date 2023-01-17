package com.tech.techblogback.service;

import com.tech.techblogback.dto.req.PostsReqDTO;
import com.tech.techblogback.dto.res.PostResDTO;
import com.tech.techblogback.model.Post;
import com.tech.techblogback.model.User;
import com.tech.techblogback.repository.PostRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public PostResDTO create(PostsReqDTO dto) {

        User user = this.userService.findByIdEntity(dto.getUserId());

        Post post = new Post();

        post.setDescription(dto.getDescription());
        post.setTitle(dto.getTitle());
        post.setUser(user);
        post.setPhotoLink(dto.getPhotoLink());

        return PostResDTO.of(this.postRepository.save(post));

    }

    public Post findById(Long id) {
        return this.postRepository.findById(id).orElseThrow(() -> new ServiceException("Id não encontrado"));
    }

    public void logicalExclusion(Long id) {
        if (!this.postRepository.findById(id).isPresent())
            throw new ServiceException("Post não existe");
        this.postRepository.softDelete(id);
    }

    public Post update(Long idPost, PostsReqDTO dto) {

        Post post = this.findById(idPost);

        post.setDescription(dto.getDescription());
        post.setTitle(dto.getTitle());

        if (dto.getPhotoLink() != null)
            post.setPhotoLink(dto.getPhotoLink());

        return this.postRepository.save(post);
    }

    public List<PostResDTO> findAll() {
        return this.postRepository.findAll().stream().map(PostResDTO::of).collect(Collectors.toList());
    }
}
