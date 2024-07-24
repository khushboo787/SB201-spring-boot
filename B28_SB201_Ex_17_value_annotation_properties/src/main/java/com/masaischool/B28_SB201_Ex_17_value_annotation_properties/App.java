package com.masaischool.B28_SB201_Ex_17_value_annotation_properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main( String[] args ){
    	//code to instantiate the container
    	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	//code to get the bean of the A
    	A a = context.getBean("a", A.class);
    	//call the toString() method
    	System.out.println(a);
    	
    	//if you are making changes in the properties file then you have to restart the application
    	//to view the changes because at the start all properties from properties file is
    	//read by the container so for new properties/changes it is mandatory to start application again
    }
}