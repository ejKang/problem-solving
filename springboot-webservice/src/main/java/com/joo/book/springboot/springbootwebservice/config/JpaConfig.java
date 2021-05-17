package com.joo.book.springboot.springbootwebservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaConfig { // jpa를 위한 config 생성 , @WebMvcTest는 일반적인 @Configuration은 스캔하지 않음 

}
