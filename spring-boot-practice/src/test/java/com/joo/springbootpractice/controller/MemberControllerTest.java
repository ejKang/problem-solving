package com.joo.springbootpractice.controller;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.joo.springbootpractice.entity.MemberEntity;
import com.joo.springbootpractice.repository.MemberRepository;
import com.joo.springbootpractice.service.MemberService;
import static org.assertj.core.api.BDDAssertions.then;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
@SpringBootTest(
		properties = {
				"testId=tttt",
				"testName=Tom"
		},
		
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)

@Transactional
@AutoConfigureMockMvc
@Slf4j
public class MemberControllerTest {
	
	@Value("${testId}")
	private String testId;
	
	@Value("${testName}")
	private String testName;
	
	@Autowired
	MockMvc mvc;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private WebApplicationContext ctx;
	
	@BeforeEach()
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(ctx)
							.addFilters(new CharacterEncodingFilter("UTF-8", true))
							.alwaysDo(print())
							.build();
	}
	
	@Test
	void getMember() throws Exception {
		log.info("#### Properties Test ####");
		log.info("testId : " + testId);
		log.info("testName : " + testName);
		
		
//		log.info("**** Start : Moc MVC Test ****");
//		mvc.perform(get("/member/1"))
//				.andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//				.andExpect(jsonPath("$.id", is("tttt")))
//				.andDo(print());
//		log.info("**** End : Moc MVC Test ****");
		
		
		log.info("**** Start : TestRestTemplate Test ****");
		ResponseEntity<MemberEntity> response = restTemplate.getForEntity("/member/1", MemberEntity.class);
		then(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		then(response.getBody()).isNotNull();
		log.info("**** End : TestRestTemplate Test ****");
		
		log.info("**** Start : MockBean Test ****");
		MemberEntity member = MemberEntity.builder()
											.id("tttt")
											.name("Tom")
											.build();
		
//		BDDMockito.given(memberRepository.findById(1L)).willReturn(Optional.of(member));
		
		Optional<MemberEntity> member2 = memberService.findById(1L);
		
		if (member2.isPresent()) {
			then("tttt").isEqualTo(member2.get().getId());
			then("Tom").isEqualTo(member2.get().getName());
		}
		
		log.info("**** End : MockBean Test ****");
	}
	
}
