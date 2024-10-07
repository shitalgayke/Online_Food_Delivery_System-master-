package com.mypackage.fooddeliverysystem.services;

import java.util.ArrayList;
import java.util.List;

import com.mypackage.fooddeliverysystem.entities.DeliveryPerson;
import com.mypackage.fooddeliverysystem.entities.Order;

public class OrderService {
	
	private List<Order> orders = new ArrayList<>();
	private List<DeliveryPerson> deliveryPersons = new ArrayList<>();
	
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<DeliveryPerson> getDeliveryPersons() {
		return deliveryPersons;
	}
	public void setDeliveryPersons(List<DeliveryPerson> deliveryPersons) {
		this.deliveryPersons = deliveryPersons;
	}
	
	public void assignDeliveryPersonToOrder(int orderId, int deliveryPersonId) {
		
		Order orderToAssign = null;
		
		for(Order order : orders) {
			
			if(order.getOrderId() == orderId) {
				orderToAssign = order;
				break;
			}
		}
		
		if(orderToAssign == null) {
			System.out.println("Order not found with ID:" + orderId);
			return;
		}
		
		DeliveryPerson deliveryPersonToAssign = null;
		
		for(DeliveryPerson deliveryPerson : deliveryPersons) {
			
			if(deliveryPerson.getDeliveryPersonId() == deliveryPersonId) {
				deliveryPersonToAssign = deliveryPerson;
				break;
			}
		}
		
		if(deliveryPersonToAssign == null) {
			System.out.println("Delivery Person not found with ID:" + deliveryPersonId);
			return;
		}
		
		orderToAssign.setDeliveryPerson(deliveryPersonToAssign);
		System.out.println("Delivery person " + deliveryPersonId + " assigned to order " + orderId);
		
	}
	

}
