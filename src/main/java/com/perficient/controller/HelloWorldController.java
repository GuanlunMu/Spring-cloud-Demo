package com.perficient.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.rep.Greeting;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
	private final AtomicLong counter = new AtomicLong();
	
	@Value("${greeting}")
	private String value;
	
	@RequestMapping(method = RequestMethod.GET)
	public Greeting sayHello() {
		return new Greeting(counter.incrementAndGet(), "Hello " + this.value);
	}

}