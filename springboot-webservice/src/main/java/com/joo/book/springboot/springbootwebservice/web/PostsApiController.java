package com.joo.book.springboot.springbootwebservice.web;

import com.joo.book.springboot.springbootwebservice.service.posts.PostsService;
import com.joo.book.springboot.springbootwebservice.web.dto.PostsSaveRequestDto;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {

        return postsService.save(requestDto);
    }
}
