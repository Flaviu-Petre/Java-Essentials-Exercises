package models;

import Interfaces.ProductInterface;

import java.sql.*;

public class ProductDao implements ProductInterface {
    //region Fields
    private Product _product;
    String _url = "jdbc:postgresql://localhost:5432/ProductDB";
    String _username = "postgres";
    String _password = "1q2w3e";
    int _rowsAffected = 0;
    //endregion

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(_url, _username, _password);
    }

    @Override
    public void insertProduct(String productId, String name, double stock) throws SQLException {
        String insertQuery = "INSERT INTO products (product_id, name, stock) VALUES (?, ?, ?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, productId);
            preparedStatement.setString(2, name);
            preparedStatement.setDouble(3, stock);

            _rowsAffected = preparedStatement.executeUpdate();

            if (_rowsAffected > 0) {
                System.out.println("Product inserted successfully.");
            } else {
                System.out.println("No rows affected. Product not inserted.");
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null && preparedStatement != null) {
                    connection.close();
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    //region methods
    @Override
    public void addStock(String productId, double amount) {
        // Use PreparedStatement to prevent SQL injection
        String updateQuery = "UPDATE products SET stock = stock + ? WHERE product_id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDouble(1, amount);
            preparedStatement.setString(2, productId);

            _rowsAffected = preparedStatement.executeUpdate();

            if (_rowsAffected > 0) {
                System.out.println("Stock updated successfully.");
            } else {
                System.out.println("No rows affected. Stock not updated.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating stock: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    @Override
    public boolean removeStock(String productId, double amount) throws SQLException {
        Connection connection = null;
        PreparedStatement updateStmt = null;

        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            String updateQuery = "UPDATE products SET stock = stock - ? WHERE product_id = ? AND stock >= ?";
            updateStmt = connection.prepareStatement(updateQuery);
            updateStmt.setDouble(1, amount);
            updateStmt.setString(2, productId);
            updateStmt.setDouble(3, amount);

            int rowsAffected = updateStmt.executeUpdate();

            if (rowsAffected > 0) {
                connection.commit();
                System.out.println("Stock reduced successfully. Amount reduced: " + amount);
                return true;
            } else {
                connection.rollback();
                System.out.println("Stock reduction failed. Either product not found or insufficient stock.");
                return false;
            }

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back due to error: " + e.getMessage());
                } catch (SQLException rollbackEx) {
                    System.out.println("Error during rollback: " + rollbackEx.getMessage());
                }
            }
            throw e;

        } finally {
            try {
                if (updateStmt != null) updateStmt.close();
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    @Override
    public void getProduct(String productId) throws SQLException {
        String selectQuery = "SELECT * FROM products WHERE product_id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setString(1, productId);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                double stock = resultSet.getDouble("stock");

                _product = new Product(productId, name, stock);
                System.out.println("Product ID: " + _product.get_productId());
                System.out.println("Name: " + _product.get_Name());
                System.out.println("Stock: " + _product.get_stock());
            } else {
                System.out.println("Product not found.");
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null && preparedStatement != null && resultSet != null) {
                    connection.close();
                    preparedStatement.close();
                    resultSet.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void removeProduct(String productId) throws SQLException {
        String deleteQuery = "DELETE FROM products WHERE product_id = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, productId);

            _rowsAffected = preparedStatement.executeUpdate();

            if (_rowsAffected > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("No rows affected. Product not deleted.");
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (connection != null && preparedStatement != null) {
                    connection.close();
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    //endregion
}
