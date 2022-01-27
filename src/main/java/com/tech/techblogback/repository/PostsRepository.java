package com.tech.techblogback.repository;

import com.tech.techblogback.base.BaseRepository;
import com.tech.techblogback.dto.req.res.PostsResDTO;
import com.tech.techblogback.model.Posts;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends BaseRepository<Posts, Long> {

    // Optional<Posts> findByIdAndUserId(Long id, Long userId);

    @Query("select e from #{#entityName} e where e.id = ?1 and e.privatePost is true")
    Optional<Posts> findByPrivatePost(Long id);

    Optional<Posts> findById(Long id);

    @Query(value = "SELECT e FROM posts e ORDER BY e.id and e.users", nativeQuery = true)
    Optional<Posts> findByIdAndUserId(Long id);

    @Query(value = "select * from posts p where USER_ID = USER_ID", nativeQuery = true)
    List<Posts> findAllPostsOfUsers();

    @Query("select e from #{#entityName} e where e.privatePost is false")
    List<PostsResDTO> findAllPosts();


}
