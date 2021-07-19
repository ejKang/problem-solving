package com.joo.book.springboot.springbootwebservice.service.courses;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joo.book.springboot.springbootwebservice.domain.courses.Courses;
import com.joo.book.springboot.springbootwebservice.domain.courses.CoursesRepository;
import com.joo.book.springboot.springbootwebservice.domain.posts.Posts;
import com.joo.book.springboot.springbootwebservice.domain.students.Students;
import com.joo.book.springboot.springbootwebservice.domain.students.StudentsRepository;
import com.joo.book.springboot.springbootwebservice.web.dto.PostsUpdateRequestDto;
import com.joo.book.springboot.springbootwebservice.web.dto.StudentsSaveRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // service에서 비지니스 로직을 처리 = X
         // service는 트랜잭션, 도메인 간 순서 보장의 역할만 한다.
         // 비지니스 로직을 처리하는 부분은 domain이다
@Slf4j
public class CoursesService {
	
	private final CoursesRepository coursesRepository;
	private final StudentsRepository studentsRepository;
	
	@Transactional
    public Long save(StudentsSaveRequestDto requestDto) {
		
		Courses courses = new Courses(requestDto.getName());
		
        return coursesRepository.save(courses).getId();
    }
	
	@Transactional
	public void delete(Long id) {
		Courses course = coursesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 수업이 없습니다. id = " + id));
		coursesRepository.delete(course);
	}
	
    @Transactional
    public Long update(Long id, StudentsSaveRequestDto requestDto) {
    	Courses posts = coursesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
    	
    	Students student = studentsRepository.findById(1L)
    			.orElseThrow(() -> new IllegalArgumentException("해당 학생 없습니다. id = " + id));
    	
        posts.update(requestDto.getName(), student);
        return id;
    }
}
