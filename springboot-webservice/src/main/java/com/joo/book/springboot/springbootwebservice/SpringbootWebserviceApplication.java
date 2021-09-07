package com.joo.book.springboot.springbootwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

import com.joo.book.springboot.springbootwebservice.event.MyEvent;

// @EnableJpaAuditing // test시 @WebMvcTest인 경우 entity가 존재하지 않아 에러 발생
@SpringBootApplication
public class SpringbootWebserviceApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext cac = SpringApplication.run(SpringbootWebserviceApplication.class, args);
		
//		cac.addApplicationListener(new ApplicationListener<MyEvent>() {
//
//			@Override
//			public void onApplicationEvent(MyEvent event) {
//				System.out.println(event.getMessage());
//			}
//			
//		});
		
//		cac.addApplicationListener((ApplicationListener<MyEvent>)event -> System.out.println(event.getMessage()));
		
		cac.publishEvent(new MyEvent(cac, "publish my event and listen"));
	}
	
	@EventListener(MyEvent.class)
	public void myEventListener() {
		
		System.out.println("@EventListener - MyEvent@");
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void exampleEventListener() {
		
		System.out.println("@EventListener - ApplicationReadyEvent@");
	}

}
