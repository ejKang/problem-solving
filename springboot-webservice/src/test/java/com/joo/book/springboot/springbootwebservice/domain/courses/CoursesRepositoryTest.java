package com.joo.book.springboot.springbootwebservice.domain.courses;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.joo.book.springboot.springbootwebservice.domain.posts.Posts;
import com.joo.book.springboot.springbootwebservice.domain.posts.PostsRepository;
import com.joo.book.springboot.springbootwebservice.domain.students.Students;
import com.joo.book.springboot.springbootwebservice.domain.students.StudentsRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CoursesRepositoryTest {

    @Autowired
    CoursesRepository coursesRepository;
    
    @Autowired
    StudentsRepository studentsRepository;

    @AfterAll
    public void cleanup() {
//    	coursesRepository.deleteAll();
    	studentsRepository.deleteAll();
    	
    	
    }

//    @Test
//    public void 코스와학생매핑() {
//    	
//    	String courseName = "aa";
//    	
//        Courses course = Courses.builder().name("aa1").build();
//        Students student = Students.builder().name("eejj1").build();
//        
//        studentsRepository.save(student);
//        
//        course.update(courseName, student);
//        coursesRepository.save(course);
//
//        assertThat(course.getName()).isEqualTo(courseName);
//        assertThat(course.getStudent().getId()).isNotNull();
//
//    }
    
    @Test
    public void 코스와학생매핑_ManyToMany() {
    	
    	String studentsName = "ts";
    	
        Courses course = Courses.builder().name("meth").build();
        Courses courseEng = Courses.builder().name("eng").build();
        
        Students student = Students.builder().name("ej").build();
        
        coursesRepository.save(course);
        coursesRepository.save(courseEng);
        
        student.update(studentsName, course);
        student.update(studentsName, courseEng);
        studentsRepository.save(student);
        
        assertThat(student.getName()).isEqualTo(studentsName);
    }
}
