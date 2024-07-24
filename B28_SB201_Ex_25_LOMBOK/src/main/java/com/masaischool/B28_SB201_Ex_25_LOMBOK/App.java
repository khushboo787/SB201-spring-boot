package com.masaischool.B28_SB201_Ex_25_LOMBOK;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
    	EmployeeLombok empOne = new EmployeeLombok(1, "ABC", 7.5, "Punjab", null);
    	EmployeeLombok empTwo = new EmployeeLombok(1, "BCD", 8.5, "Punjab", Arrays.asList("Cricket", "Chess"));
    	
    	System.out.println(empOne);
    	System.out.println(empOne.equals(empTwo));	//true
    	System.out.println(empOne.hashCode());	//-1893197738 (May vary)
    	System.out.println(empTwo.hashCode());	//-1893197738 (May vary)
    	
    	System.out.println(empOne == empTwo);	//false
    }
}