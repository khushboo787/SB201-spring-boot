package com.masaischool.B28_SB201_Ex_4_setter_injection;

public class Traveller {
	Vehicle vehicle;	//reference type
	int noOfPassengers;	//primitive type
	
	public Traveller() {
		System.out.println("Inside default constructor of class Traveller");
	}

	public Traveller(Vehicle vehicle, int noOfPassengers) {
		System.out.println("Inside parameterized constructor of class Traveller");
		this.vehicle = vehicle;
		this.noOfPassengers = noOfPassengers;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	void ride(){
		vehicle.startRide();
	}
}
