package com.tech.techblogback.repository;

import com.tech.techblogback.base.BaseRepository;
import com.tech.techblogback.model.Posts;
import com.tech.techblogback.model.Users;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface UsersRepository extends BaseRepository<Users, Long> {

    @Query(value = "SELECT * FROM users WHERE users_id = ?1", nativeQuery = true)
    Users findByUsersId(Long id);

    Users findOneByEmail(String email);

    Optional<Users> findByEmail(String email);

    Optional<Users> findById(Long id);

    Optional<Users> findByPhone(String phone);

    @Query(value = "select * from users u where u.email = (?1) and u.password = (?2)", nativeQuery = true)
    List<Users> findByAutheticated(String email, String password);


}
