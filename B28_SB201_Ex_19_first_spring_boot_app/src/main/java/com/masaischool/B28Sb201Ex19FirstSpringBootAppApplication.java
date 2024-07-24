package com.masaischool;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.masaischool.demo.A;

//uncomment this to see name of class used to initialize the Container --- (1)
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.beans.BeansException;


@SpringBootApplication
public class B28Sb201Ex19FirstSpringBootAppApplication{
//uncomment this also to see name of class used to initialize the Container --- (2)
//public class B28Sb201Ex19FirstSpringBootAppApplication implements ApplicationContextAware {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(B28Sb201Ex19FirstSpringBootAppApplication.class, args);
		A a = context.getBean("a", A.class);
		a.fun();
	}

	//uncomment this also to see name of class used to initialize the Container --- (3)
//	@Override
//	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		System.out.println(applicationContext.getClass().getName());
//	}
}
