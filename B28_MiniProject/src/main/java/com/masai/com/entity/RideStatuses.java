package com.masai.com.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ride_statuses")
public class RideStatuses {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ride_status_id")
	private Integer rideStatusId;

	@OneToOne
	@JoinColumn(name = "ride_id")
	private Rides ride;

	@Column(name = "status")
	private String status;

	@Column(name = "timestamp")
	private LocalDateTime timestamp;

	public RideStatuses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RideStatuses(Rides ride, String status, LocalDateTime timestamp) {
		super();
		this.ride = ride;
		this.status = status;
		this.timestamp = timestamp;
	}

	public Integer getRideStatusId() {
		return rideStatusId;
	}

	public void setRideStatusId(Integer rideStatusId) {
		this.rideStatusId = rideStatusId;
	}

	public Rides getRide() {
		return ride;
	}

	public void setRide(Rides ride) {
		this.ride = ride;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "RideStatuses [rideStatusId=" + rideStatusId + ", ride=" + ride + ", status=" + status + ", timestamp="
				+ timestamp + "]";
	}

}
