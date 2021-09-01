package com.joo.book.springboot.springbootwebservice.domain.team;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.joo.book.springboot.springbootwebservice.domain.member.Member;
import com.joo.book.springboot.springbootwebservice.domain.member.MemberRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TeamRepositoryDataTest {

	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void team_member_mapping() {
		
		Team team1 = Team.builder().name("team1").build();
		teamRepository.save(team1);
		
		Member memeber1 = Member.builder().name("jun").build();
		memeber1.updateTeam(team1);
		memberRepository.save(memeber1);
		
		Team team2 = Team.builder().name("team2").build();
		teamRepository.save(team2);
		
		Member memeber2 = Member.builder().name("yun").build();
		memeber2.updateTeam(team2);
		memberRepository.save(memeber2);
		
		memberRepository.findAll().stream().forEach(mem -> System.out.println(mem.getTeam().getName()));
		System.out.println("********************************");
	}
}
