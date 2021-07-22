package com.joo.book.springboot.springbootwebservice.domain.students;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.joo.book.springboot.springbootwebservice.domain.courses.Courses;

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

//	@OneToMany(mappedBy = "student")
//	private List<Courses> course;

	@ManyToMany
	@JoinTable
	private Set<Courses> course;

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

	public void update(String name, Courses course) {
		this.name = name;
		this.course.add(course);
	}
}
