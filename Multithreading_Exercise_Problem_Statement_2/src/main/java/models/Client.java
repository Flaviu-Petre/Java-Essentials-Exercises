package models;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    //region variabels
    private Socket _socket;
    private PrintWriter _out;
    private BufferedReader _in;
    //endregion

    //region methods
    public void connect(String host, int port) {
        try {
            this._socket = new Socket(host, port);
            this._out = new PrintWriter(_socket.getOutputStream(), true);
            this._in = new BufferedReader(new java.io.InputStreamReader(_socket.getInputStream()));
            System.out.println("Connected to server at " + host + ":" + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message) {
        // Send message to server
        if (_out != null) {
            _out.println(message);
            System.out.println("Sent message: " + message);
        } else {
            System.err.println("Output stream is not initialized.");
        }
    }

    public String receiveMessage() {
        // Receive message from server
        String message = null;
        try {
            if (_in != null) {
                message = _in.readLine();
                System.out.println("Received message: " + message);
            } else {
                System.err.println("Input stream is not initialized.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }

    public void disconnect() {
        // Close the connection
        try {
            if (_out != null) {
                _out.close();
            }
            if (_in != null) {
                _in.close();
            }
            if (_socket != null) {
                _socket.close();
            }
            System.out.println("Disconnected from server.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

}
