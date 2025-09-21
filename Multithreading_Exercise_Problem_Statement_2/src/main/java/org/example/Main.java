package org.example;

import models.Client;
import models.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(2000);
        server.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread client1Thread = new Thread(() -> {
            try {
                Client client1 = new Client();
                client1.connect("localhost", 2000);
                client1.sendMessage("Hello from Client 1!");
                client1.sendMessage("Message 2 from Client 1");
                Thread.sleep(2000);
                client1.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread client2Thread = new Thread(() -> {
            try {
                Client client2 = new Client();
                client2.connect("localhost", 2000);
                client2.sendMessage("Hello from Client 2!");
                client2.sendMessage("Message 2 from Client 2");
                Thread.sleep(2000);
                client2.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        client1Thread.start();
        client2Thread.start();

        try {
            client1Thread.join();
            client2Thread.join();
            Thread.sleep(1000);
            server.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
