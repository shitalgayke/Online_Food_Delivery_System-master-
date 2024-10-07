package com.mypackage.fooddeliverysystem.services;

import java.util.ArrayList;
import java.util.List;

import com.mypackage.fooddeliverysystem.entities.Customer;

public class CustomerService {
	
	private List<Customer> customerList = new ArrayList<>();
	
	public void addCustomer(Customer customer) {
		customerList.add(customer);
	}
	
	public Customer getCustomer(int userId) {
		
		for(Customer customer : customerList) {
			if(customer.getUserId() == userId) {
				return customer;
			}
		}
		
		return null;
		
	}
	
	public List<Customer> getCustomers(){
		return customerList;
	}

}
