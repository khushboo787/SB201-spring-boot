package com.masai.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicles")
public class Vehicles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	private Integer vehicleId;

	@ManyToOne
	@JoinColumn(name = "vehicle_type_id")
	private VehicleTypes vehicleType;

	@Column(name = "make")
	private String make;

	@Column(name = "model")
	private String model;

	@Column(name = "license_plate")
	private String licensePlate;

	public Vehicles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicles(VehicleTypes vehicleType, String make, String model, String licensePlate) {
		super();
		this.vehicleType = vehicleType;
		this.make = make;
		this.model = model;
		this.licensePlate = licensePlate;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public VehicleTypes getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleTypes vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public String toString() {
		return "Vehicles [vehicleId=" + vehicleId + ", vehicleType=" + vehicleType + ", make=" + make + ", model="
				+ model + ", licensePlate=" + licensePlate + "]";
	}

}
