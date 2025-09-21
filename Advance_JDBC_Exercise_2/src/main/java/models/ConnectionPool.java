package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Set;

public class ConnectionPool {
    //region fileds
    private final int maxPoolSize;
    private final int minPoolSize;
    private final DatabaseConnection databaseConnection;
    private final BlockingQueue<Object> availableConnections;
    private final Set<Connection> connectionsInUse;
    //endregion

    //region constructor
    public ConnectionPool(int maxPoolSize, int minPoolSize) {
        this.minPoolSize = minPoolSize;
        this.maxPoolSize = maxPoolSize;
        this.databaseConnection = new DatabaseConnection();
        this.availableConnections = new LinkedBlockingQueue<>(maxPoolSize);
        this.connectionsInUse = ConcurrentHashMap.newKeySet();

        initializePool();
    }
    //endregion

    //region methods
    private void initializePool() {
        for (int i = 0; i < minPoolSize; i++) {
            try {
                Connection conn = databaseConnection.getConnection();
                availableConnections.offer(conn);
            } catch (SQLException e) {
                System.err.println("Failed to initialize connection pool: " + e.getMessage());
            }
        }
    }

    public Connection getConnection() throws SQLException {
        Connection connection = (Connection) availableConnections.poll();

        if (connection == null && getTotalConnections() < maxPoolSize) {
            connection = databaseConnection.getConnection();
        }

        if (connection == null) {
            throw new SQLException("Connection pool exhausted. Maximum pool size reached.");
        }

        try {
            if (connection.isClosed() || !connection.isValid(5)) {
                connection = databaseConnection.getConnection();
            }
        } catch (SQLException e) {
            connection = databaseConnection.getConnection();
        }

        connectionsInUse.add(connection);
        return connection;
    }

    public void releaseConnection(Connection connection) {
        if (connection == null) {
            return;
        }

        connectionsInUse.remove(connection);

        try {
            // Only return to pool if connection is still valid and we need it
            if (!connection.isClosed() && connection.isValid(5)) {
                if (availableConnections.size() < minPoolSize) {
                    availableConnections.offer(connection);
                } else {
                    // Pool has enough connections, close this one
                    databaseConnection.closeConnection(connection);
                }
            } else {
                // Connection is invalid, close it
                databaseConnection.closeConnection(connection);
            }
        } catch (SQLException e) {
            // If there's an error, just close the connection
            databaseConnection.closeConnection(connection);
        }
    }

    private int getTotalConnections() {
        return availableConnections.size() + connectionsInUse.size();
    }

    public void closeAllConnections() {
        Connection conn;
        while ((conn = (Connection) availableConnections.poll()) != null) {
            databaseConnection.closeConnection(conn);
        }

        for (Connection connection : connectionsInUse) {
            databaseConnection.closeConnection(connection);
        }
        connectionsInUse.clear();
    }

    public int getAvailableConnectionsCount() {
        return availableConnections.size();
    }

    public int getConnectionsInUseCount() {
        return connectionsInUse.size();
    }



}

