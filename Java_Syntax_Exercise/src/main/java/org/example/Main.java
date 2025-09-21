package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt();

        if(input < 0){
            System.out.println("Invalid input");
            return;
        }

        System.out.print("All prime numbers up to " + input + ": ");
        int primeNumber = 0;
        while(input != primeNumber){
            if(isPrime(primeNumber)) {
                System.out.print(primeNumber + " ");
            }
            primeNumber++;
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}