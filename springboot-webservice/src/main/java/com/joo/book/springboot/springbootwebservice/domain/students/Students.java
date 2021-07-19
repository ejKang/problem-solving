package com.joo.book.springboot.springbootwebservice.domain.students;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.joo.book.springboot.springbootwebservice.domain.courses.Courses;
import com.joo.book.springboot.springbootwebservice.domain.posts.Posts;

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

	@Builder
	public Students(String name) {
		this.name = name;
	}

//    public void update(String name, Courses course) {
//    	this.name = name;
//    	this.course = course;
//    }

	public void update(String name) {
		this.name = name;
	}
}
