package com.joo.book.springboot.springbootwebservice.domain.member;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MemberRepository extends JpaRepository<Member, Long>{

	@Query("select m from Member m join fetch m.team")
	Set<Member> findAllJoinFetch();
	
	@Query("select m from Member m join m.team")
	Set<Member> findAllDD();
	
	@Query("select m from Member m join fetch m.team")
	List<Member> findAllJoinFetch2();
	
	@Query("select m from Member m join m.team")
	List<Member> findAllDD2();
}
