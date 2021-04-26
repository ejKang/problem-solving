package com.joo.book.springboot.springbootwebservice.service.posts;

import com.joo.book.springboot.springbootwebservice.domain.posts.PostsRepository;
import com.joo.book.springboot.springbootwebservice.web.dto.PostsSaveRequestDto;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
