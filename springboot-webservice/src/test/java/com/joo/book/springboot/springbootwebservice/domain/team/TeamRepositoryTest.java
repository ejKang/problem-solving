package com.joo.book.springboot.springbootwebservice.domain.team;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.joo.book.springboot.springbootwebservice.domain.member.Member;
import com.joo.book.springboot.springbootwebservice.domain.member.MemberRepository;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TeamRepositoryTest {

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
		
		Member mem = memberRepository.findById(memeber1.getId()).get();
//		mem.getTeam().getName();
	}
}
