package com.ourproject.socialnetwork.repository;

import com.ourproject.socialnetwork.entity.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findUserByUsername(String name);

}
