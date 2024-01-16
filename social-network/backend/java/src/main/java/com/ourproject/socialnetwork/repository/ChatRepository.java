package com.ourproject.socialnetwork.repository;

import com.ourproject.socialnetwork.entity.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends MongoRepository<Chat,Long> {
}
