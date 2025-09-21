package models;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {
    //region variables
    private ServerSocket _serverSocket;
    private List<ClientHandler> _clientHandlers;
    private boolean _running = false;
    private int _port;
    //endregion

    //region constructors
    public Server(int port) {
        try {
            this._port = port;
            this._serverSocket = new ServerSocket(port);
            this._clientHandlers = new ArrayList<>();
            System.out.println("Server started on port: " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion

    //region methods
    @Override
    public void run() {
        try {
            _serverSocket = new ServerSocket(_port);
            _running = true;
            System.out.println("Server started on port " + _port);
            while (_running) {
                Socket clientSocket = _serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(_serverSocket.accept());
                _clientHandlers.add(clientHandler);
                clientHandler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        _running = false;
        try {
            if (_serverSocket != null)
                _serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //endregion
}
