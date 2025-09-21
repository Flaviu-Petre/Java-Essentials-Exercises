package org.example;

import models.Customer;
import models.DomesticOrder;
import models.InternationalOrder;
import models.Status;

public class Main {
    public static void main(String[] args) {
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

        InternationalOrder intlOrder = new InternationalOrder("123", "CityA", "CityB", 2.5f, customer1, Status.BOOKED, "123456789");
        intlOrder.generateBill();

        System.out.println("-----------------------------------------");

        DomesticOrder domOrder = new DomesticOrder("456", "CityX", "CityY", 1.8f, customer2, Status.SHIPPED, "501512");
        domOrder.generateBill();
    }
}