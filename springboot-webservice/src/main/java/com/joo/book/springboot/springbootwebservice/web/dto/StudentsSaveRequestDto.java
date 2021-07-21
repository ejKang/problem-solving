package com.joo.book.springboot.springbootwebservice.web.dto;

import com.joo.book.springboot.springbootwebservice.domain.posts.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StudentsSaveRequestDto {

    private String name;
    private Long courseId;
    private Long studentId;

    @Builder
    public StudentsSaveRequestDto(String name, String content, String author) {
        this.name = name;
    }

    public Posts toEntity() {
        return Posts.builder().title(name).build();
    }
}
