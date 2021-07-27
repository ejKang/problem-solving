package com.joo.book.springboot.springbootwebservice.domain.mapping;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> { // < EntityClass, PK Type>

	
}
