package org.example;

import models.Pair;
import models.PaymentService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Pair <String, Integer> pair = new Pair<>();

        pair.set_first("Hello");
        pair.set_second(42);

        System.out.println("First: " + pair.get_first());
        System.out.println("Second: " + pair.get_second());

        Pair<ArrayList<Integer>, ArrayList<String>> pair2 = new Pair<>(
                new ArrayList<>(List.of(1, 2, 3)),
                new ArrayList<>(List.of("One", "Two", "Three"))
        );;

        Pair<ArrayList<Integer>, ArrayList<String>> pair4 = new Pair<>(
                new ArrayList<>(List.of(5, 6, 7)),
                new ArrayList<>(List.of("Ceva", "Poate", "Cumva"))
        );;

        Pair<HashMap<String, Integer>, HashSet<Integer>> pair3 = new Pair<>(
                new HashMap<>(Map.of("One", 1, "Two", 2, "Three", 3)),
                new HashSet<>(Set.of(1, 2, 3, 4, 5))
        );

        System.out.println("Pair 2 before swap:");
        pair2.printPair();

        System.out.println("Pair 4 before swap:");
        pair4.printPair();

        pair2.swapElemnents(pair4);

        System.out.println("Pair 2 after swap:");
        pair2.printPair();

        System.out.println("Pair 4 after swap:");
        pair4.printPair();


        Thread ps = new PaymentService("Thread 1");
        ps.setPriority(7);
        System.out.println(ps.getPriority());
        ps.setDaemon(true);
        ps.start();
        Thread ps1 = new PaymentService("Thread 2");
        ps1.setPriority(Thread.MAX_PRIORITY);
        ps1.start();

    }
}