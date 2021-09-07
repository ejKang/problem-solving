package com.joo.book.springboot.springbootwebservice.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {

	private static final long serialVersionUID = 3782085719878610007L;
	
	private final String msg;
	
	public MyEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}
	
	public String getMessage() {
		return this.msg;
	}

}
