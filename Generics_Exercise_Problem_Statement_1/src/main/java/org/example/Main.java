package org.example;

import models.Box;
import models.Shipment;

public class Main {
    public static void main(String[] args) {
        Shipment<String> stringShipment = new Shipment<>();

        Box<String> stringBox = new Box<>("Hello World");
        Box<Integer> intBox = new Box<>(42);
        Box<Double> doubleBox = new Box<>(3.14);
        Box<String> anotherStringBox = new Box<>("Java Programming");

        stringShipment.addBox(stringBox);
        stringShipment.addBox(intBox);
        stringShipment.addBox(doubleBox);
        stringShipment.addBox(anotherStringBox);

        System.out.println("Boxes in shipment: " + stringShipment.getBoxes().size());

        System.out.println("\n1. Testing with String object:");
        String testString = "Test String";
        boolean result1 = stringShipment.inspectShipment(testString);
        System.out.println("Can hold String? " + result1);

        System.out.println("\n2. Testing with Integer object:");
        Integer testInt = 100;
        boolean result2 = stringShipment.inspectShipment(testInt);
        System.out.println("Can hold Integer? " + result2);

        System.out.println("\n3. Testing with Double object:");
        Double testDouble = 2.71;
        boolean result3 = stringShipment.inspectShipment(testDouble);
        System.out.println("Can hold Double? " + result3);

        System.out.println("\n4. Testing with Boolean object:");
        Boolean testBoolean = true;
        boolean result4 = stringShipment.inspectShipment(testBoolean);
        System.out.println("Can hold Boolean? " + result4);
    }
}