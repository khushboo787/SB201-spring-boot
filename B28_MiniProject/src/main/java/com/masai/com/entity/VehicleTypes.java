package com.masai.com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle_types")
public class VehicleTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_type_id")
	private Integer vehicleTypeId;

	@Column(name = "type_name")
	private String typeName;

	public VehicleTypes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleTypes(String typeName) {
		super();
		this.typeName = typeName;
	}

	public Integer getVehicleTypeId() {
		return vehicleTypeId;
	}

	public void setVehicleTypeId(Integer vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "VehicleTypes [vehicleTypeId=" + vehicleTypeId + ", typeName=" + typeName + "]";
	}

}
