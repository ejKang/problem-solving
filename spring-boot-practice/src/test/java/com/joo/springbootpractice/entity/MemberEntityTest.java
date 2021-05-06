package com.joo.springbootpractice.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MemberEntityTest {

	@Test
	public void getId() {
		final MemberEntity member = MemberEntity.builder()
											.id("ffff")
											.name("Tom")
											.build();
		
		final String id = member.getId();
		
		assertEquals("ffff", id);
	}
	
	@Test
	public void getName() {
		final MemberEntity member = MemberEntity.builder()
										.id("ffff")
										.name("Tom")
										.build();
		final String name = member.getName();
		assertEquals("Tom", name);
	}
}
