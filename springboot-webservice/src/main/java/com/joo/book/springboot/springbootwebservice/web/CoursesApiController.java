package com.joo.book.springboot.springbootwebservice.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joo.book.springboot.springbootwebservice.service.courses.CoursesService;
import com.joo.book.springboot.springbootwebservice.web.dto.StudentsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class CoursesApiController {

    private final CoursesService coursesService;

    @PostMapping("/api/v1/courses")
    public Long save(@RequestBody StudentsSaveRequestDto requestDto) {

        return coursesService.save(requestDto);
    }

    @PutMapping("/api/v1/courses/{id}")
    public Long update(@PathVariable Long id, @RequestBody StudentsSaveRequestDto requestDto) {
        return coursesService.update(id, requestDto);
    }

//    public PostsResponseDto findById(@PathVariable Long id) {
//        return stuentsService.findById(id);
//    }
//
    @DeleteMapping("/api/v1/courses/{id}")
    public Long delete(@PathVariable Long id) {
        coursesService.delete(id);
        return id;
    }

}
