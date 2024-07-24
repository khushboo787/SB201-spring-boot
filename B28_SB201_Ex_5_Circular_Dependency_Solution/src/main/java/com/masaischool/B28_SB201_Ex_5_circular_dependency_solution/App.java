package com.masaischool.B28_SB201_Ex_5_circular_dependency_solution;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main( String[] args ){
        //instantiate the container
    	ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    }
}

/**
* stack       heap
* |857488|   |_null_| 857488
*  b (B)      a (A) object created using default constructor ----------------- (1)
*  
* |748596|   |857488| 748596
*  a (A)      b (B) object created using parameterized constructor ----------------- (2)
*  
* |857488|   |_748596_| 857488
*  b (B)      a (A) after calling the setter method ----------------- (3)
*/