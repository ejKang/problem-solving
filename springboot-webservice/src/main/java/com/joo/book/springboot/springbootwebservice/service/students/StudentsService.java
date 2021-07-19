package com.joo.book.springboot.springbootwebservice.service.students;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joo.book.springboot.springbootwebservice.domain.courses.Courses;
import com.joo.book.springboot.springbootwebservice.domain.courses.CoursesRepository;
import com.joo.book.springboot.springbootwebservice.domain.students.Students;
import com.joo.book.springboot.springbootwebservice.domain.students.StudentsRepository;
import com.joo.book.springboot.springbootwebservice.web.dto.StudentsSaveRequestDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // service에서 비지니스 로직을 처리 = X
         // service는 트랜잭션, 도메인 간 순서 보장의 역할만 한다.
         // 비지니스 로직을 처리하는 부분은 domain이다
@Slf4j
public class StudentsService {

	private final StudentsRepository studentsRepository;
	private final CoursesRepository coursesRepository;
	
	@Transactional
    public Long save(StudentsSaveRequestDto requestDto) {
		
		Students students = new Students(requestDto.getName());
//		Courses courses = new Courses("bb");
//		students.update("bb", courses);
//		coursesRepository.save(courses);
		
		
        return studentsRepository.save(students).getId();
    }

	@Transactional
	public void delete(Long id) {
		Students students = studentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 학생이 없습니다. id = " + id));
        studentsRepository.delete(students);
	}
}
