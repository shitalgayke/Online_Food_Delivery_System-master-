package com.mypackage.fooddeliverysystem.entities;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private Map<FoodItem, Integer> items;

	public Cart() {
		items = new HashMap<>();
	}
	
	public void addItem(FoodItem foodItem, int quantity) {
		
		if(items.containsKey(foodItem))
			items.put(foodItem, items.get(foodItem) + quantity);
		else
			items.put(foodItem, quantity);
		
	}
	
	
	public void removeItem(FoodItem foodItem, int quantity) {
		
		items.remove(foodItem);
		
	}
	
	 public Map<FoodItem, Integer> getItems() {
	        return items;
	 }

	 @Override
	 public String toString() {
	     StringBuilder cartContents = new StringBuilder("Cart Contents:\n");
	     double totalCost = 0; 

	     for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
	         FoodItem item = entry.getKey();
	         int quantity = entry.getValue();
	         double cost = item.getPrice() * quantity;  // Calculate the cost for the item
	         totalCost += cost;
	         
	         cartContents.append(item.getName())
	                     .append(" - Quantity: ")
	                     .append(quantity)
	                     .append(" - Price per item: Rs. ")
	                     .append(item.getPrice())
	                     .append(" - Total Cost: Rs. ")
	                     .append(cost)
	                     .append("\n");
	     }

	     cartContents.append("\nTotal Price: Rs. ").append(totalCost);  
	     return cartContents.toString();
	 }

}

	

	
	 

