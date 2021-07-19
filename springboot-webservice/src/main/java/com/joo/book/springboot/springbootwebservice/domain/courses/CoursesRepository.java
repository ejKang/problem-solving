package com.joo.book.springboot.springbootwebservice.domain.courses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses, Long> { // < EntityClass, PK Type>

	
}
