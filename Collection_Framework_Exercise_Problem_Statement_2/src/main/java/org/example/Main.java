package org.example;

import com.sun.source.doctree.SystemPropertyTree;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 5; i >= 0; i--)
            numbers.add(i);

//        System.out.println("Initial list: " + numbers);
//        removeNumbers(numbers);

//        checkNumberExists(numbers);

        numbers.sort(Integer::compareTo);
        System.out.println("Sorted list: " + numbers);
    }

    public static void removeNumbers(ArrayList<Integer> numbers) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index to remove (0-5): ");
        boolean removed = false;
        while (!removed) {
            int index = sc.nextInt();
            if (index >= 0 && index < numbers.size()) {
                numbers.remove(index);
                System.out.println("Updated list: " + numbers);
                removed = true;
            } else {
                System.out.println("Invalid index. Please enter a number between 0 and 5.");
                System.out.print("Enter index to remove (0-5): ");
            }
        }
    }

    public static boolean checkNumberExists(ArrayList<Integer> numbers) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index to check if number exists: ");
        int number = sc.nextInt();
        if(numbers.contains(number))
        {
            System.out.println("Number " + number + " exists in the list.");
            return true;
        } else {
            System.out.println("Number " + number + " does not exist in the list.");
            return false;
        }
    }
}