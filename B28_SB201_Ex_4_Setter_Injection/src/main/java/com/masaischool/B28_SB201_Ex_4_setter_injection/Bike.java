package com.masaischool.B28_SB201_Ex_4_setter_injection;

class Bike implements Vehicle{
	public Bike() {
		System.out.println("Inside constructor of Bike");
	}
	
	void start(){
		System.out.println("You can start bike by hitting a kick or by self start");
	}
	
	@Override
	public void startRide(){
		start();
	}
}
