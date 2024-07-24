package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "menu_items")
@Data
@AllArgsConstructor
public class MenuItems {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuItemId;

	@NotBlank
	private String name;

	@NotBlank
	private String description;

	@NotNull
	@Positive
	private double price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id", referencedColumnName = "restaurantId")
	private Restaurant restaurant;

	public MenuItems(String name, String description, double price, Restaurant restaurant) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.restaurant = restaurant;
	}

	public MenuItems() {
		super();
		// TODO Auto-generated constructor stub
	}

}
