package org.example;

import models.Customer;
import models.ShipmentOrder;
import models.Status;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ShipmentOrder[] orders = new ShipmentOrder[2];

        Customer customer1 = new Customer();
        customer1.setCustomerId(1);
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setEmail("vakemo3718@efpaper.com");

        Customer customer2 = new Customer();
        customer2.setCustomerId(2);
        customer2.setFirstName("Jane");
        customer2.setLastName("Smith");
        customer2.setEmail("tiagozeva@duccong.pro");

        orders[0] = new ShipmentOrder("12345", "PUNE", "GOA", 10.0f, customer1, Status.SHIPPED);
        orders[1] = new ShipmentOrder("67890", "BENGALURU", "GOA", 20.0f, customer2, Status.DELIVERED);


        for(ShipmentOrder order : orders) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Origin: " + order.getOrigin());
            System.out.println("Destination: " + order.getDestination());
            System.out.println("Weight: " + order.getWeight() + " kg");
            System.out.println("Customer ID: " + order.getCustomer().getCustomerId());
            System.out.println("Customer Name: " + order.getCustomer().getFirstName() + " " + order.getCustomer().getLastName());
            System.out.println("Status: " + order.getStatus());
            System.out.println("-----------------------------");
        }

    }
}