package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.model.MenuItems;

@Repository
public interface MenuItemsRepository extends JpaRepository<MenuItems, Long> {
	@Query("SELECT mi FROM MenuItems mi WHERE mi.restaurant.id = :restaurantId")
	List<MenuItems> findByRestaurantId(@Param("restaurantId") Long restaurantId);
}
