package com.masaischool.B28_SB201_Ex_3_circular_dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ){
        //instantiate the container
    	ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    }
}