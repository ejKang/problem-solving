package com.joo.book.springboot.springbootwebservice.domain.students;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Students, Long> { // < EntityClass, PK Type>

	
}
