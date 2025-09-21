package org.example;

import models.Product;
import models.ProductDao;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductDao productDao = new ProductDao();

        char option = '0';
        while(option != 'q'){
            System.out.println("Choose an option:");
            System.out.println("1. Insert Product");
            System.out.println("2. Add Stock");
            System.out.println("3. Remove Stock");
            System.out.println("4. Get Product");
            System.out.println("q. Quit");
            option = sc.next().charAt(0);

            switch (option) {
                case '1':
                    System.out.println("Insert Product");
                    Product product = new Product();
                    //read product details from user
                    System.out.println("Enter product id:");
                    product.set_productId(sc.next());

                    System.out.println("Enter product name:");
                    product.set_Name(sc.next());

                    System.out.println("Enter product stock:");
                    product.set_stock(sc.nextDouble());

                    try {
                        productDao.insertProduct(product.get_productId(), product.get_Name(), product.get_stock());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case '2':
                    System.out.println("Add Stock");
                    //read product id and amount from user
                    System.out.println("Enter product id:");
                    String productId = sc.next();

                    System.out.println("Enter amount to add:");
                    double amountToAdd = sc.nextDouble();

                    productDao.addStock(productId, amountToAdd);
                    break;
                case '3':
                    System.out.println("Remove Stock");
                    //read product id and amount from user
                    System.out.println("Enter product id:");
                    String prodId = sc.next();

                    System.out.println("Enter amount to remove:");
                    double amountToRemove = sc.nextDouble();

                    try {
                        boolean result = productDao.removeStock(prodId, amountToRemove);
                        if (result) {
                            System.out.println("Stock removed successfully.");
                        } else {
                            System.out.println("Failed to remove stock. Check if product exists and has sufficient stock.");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case '4':
                    System.out.println("Get Product");
                    //read product id from user
                    System.out.println("Enter product id:");
                    String pId = sc.next();

                    try {
                        productDao.getProduct(pId);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 'q':
                    System.out.println("Quitting...");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }
    }
}