package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    private final ConnectionPool connectionPool;

    public DatabaseManager(int minPoolSize, int maxPoolSize) {
        this.connectionPool = new ConnectionPool(minPoolSize, maxPoolSize);
    }

    public void performOperation(String sql, Object... parameters) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = connectionPool.getConnection();

            stmt = conn.prepareStatement(sql);

            for (int i = 0; i < parameters.length; i++) {
                stmt.setObject(i + 1, parameters[i]);
            }

            if (sql.trim().toUpperCase().startsWith("SELECT")) {
                rs = stmt.executeQuery();

                var metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(metaData.getColumnName(i) + "\t");
                }
                System.out.println();

                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rs.getObject(i) + "\t");
                    }
                    System.out.println();
                }

            } else {
                int rowsAffected = stmt.executeUpdate();
                System.out.println("Operation completed. Rows affected: " + rowsAffected);
            }

        } catch (SQLException e) {
            System.err.println("Database operation failed: " + e.getMessage());
            e.printStackTrace();

            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                System.err.println("Rollback failed: " + rollbackEx.getMessage());
            }

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                System.err.println("Error closing resources: " + e.getMessage());
            }

            if (conn != null) {
                connectionPool.releaseConnection(conn);
            }
        }
    }

    public ResultSet executeQuery(String sql, Object... parameters) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = connectionPool.getConnection();
            stmt = conn.prepareStatement(sql);

            for (int i = 0; i < parameters.length; i++) {
                stmt.setObject(i + 1, parameters[i]);
            }

            return stmt.executeQuery();

        } catch (SQLException e) {
            // Clean up on error
            if (stmt != null)
                stmt.close();
            if (conn != null)
                connectionPool.releaseConnection(conn);
            throw e;
        }

    }

    public int executeUpdate(String sql, Object... parameters) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = connectionPool.getConnection();
            stmt = conn.prepareStatement(sql);

            for (int i = 0; i < parameters.length; i++) {
                stmt.setObject(i + 1, parameters[i]);
            }

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Update operation completed. Rows affected: " + rowsAffected);
            return rowsAffected;

        } catch (SQLException e) {
            System.err.println("Update operation failed: " + e.getMessage());
            e.printStackTrace();
            return -1;

        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                System.err.println("Error closing statement: " + e.getMessage());
            }

            if (conn != null) {
                connectionPool.releaseConnection(conn);
            }
        }
    }

    public void shutdown() {
        connectionPool.closeAllConnections();
        System.out.println("DatabaseManager shutdown complete.");
    }
}