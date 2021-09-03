package com.joo.book.springboot.springbootwebservice.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitCommand implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		// do somethings ..
		System.out.println("#######################################");
		for (String str : args) {
			System.out.println(str);
		}
		
	}

}
