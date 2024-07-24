package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.MenuItems;
import com.masai.service.MenuItemsService;

import jakarta.validation.Valid;

@RestController
@Validated
@CrossOrigin
public class MenuItemsController {

    private final MenuItemsService menuItemsService;

    @Autowired
    public MenuItemsController(MenuItemsService menuItemsService) {
        this.menuItemsService = menuItemsService;
    }
    @GetMapping("/menuitems")
    public List<MenuItems> getAllMenuItems() {
        return menuItemsService.getAllMenuItems();
    }

    @GetMapping("/menuitems/{id}")
    public ResponseEntity<MenuItems> getMenuItemsById(@PathVariable Long id) {
        MenuItems menuItems = menuItemsService.getMenuItemById(id);
        if (menuItems != null) {
            return ResponseEntity.ok(menuItems);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/menuitems/restaurant/{restaurantId}")
    public ResponseEntity<List<MenuItems>> getMenuItemsByRestaurant(@PathVariable Long restaurantId) {
        List<MenuItems> menuItemsList = menuItemsService.getMenuItemsByRestaurant(restaurantId);
        return ResponseEntity.ok(menuItemsList);
    }

    @PostMapping
    public ResponseEntity<MenuItems> createMenuItems(@Valid @RequestBody MenuItems menuItems) {
        MenuItems createdMenuItems = menuItemsService.createMenuItem(menuItems);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMenuItems);
    }

    @PutMapping("/menuitems/{id}")
    public ResponseEntity<MenuItems> updateMenuItems(@PathVariable Long id, @Valid @RequestBody MenuItems menuItems) {
        MenuItems updatedMenuItems = menuItemsService.updateMenuItem(id, menuItems);
        if (updatedMenuItems != null) {
            return ResponseEntity.ok(updatedMenuItems);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/menuitems/{id}")
    public ResponseEntity<Void> deleteMenuItems(@PathVariable Long id) {
        boolean deleted = menuItemsService.deleteMenuItem(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
