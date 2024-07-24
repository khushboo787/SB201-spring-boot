package com.masai.com.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rides")
public class Rides {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ride_id")
	private Integer rideId;

	@ManyToOne
	@JoinColumn(name = "rider_id")
	private Users rider;

	@ManyToOne
	@JoinColumn(name = "driver_id")
	private Drivers driver;

	@Column(name = "pickup_location")
	private String pickupLocation;

	@Column(name = "dropoff_location")
	private String dropoffLocation;

	@Column(name = "pickup_time")
	private LocalDateTime pickupTime;

	public Rides() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rides(Users rider, Drivers driver, String pickupLocation, String dropoffLocation, LocalDateTime pickupTime) {
		super();
		this.rider = rider;
		this.driver = driver;
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;
		this.pickupTime = pickupTime;
	}

	public Integer getRideId() {
		return rideId;
	}

	public void setRideId(Integer rideId) {
		this.rideId = rideId;
	}

	public Users getRider() {
		return rider;
	}

	public void setRider(Users rider) {
		this.rider = rider;
	}

	public Drivers getDriver() {
		return driver;
	}

	public void setDriver(Drivers driver) {
		this.driver = driver;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropoffLocation() {
		return dropoffLocation;
	}

	public void setDropoffLocation(String dropoffLocation) {
		this.dropoffLocation = dropoffLocation;
	}

	public LocalDateTime getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(LocalDateTime pickupTime) {
		this.pickupTime = pickupTime;
	}

	@Override
	public String toString() {
		return "Rides [rideId=" + rideId + ", rider=" + rider + ", driver=" + driver + ", pickupLocation="
				+ pickupLocation + ", dropoffLocation=" + dropoffLocation + ", pickupTime=" + pickupTime + "]";
	}

}
