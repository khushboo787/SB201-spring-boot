package com.masaischool.B28_SB201_Ex_20_first_springboot_web_app;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RestController = @ResponseBody + @Controller
public class HelloController {
	//http://localhost:8080/hello
	//@RequestMapping(value = "/hello") is same as
	//@RequestMapping(value = "/hello", method = RequestMethod.GET) is same as
	//@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "application/json") is same as
	//@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) is same as
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Everyone";
	}
	
	//is the port number for tomcat and localhost same?
	//localhost: name of server when client and server both are on same machine
	//localhost = 127.0.0.1
	//8080 default port number of apache tomcat
	//port number : 16 digit unsigned int value (0 - 65535)
	//IANA: Internet Assigned Number authority
	
}
