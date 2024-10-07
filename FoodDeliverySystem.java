package com.mypackage.fooddeliverysystem.application;

import com.mypackage.fooddeliverysystem.entities.*;
import com.mypackage.fooddeliverysystem.services.*;

import java.util.Scanner;

public class FoodDeliverySystem {
    static Scanner scanner = new Scanner(System.in);
    static FoodService foodService = new FoodService();
    static CustomerService customerService = new CustomerService();
    static OrderService orderService = new OrderService();
    
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    customerMenu();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void adminMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Food Item to Restaurant");
            System.out.println("3. Remove Food Item from Restaurant");
            System.out.println("4. View Restaurants and Menus");
            System.out.println("5. Add Delivery Person");
            System.out.println("6. Assign Delivery Person to Order");
            System.out.println("7. View Orders");
            System.out.println("8. Exit to Main Menu");
            System.out.print("Choose an option: ");
            int adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    addRestaurant();
                    break;
                case 2:
                    addFoodItemToRestaurant();
                    break;
                case 3:
                    removeFoodItemFromRestaurant();
                    break;
                case 4:
                    viewRestaurantsAndMenus();
                    break;
                case 5:
                    addDeliveryPerson();
                    break;
                case 6:
                    assignDeliveryPerson();
                    break;
                case 7:
                    viewOrders();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void customerMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Customer Menu ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View Food Items");
            System.out.println("3. Add Food to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. View Orders");
            System.out.println("7. Exit to Main Menu");
            System.out.print("Choose an option: ");
            int customerChoice = scanner.nextInt();

            switch (customerChoice) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    viewFoodItems();
                    break;
                case 3:
                    addFoodToCart();
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 6:
                    viewCustomerOrders();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Admin functions
    public static void addRestaurant() {
        System.out.print("Enter Restaurant ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Restaurant Name: ");
        String name = scanner.nextLine();
        Restaurant restaurant = new Restaurant(id, name, null);
        foodService.addRestaurant(restaurant);
        System.out.println("Restaurant added successfully!");
    }

    public static void addFoodItemToRestaurant() {
        System.out.print("Enter Restaurant ID: ");
        int restaurantId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Food Item ID: ");
        int foodId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Food Item Name: ");
        String foodName = scanner.nextLine();
        System.out.print("Enter Food Item Price: ");
        double price = scanner.nextDouble();
        FoodItem foodItem = new FoodItem(foodId, foodName, price);
        foodService.addFoodItemToRestaurant(restaurantId, foodItem);
        System.out.println("Food item added to restaurant.");
    }

    public static void removeFoodItemFromRestaurant() {
        System.out.print("Enter Restaurant ID: ");
        int restaurantId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Food Item ID to Remove: ");
        int foodItemId = scanner.nextInt();
        foodService.removeFoodItemFromRestaurant(restaurantId, foodItemId);
    }

    public static void viewRestaurantsAndMenus() {
        for (Restaurant restaurant : foodService.getRestaurants()) {
            System.out.println(restaurant);
           
        }
    }

    public static void addDeliveryPerson() {
        System.out.print("Enter Delivery Person ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Contact No.: ");
        long contactNo = scanner.nextLong();
        DeliveryPerson deliveryPerson = new DeliveryPerson(id, name, contactNo);
        orderService.getDeliveryPersons().add(deliveryPerson);
        System.out.println("Delivery Person added successfully!");
    }

    public static void assignDeliveryPerson() {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Delivery Person ID: ");
        int deliveryPersonId = scanner.nextInt();
        orderService.assignDeliveryPersonToOrder(orderId, deliveryPersonId);
    }

    public static void viewOrders() {
        for (Order order : orderService.getOrders()) {
            System.out.println(order);
        }
    }

    // Customer functions
    public static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int userId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Contact No.: ");
        long contactNo = scanner.nextLong();
        scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        Customer customer = new Customer(userId, username, contactNo,address);
        customerService.addCustomer(customer);
        System.out.println("Customer added successfully!");
    }

    public static void viewFoodItems() {
        viewRestaurantsAndMenus();
    }

    public static void addFoodToCart() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomer(customerId);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        System.out.print("Enter Restaurant ID: ");
        int restaurantId = scanner.nextInt();
        System.out.print("Enter Food Item ID: ");
        int foodItemId = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        Restaurant restaurant = foodService.getRestaurants().stream()
                .filter(r -> r.getId() == restaurantId)
                .findFirst()
                .orElse(null);
        if (restaurant == null) {
            System.out.println("Restaurant not found.");
            return;
        }

        FoodItem foodItem = restaurant.getMenu().stream()
                .filter(item -> item.getId() == foodItemId)
                .findFirst()
                .orElse(null);
        if (foodItem == null) {
            System.out.println("Food item not found.");
            return;
        }

        customer.getCart().addItem(foodItem, quantity);
        System.out.println("Food item added to cart.");
    }

    public static void viewCart() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomer(customerId);
        if (customer != null) {
            System.out.println(customer.getCart());
            
        } else {
            System.out.println("Customer not found.");
        }
    }

    public static void placeOrder() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        Customer customer = customerService.getCustomer(customerId);
        if (customer != null) {
            Order order = new Order(orderService.getOrders().size() + 1, customer);
            order.setItems(customer.getCart().getItems());
            orderService.getOrders().add(order);
            System.out.println("Order placed successfully! Order ID: " + order.getOrderId());
            order.setStatus("Delivered");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public static void viewCustomerOrders() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        for (Order order : orderService.getOrders()) {
            if (order.getCustomer().getUserId() == customerId) {
                System.out.println(order);
            }
        }
    }
}
