package com.masaischool.B28_SB201_Ex_4_setter_injection;

class Car implements Vehicle{
	
	public Car() {
		System.out.println("Inside constructor of Car");
	}

	void ignite(){
		System.out.println("you can start car by pressing clutch and rolling the key");
	}
	
	@Override
	public void startRide(){
		ignite();
	}
}
