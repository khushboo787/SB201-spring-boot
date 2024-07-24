package com.masaischool.B28_SB201_Ex_16_value_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ){
    	//code to instatiate the container
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	//code to get the bean of the A
    	A a = context.getBean("a", A.class);
    	//call the toString() method
    	System.out.println(a);
    }
}