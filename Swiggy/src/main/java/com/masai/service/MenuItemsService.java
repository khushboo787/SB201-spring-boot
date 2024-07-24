package com.masai.service;

import java.awt.MenuItem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.NotFoundException;
import com.masai.model.MenuItems;
import com.masai.repository.MenuItemsRepository;

@Service
public class MenuItemsService {

	private final MenuItemsRepository menuItemsRepository;

	@Autowired
	public MenuItemsService(MenuItemsRepository menuItemsRepository) {
		this.menuItemsRepository = menuItemsRepository;
	}

	public MenuItems createMenuItem(MenuItems menuItem) {
		return menuItemsRepository.save(menuItem);
	}

	public MenuItems updateMenuItem(Long menuItemId, MenuItems updatedMenuItem) {
		if (!menuItemsRepository.existsById(menuItemId)) {
			throw new NotFoundException("MenuItem with ID " + menuItemId + " not found");
		}
		return menuItemsRepository.save(updatedMenuItem);
	}

	public boolean deleteMenuItem(Long menuItemId) {
		if (!menuItemsRepository.existsById(menuItemId)) {
			throw new NotFoundException("MenuItem with ID " + menuItemId + " not found");
		}
		menuItemsRepository.deleteById(menuItemId);
		return true;
	}

	public List<MenuItems> getMenuItemsByRestaurant(Long restaurantId) {
		return menuItemsRepository.findByRestaurantId(restaurantId);
	}

	public List<MenuItems> getAllMenuItems() {
		return menuItemsRepository.findAll();
	}

	public MenuItems getMenuItemById(Long menuItemId) {
		return menuItemsRepository.findById(menuItemId)
				.orElseThrow(() -> new NotFoundException("MenuItem with ID " + menuItemId + " not found"));
	}

}
