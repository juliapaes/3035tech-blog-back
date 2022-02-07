package com.tech.techblogback.repository;

import com.tech.techblogback.base.BaseRepository;
import com.tech.techblogback.dto.req.res.PostsResDTO;
import com.tech.techblogback.model.Posts;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends BaseRepository<Posts, Long> {

    @Query("select e from #{#entityName} e where e.id = ?1 and e.privatePost is true")
    Optional<Posts> findByPrivatePost(Long id);

    @Query(value = "select * from posts p where p.user_id = ?1", nativeQuery = true)
    List<Posts> findByUserId(Long USER_ID);

    @Query(value = "SELECT e FROM posts e ORDER BY e.id and e.users", nativeQuery = true)
    Optional<Posts> findByIdAndUserId(Long id);

    @Query(value = "select * from posts p inner join users u on p.user_id = u.id_user where p.deleted = false", nativeQuery = true)
    List<Posts> findAllPostsOfUsers();

    @Query("select e from #{#entityName} e where e.privatePost is false")
    List<PostsResDTO> findAllPosts();

//    @Query(value =
//            "select * from posts p inner join users u on p.user_id = u.id_user where p.deleted = false and u.email = p.user_id ", nativeQuery = true)
//    List<Posts> findPostsOfUsers();

}
