package com.aswin.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class HelloWorldController {
	
	@GetMapping(path="hello-world")
	public String helloWorld() {
		return "Hello world";
	}
	
	@GetMapping(path="hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="hello-world-bean/{name}")
	public HelloWorldBean helloWorldBeanWithName(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World %s",name));
		//throw new RuntimeException("Something went wrong");
	}
}
