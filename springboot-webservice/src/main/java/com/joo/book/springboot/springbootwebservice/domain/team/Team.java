package com.joo.book.springboot.springbootwebservice.domain.team;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.joo.book.springboot.springbootwebservice.domain.member.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;
	
	@OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
//	@OneToMany(mappedBy = "team")
	private List<Member> members;
	
	@Builder
	public Team(String name) {
		this.name = name;
	}
}
