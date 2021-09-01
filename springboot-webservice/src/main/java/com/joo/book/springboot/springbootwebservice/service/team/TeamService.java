package com.joo.book.springboot.springbootwebservice.service.team;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.joo.book.springboot.springbootwebservice.domain.member.Member;
import com.joo.book.springboot.springbootwebservice.domain.member.MemberRepository;
import com.joo.book.springboot.springbootwebservice.domain.posts.PostsRepository;
import com.joo.book.springboot.springbootwebservice.domain.team.Team;
import com.joo.book.springboot.springbootwebservice.domain.team.TeamRepository;
import com.joo.book.springboot.springbootwebservice.service.posts.PostsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service // service에서 비지니스 로직을 처리 = X
         // service는 트랜잭션, 도메인 간 순서 보장의 역할만 한다.
         // 비지니스 로직을 처리하는 부분은 domain이다
@Slf4j
public class TeamService {
	private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
	public Long getmm() {
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
		
		Member memeber3 = Member.builder().name("eun").build();
		memeber3.updateTeam(team2);
		memberRepository.save(memeber3);
		
		return team1.getId();
	}

	public Long getmm2() {
		memberRepository.findAll().stream().forEach(mem -> System.out.println(mem.getTeam().getName()));
		
		return null;
	}
	
	public Long getMemberJoinFetch() {
		memberRepository.findAllJoinFetch().stream().forEach(mem -> System.out.println(mem.getTeam().getName()));
		
		return null;
	}
	
	public Long getMemberJoin() {
		memberRepository.findAllDD().stream().forEach(mem -> System.out.println(mem.getTeam().getName()));
		
		return null;
	}
	
	public Long getMemberJoinFetch2() {
		memberRepository.findAllJoinFetch2().stream().forEach(mem -> System.out.println(mem.getTeam().getName()));
		
		return null;
	}
	
	public Long getMemberJoin2() {
		memberRepository.findAllDD2().stream().forEach(mem -> System.out.println(mem.getTeam().getName()));
		
		return null;
	}
}
