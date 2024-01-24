package com.ourproject.socialnetwork.service;

import com.ourproject.socialnetwork.mapper.PostMapper;
import com.ourproject.socialnetwork.model.PostDto;
import com.ourproject.socialnetwork.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final SequenceGeneratorService postSequenceService;

    public List<PostDto> findAllPosts(){
        var chats = postRepository.findAll();
        return chats.stream()
                .map(PostMapper.INSTANCE::postToPostDto)
                .toList();
    }
}
