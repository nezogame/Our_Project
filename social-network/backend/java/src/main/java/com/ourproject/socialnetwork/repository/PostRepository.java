package com.ourproject.socialnetwork.repository;

import com.ourproject.socialnetwork.entity.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,Long> {
}
