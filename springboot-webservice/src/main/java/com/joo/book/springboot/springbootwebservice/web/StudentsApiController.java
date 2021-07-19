package com.joo.book.springboot.springbootwebservice.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joo.book.springboot.springbootwebservice.service.students.StudentsService;
import com.joo.book.springboot.springbootwebservice.web.dto.StudentsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class StudentsApiController {

    private final StudentsService stuentsService;

    @PostMapping("/api/v1/students")
    public Long save(@RequestBody StudentsSaveRequestDto requestDto) {

        return stuentsService.save(requestDto);
    }

//    @PutMapping("/api/v1/posts/{id}")
//    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
//        return stuentsService.update(id, requestDto);
//    }
//
//    public PostsResponseDto findById(@PathVariable Long id) {
//        return stuentsService.findById(id);
//    }
//
    @DeleteMapping("/api/v1/students/{id}")
    public Long delete(@PathVariable Long id) {
        stuentsService.delete(id);
        return id;
    }

}
