package com.mypackage.fooddeliverysystem.entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	private int id;
	private String name;
	private List<FoodItem> menu;
	public Restaurant(int id, String name, List<FoodItem> menu) {
		super();
		this.id = id;
		this.name = name;
		this.menu = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public List<FoodItem> getMenu() {
		return menu;
	}
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", menu=" + menu + "]";
	}
	
	public void addFoodItem(FoodItem foodItem) {
		menu.add(foodItem);
	}
	
	public void removeFoodItemById(int foodItemId) {
        FoodItem itemToRemove = null;
        for (FoodItem item : menu) {
            if (item.getId() == foodItemId) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            menu.remove(itemToRemove);
            System.out.println("Item with ID " + foodItemId + " has been removed from the menu.");
        } else {
            System.out.println("Item not found in the menu.");
        }
    }

}
