package com.joo.book.springboot.springbootwebservice.domain.courses;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.joo.book.springboot.springbootwebservice.domain.mapping.StudentCourse;
import com.joo.book.springboot.springbootwebservice.domain.mapping.StudentCourseRepository;
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

    @Autowired
    PostsRepository postsRepository;
    
    @Autowired
    StudentCourseRepository scRepository;
    
    @AfterAll
    public void cleanup() {
//    	coursesRepository.deleteAll();
//    	studentsRepository.deleteAll();
    	
    	
    }

//    @Test
//    public void 코스와학생매핑_OneToMany_코스가주인() {
//    	
//        Courses course = Courses.builder().name("meth").build();
//        Courses courseEng = Courses.builder().name("eng").build();
//        Students student = Students.builder().name("ej").build();
//        
//        studentsRepository.save(student);
//        student.getCourse().add(course);
//        student.getCourse().add(courseEng);
//        
//        course.updateStudent(student);
//        courseEng.updateStudent(student);
//        
//        coursesRepository.save(course);
//        coursesRepository.save(courseEng);
//
//        assertThat(course.getStudent().getId()).isNotNull();
//        
//        coursesRepository.delete(course);
//        coursesRepository.delete(courseEng);
//    }
    
//    @Test
//    public void 코스와학생매핑_ManyToMany() {
//    	
//    	String studentsName = "ts";
//    	
//        Courses course = Courses.builder().name("meth").build();
//        Courses courseEng = Courses.builder().name("eng").build();
//        
//        Students student = Students.builder().name("ej").build();
//        
//        coursesRepository.save(course);
//        coursesRepository.save(courseEng);
//        
//        student.update(studentsName, course);
//        student.update(studentsName, courseEng);
//        studentsRepository.save(student);
//        
//        Students tt = studentsRepository.findById(student.getId()).get();
//        
//        for (Courses c : tt.getCourse()) {
//        	System.out.println(c.getName());
//        }
//        
//        assertThat(student.getName()).isEqualTo(studentsName);
//    }
    
//    @Test
//    public void 코스와학생매핑_OneToMany_코스가주인_Cascade() {
//    	
//        Courses course = Courses.builder().name("meth").build();
//        Courses courseEng = Courses.builder().name("eng").build();
//        Students student = Students.builder().name("ej").build();
//        
//        studentsRepository.save(student);
//        student.getCourse().add(course);
//        student.getCourse().add(courseEng);
//        
//        course.updateStudent(student);
//        courseEng.updateStudent(student);
//        
//        coursesRepository.save(course);
//        coursesRepository.save(courseEng);
//
//        assertThat(course.getStudent().getId()).isNotNull();
//        
//        studentsRepository.delete(student);
//
//    }
//    
//    @Test
//    public void 학생과포스트_코스매핑_Cascade() {
//    	
//        Courses course = Courses.builder().name("meth").build();
//        Courses courseEng = Courses.builder().name("eng").build();
//        Students student = Students.builder().name("ej").build();
//        Posts postA = Posts.builder().title("tt").content("cc").author("aa").build();
//        Posts postB = Posts.builder().title("ttq").content("ccq").author("aaq").build();
//        
//        studentsRepository.save(student);
//        student.getCourse().add(course);
//        student.getCourse().add(courseEng);
//        student.getPost().add(postA);
//        student.getPost().add(postB);
//        
//        course.updateStudent(student);
//        courseEng.updateStudent(student);
//        
//        coursesRepository.save(course);
//        coursesRepository.save(courseEng);
//        
//        postA.updateStudent(student);
//        postB.updateStudent(student);
//        
//        postsRepository.save(postA);
//        postsRepository.save(postB);
//
//        assertThat(course.getStudent().getId()).isNotNull();
//        
//        studentsRepository.delete(student);
//
//    }
    
	@Test
	public void 코스와학생매핑_ManyToMany_Separate() {
    	String studentsName = "ts";
    	
        Courses course = Courses.builder().name("meth").build();
        Courses courseEng = Courses.builder().name("eng").build();
        
        Students student = Students.builder().name("ej").build();
        
        coursesRepository.save(course);
        coursesRepository.save(courseEng);
        
//        student.update(studentsName, course);
//        student.update(studentsName, courseEng);
        studentsRepository.save(student);
        
        StudentCourse mapping1 = new StudentCourse();
        mapping1.setStudent(student);
        mapping1.setCourse(course);
        scRepository.save(mapping1);
        
        StudentCourse mapping2 = new StudentCourse();
        mapping2.setStudent(student);
        mapping2.setCourse(courseEng);
        scRepository.save(mapping2);
        
      Students tt = studentsRepository.findById(student.getId()).get();
      
      for (StudentCourse c : tt.getCourse()) {
      	System.out.println(c.getCourse().getName());
      }
      
	}
}
