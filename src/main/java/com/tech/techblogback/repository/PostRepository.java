package com.tech.techblogback.repository;

import com.tech.techblogback.base.BaseRepository;
import com.tech.techblogback.model.Post;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends BaseRepository<Post, Long> {

}
