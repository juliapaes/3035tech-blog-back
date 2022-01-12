package com.tech.techblogback.repository;

import com.sun.xml.bind.v2.model.core.ID;
import com.tech.techblogback.base.BaseRepository;
import com.tech.techblogback.model.Posts;
import com.tech.techblogback.model.Users;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostsRepository extends BaseRepository<Posts, Long> {

    Optional<Posts> findById(Long id);

    // Optional<Posts> findByIdAndUserId(Long id, Long userId);

    @Query("select e from #{#entityName} e where e.id = ?1 and e.privatePost is true")
    Optional<Posts> findByPrivatePost(Long id);

}
