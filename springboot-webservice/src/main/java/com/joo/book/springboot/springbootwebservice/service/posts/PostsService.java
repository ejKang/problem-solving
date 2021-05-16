package com.joo.book.springboot.springbootwebservice.service.posts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.joo.book.springboot.springbootwebservice.domain.posts.Posts;
import com.joo.book.springboot.springbootwebservice.domain.posts.PostsRepository;
import com.joo.book.springboot.springbootwebservice.web.dto.PostsListResponseDto;
import com.joo.book.springboot.springbootwebservice.web.dto.PostsResponseDto;
import com.joo.book.springboot.springbootwebservice.web.dto.PostsSaveRequestDto;
import com.joo.book.springboot.springbootwebservice.web.dto.PostsUpdateRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // service에서 비지니스 로직을 처리 = X
         // service는 트랜잭션, 도메인 간 순서 보장의 역할만 한다.
         // 비지니스 로직을 처리하는 부분은 domain이다
@Slf4j
public class PostsService {

    private final RestTemplate restTemplate;
    private final PostsRepository postsRepository; // 롬복 어노테이션을 통해 bean을 주입 받는다 ( 생성자를 통해 )

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        postsRepository.delete(posts);
    }

    public Long get() {
        Long test = 1L;
        // String URL = "http://localhost:8080/hello/dto";
        String URL = "http://localhost:8080/hello";
        Map<String, String> param = new HashMap<>();
        param.put("name", "ss");
        param.put("amount", "33");
        // HelloResponseDto dto1 = restTemplate.getForObject(URL,
        // HelloResponseDto.class, param);
        String dto1 = restTemplate.getForObject(URL, String.class, param);
        // System.out.println(dto1);
        // log.info(dto1.toString());
        log.info(dto1);
        return test;
    }

}
