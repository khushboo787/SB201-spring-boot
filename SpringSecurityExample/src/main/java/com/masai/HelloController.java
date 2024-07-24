package com.masai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/simple")
	public String simpleHello(){
		return "Hello";
	}
}
