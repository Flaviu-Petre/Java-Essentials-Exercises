package org.example;

import javax.sql.ConnectionEventListener;
import javax.sql.PooledConnection;
import javax.sql.StatementEventListener;
import java.sql.Connection;
import java.sql.SQLException;

public class MysqlConnectionPoolDataSource {
    private String url;
    private String user;
    private String password;

    public void setURL(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public PooledConnection getPooledConnection() throws SQLException {
        return new PooledConnection() {
            @Override
            public Connection getConnection() throws SQLException {
                return null;
            }

            @Override
            public void close() throws SQLException {

            }

            @Override
            public void addConnectionEventListener(ConnectionEventListener listener) {

            }

            @Override
            public void removeConnectionEventListener(ConnectionEventListener listener) {

            }

            @Override
            public void addStatementEventListener(StatementEventListener listener) {

            }

            @Override
            public void removeStatementEventListener(StatementEventListener listener) {

            }
        };
    }
}
