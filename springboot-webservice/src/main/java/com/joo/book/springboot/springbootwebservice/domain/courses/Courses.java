package com.joo.book.springboot.springbootwebservice.domain.courses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.joo.book.springboot.springbootwebservice.domain.students.Students;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String name;
    
    @OneToOne(mappedBy = "course")
    private Students student;
    
    @Builder
    public Courses(String name) {
        this.name = name;
    }

    public void update(String name) {
    	this.name = name;
    }
}
