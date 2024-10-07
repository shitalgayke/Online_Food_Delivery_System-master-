package com.mypackage.fooddeliverysystem.entities;

public class Customer extends User {
	
	private Cart cart;
    private String address;
	public Customer(int userId, String userName, long contactNo, String address) {
		super(userId, userName, contactNo);
		this.address = address;
		 this.cart = new Cart();
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Cart getCart() {
		return cart;
	}

	@Override
	public String toString() {
		return "Customer [cart=" + cart + ", address=" + address + "]";
	}

	
	
	
	

}
