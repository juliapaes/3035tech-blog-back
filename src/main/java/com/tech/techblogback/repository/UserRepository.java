package com.tech.techblogback.repository;

import com.tech.techblogback.base.BaseRepository;
import com.tech.techblogback.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, Long> {

}
