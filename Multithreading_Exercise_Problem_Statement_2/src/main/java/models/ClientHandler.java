package models;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    //region variables
    private Socket _clientSocket;
    private BufferedReader _in;
    private PrintWriter _out;
    //endregion

    //region constructors
    public ClientHandler(Socket clientSocket) {
        this._clientSocket = clientSocket;
    }
    //endregion

    //region methods
    @Override
    public void run() {
        try {
            System.out.println("Client connected: " + _clientSocket.getInetAddress());
            _in = new BufferedReader(new InputStreamReader(_clientSocket.getInputStream()));
            _out = new PrintWriter(_clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = _in.readLine()) != null) {
                // Process client message
                // Send response back
                System.out.println("Received from client: " + inputLine);
                _out.println("Echo: " + inputLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (_in != null) {
                    _in.close();
                }
                if (_out != null) {
                    _out.close();
                }
                if (_clientSocket != null) {
                    _clientSocket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Client disconnected: " + _clientSocket.getInetAddress());
        }
    }
    //endregion
}
