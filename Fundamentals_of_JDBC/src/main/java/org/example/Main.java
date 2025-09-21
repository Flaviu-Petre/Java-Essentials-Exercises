package org.example;

import model.Car;
import model.Test;
import model.TestException;
import model.Vehicle;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
//        model.User user1 = new model.User("1", "John Doe", "john@example.com");
//        model.User user2 = new model.User("2", "Jane Smith", "jane@example.com");
//
//        model.UserDao userDao = new model.UserDao();
//        userDao.insert(user1);
//        userDao.insert(user2);
//
//        user1.set_name("Johnathan Doe");
//        userDao.update("1", user1);
//
//        userDao.getAllUsers();
//
//        userDao.delete("2");
//
//        userDao.getAllUsers();
//
//        System.out.println("Operations completed successfully.");
        String str1 = "Hello, World!";
        String str2 = new String("Hello, World!");
        String str3 = str1;
        String str4 = "Hello, " + "World!";
        String str5 = str1.substring(0, 5);

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println(str1 == str5 + ", World!");
    }
}





