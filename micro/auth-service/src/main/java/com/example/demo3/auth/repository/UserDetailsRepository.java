package com.example.demo3.auth.repository;

import com.example.demo3.auth.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by abosii on 7/18/17.
 */
@Repository
public interface UserDetailsRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}
