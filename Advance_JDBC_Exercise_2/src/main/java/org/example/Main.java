package org.example;

import models.DatabaseManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Database Connection Pool Demo ===\n");

        DatabaseManager dbManager = new DatabaseManager(2, 5);

        try {
            System.out.println("1. Creating a sample table...");
            // Create a sample table
            dbManager.performOperation(
                    "CREATE TABLE IF NOT EXISTS products (" +
                            "id SERIAL PRIMARY KEY, " +
                            "name VARCHAR(100) NOT NULL, " +
                            "price DECIMAL(10,2), " +
                            "category VARCHAR(50)" +
                            ")"
            );

            System.out.println("\n2. Inserting sample data...");
            // Insert sample data
            dbManager.performOperation(
                    "INSERT INTO products (name, price, category) VALUES (?, ?, ?)",
                    "Laptop", 999.99, "Electronics"
            );

            dbManager.performOperation(
                    "INSERT INTO products (name, price, category) VALUES (?, ?, ?)",
                    "Coffee Mug", 15.50, "Kitchen"
            );

            dbManager.performOperation(
                    "INSERT INTO products (name, price, category) VALUES (?, ?, ?)",
                    "Smartphone", 699.99, "Electronics"
            );

            System.out.println("\n3. Querying all products...");
            dbManager.performOperation("SELECT * FROM products ORDER BY id");

            System.out.println("\n4. Querying electronics only...");
            dbManager.performOperation(
                    "SELECT name, price FROM products WHERE category = ? AND price > ?",
                    "Electronics", 500.00
            );

            System.out.println("\n5. Updating a product price...");
            dbManager.performOperation(
                    "UPDATE products SET price = ? WHERE name = ?",
                    1099.99, "Laptop"
            );

            System.out.println("\n6. Showing updated data...");
            dbManager.performOperation("SELECT * FROM products WHERE name = ?", "Laptop");

            System.out.println("\n7. Demonstrating multiple concurrent operations...");
            Thread[] threads = new Thread[3];

            for (int i = 0; i < threads.length; i++) {
                final int threadNum = i + 1;
                threads[i] = new Thread(() -> {
                    System.out.println("Thread " + threadNum + " starting...");
                    dbManager.performOperation(
                            "SELECT COUNT(*) as product_count FROM products WHERE price > ?",
                            100.00
                    );
                    System.out.println("Thread " + threadNum + " completed.");
                });
            }

            for (Thread thread : threads) {
                thread.start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            System.out.println("\n8. Using specific executeUpdate method...");
            int rowsUpdated = dbManager.executeUpdate(
                    "UPDATE products SET category = ? WHERE category = ?",
                    "Tech", "Electronics"
            );

            System.out.println("\n9. Final query to show all changes...");
            dbManager.performOperation("SELECT * FROM products ORDER BY id");

            System.out.println("\n10. Cleaning up - dropping table...");
            dbManager.performOperation("DROP TABLE IF EXISTS products");

        } catch (Exception e) {
            System.err.println("Error in main method: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\n=== Shutting down DatabaseManager ===");
            dbManager.shutdown();
        }

        System.out.println("\nDemo completed successfully!");
    }
}