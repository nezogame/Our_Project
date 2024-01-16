package com.ourproject.socialnetwork.service;

import com.ourproject.socialnetwork.entity.Post;
import com.ourproject.socialnetwork.repository.PostRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final SequenceGeneratorService postSequenceService;

    public Optional<List<Post>> findAllPosts(){
        return Optional.of(postRepository.findAll());
    }
}
