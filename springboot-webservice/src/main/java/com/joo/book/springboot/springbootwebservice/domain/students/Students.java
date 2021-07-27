package com.joo.book.springboot.springbootwebservice.domain.students;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.joo.book.springboot.springbootwebservice.domain.courses.Courses;
import com.joo.book.springboot.springbootwebservice.domain.mapping.StudentCourse;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

//    @OneToOne
//    private Courses course;

//	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//	@OneToMany(mappedBy = "student")
//	private Set<Courses> course;
	
	@OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
	private Set<StudentCourse> course;

//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable
//	private Set<Courses> course;

//	@Builder
//	public Students(String name) {
//		this.name = name;
//	}
	
	@Builder
	public Students(String name) {
		this.name = name;
		this.course = new HashSet<>();
	}

//    public void update(String name, Courses course) {
//    	this.name = name;
//    	this.course = course;
//    }

//	public void update(String name) {
//		this.name = name;
//	}

//	public void update(String name, Courses course) {
//		this.name = name;
//		this.course.add(course);
//	}
	
	public void update(String name, StudentCourse course) {
		this.name = name;
		this.course.add(course);
	}
	
//	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//	private Set<Posts> post;
	
//	@Builder
//	public Students(String name) {
//		this.name = name;
//		this.course = new HashSet<>();
//		this.post = new HashSet<>();
//	}
}
