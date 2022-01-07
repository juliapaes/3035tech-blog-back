package com.tech.techblogback.repository;

import com.tech.techblogback.base.BaseRepository;
import com.tech.techblogback.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UsersRepository extends BaseRepository<Users, Long> {

    @Query(value = "SELECT * FROM movie WHERE users_id = ?1", nativeQuery = true)
    Optional<Users> findByUsersId(Long id);

    Users findOneByEmail(String email);

    Optional<Users> findByEmail(String email);

    Optional<Users> findByPhone(String phone);




}
