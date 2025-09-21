package org.example;

import models.Person;
import models.ReflectionUtil;

public class Main {
    public static void main(String[] args) {
        ReflectionUtil reflectionUtil = new ReflectionUtil();
        Person person = new Person();

        person.setName("John Doe");
        person.setAge(30);

        System.out.println("Details of the fields person object: ");
        ReflectionUtil.printFieldNamesAndValues(person);

        System.out.println("Invoking private method:");
        ReflectionUtil.invokePrivateMethod(person, "displayInfo");
        ReflectionUtil.invokePrivateMethod(person, "displayInfoWithAdditionalInfo", "This is additional information");
        ReflectionUtil.invokePrivateMethod(person, "sayHello");
    }
}