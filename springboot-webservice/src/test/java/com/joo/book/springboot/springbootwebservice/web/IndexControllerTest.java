package com.joo.book.springboot.springbootwebservice.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.joo.book.springboot.springbootwebservice.web.dto.LoggerInfoDto;
import com.joo.book.springboot.springbootwebservice.web.dto.LoggerInstance;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private static String url = "http://localhost:8089/actuator/env";
    @Test
    public void 메인페이지_로딩() {
        String body = this.restTemplate.getForObject("/", String.class);

        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
    
    @Test
    public void ParamTypeRef_Test_Get_Object() {
        String body = this.restTemplate.getForObject(url, String.class);
        System.out.println(body);
        assertThat(body).contains("ttt");
    }
    
    @Test
	public void ParamTypeRef_Test_Exchange_String() {
		ResponseEntity<String> body = this.restTemplate.exchange(url, HttpMethod.GET, null, String.class);
		System.out.println(body.getStatusCode());
		System.out.println(body.getHeaders());
		System.out.println(body.getBody());
		assertThat(body.getBody()).contains("ttt");
	}
    
    @Test
	public void ParamTypeRef_Test_Exchange_Object() {
    	
    	String logger = "http://localhost:8089/actuator/loggers";
		ResponseEntity<LoggerInfoDto> body = 
				this.restTemplate.exchange(logger, HttpMethod.GET, null, LoggerInfoDto.class);
		System.out.println(body.getStatusCode());
		System.out.println(body.getHeaders());
//		System.out.println(.toString());
		for(String s : body.getBody().getLoggers().keySet()) {
			System.out.println(s);
		}
		
		for (LoggerInstance ins : body.getBody().getLoggers().values()) {
			System.out.println(ins.getEffectiveLevel());
		}
		System.out.println(body.getBody().getLoggers().values().toString());
		assertTrue(body.getBody().getLoggers().size() > 0);
	}
    
    @Test
	public void ParamTypeRef_Test_() {
    	
    	ParameterizedTypeReference<Map<String, Object>> RESPONSE_TYPE = 
    			new ParameterizedTypeReference<Map<String, Object>>() {};
    			
		ResponseEntity<Map<String, Object>> body = 
				this.restTemplate.exchange(url, HttpMethod.GET, null, RESPONSE_TYPE);
		System.out.println(body.getStatusCode());
		System.out.println(body.getHeaders());
		
		for(String s : body.getBody().keySet()) {
			System.out.println(s);
		}

	}
}
