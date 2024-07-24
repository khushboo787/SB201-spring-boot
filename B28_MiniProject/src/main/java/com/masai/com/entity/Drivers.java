package com.masai.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "drivers")
public class Drivers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "driver_id")
	private Integer driverId;

	@OneToOne
	@JoinColumn(name = "user_id")
	private Users user;

	@OneToOne
	@JoinColumn(name = "vehicle_id")
	private Vehicles vehicle;

	public Drivers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drivers(Users user, Vehicles vehicle) {
		super();
		this.user = user;
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Drivers [driverId=" + driverId + ", user=" + user + ", vehicle=" + vehicle + "]";
	}

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Vehicles getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicles vehicle) {
		this.vehicle = vehicle;
	}

}
