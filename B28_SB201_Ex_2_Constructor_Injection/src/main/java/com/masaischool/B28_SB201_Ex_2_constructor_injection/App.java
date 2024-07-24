package com.masaischool.B28_SB201_Ex_2_constructor_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {Marina Beach, Tamil Nadu
    public static void main( String[] args ){
    	ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    	
    	Traveller travelOne = context.getBean("travelOne", Traveller.class);
    	Traveller travelTwo = context.getBean("travelTwo", Traveller.class);
    	Traveller travelThree = context.getBean("travelThree", Traveller.class);
    	
    	System.out.println("travelOne.vehicle = " + travelOne.vehicle + " travelOne.noOfPassengers " + travelOne.noOfPassengers);
    	System.out.println("travelTwo.vehicle = " + travelTwo.vehicle + " travelTwo.noOfPassengers " + travelTwo.noOfPassengers);
    	System.out.println("travelThree.vehicle = " + travelThree.vehicle + " travelThree.noOfPassengers " + travelThree.noOfPassengers);
    	
    }
}