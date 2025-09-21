package org.example;

import modules.BankAccount;

public class Main {
    public static void main(String[] args) {
            BankAccount bankAccount = new BankAccount();
            bankAccount.deposit(500);

            try {
                bankAccount.withdraw(600); // This will throw an exception
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                bankAccount.withdraw(100); // This will succeed
                System.out.println("Withdrawal successful. Remaining balance: " + bankAccount.getAmount());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                bankAccount.deposit(-50); // This will throw an exception
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                bankAccount.deposit(200); // This will succeed
                System.out.println("Deposit successful. New balance: " + bankAccount.getAmount());
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }