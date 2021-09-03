package com.joo.book.springboot.springbootwebservice.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitAppliation implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println("*******************************************");
		args.getNonOptionArgs().forEach(str -> System.out.println(str));

		args.getOptionNames().forEach(str -> {
			System.out.print(str + " -- ");
			System.out.println(args.getOptionValues(str).get(0));
		});
		
		System.out.println(args.getOptionValues("name"));
	}

}
