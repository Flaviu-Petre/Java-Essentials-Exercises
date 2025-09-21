package model;

import Interfaces.UserInterface;

import java.sql.*;

public class UserDao implements UserInterface {
    //region Fields
    private User _user;
    String _url = "jdbc:postgresql://localhost:5432/users";
    String _username = "postgres";
    String _password = "1q2w3e";
    int _rowsAffected = 0;
    //endregion

    //get the connection
    private Statement getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(_url, _username, _password);
        return connection.createStatement();
    }

    //region methods
    @Override
    public void insert(User user) {
        String user_id = user.get_id();
        String name = user.get_name();
        String email = user.get_email();

        String insertQuery = "INSERT INTO users (user_id, name, email) VALUES (" + user_id + ", '" + name + "', '" + email + "')";

        Connection connection = null;
        Statement statement = null;

        try{
            statement = getConnection();
            _rowsAffected = statement.executeUpdate(insertQuery);

            if(_rowsAffected > 0) {
                System.out.println("User inserted successfully.");
            } else {
                System.out.println("No rows affected. User not inserted.");
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if(connection != null && statement != null) {
                    connection.close();
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void update(String userId, User user) {
        String user_id = user.get_id();
        String name = user.get_name();
        String email = user.get_email();

        String updateQuery = null;

        if(user_id.equals(userId)){
            updateQuery = "UPDATE users SET name = '" + name + "', email = '" + email + "' WHERE user_id = '" + user_id + "'";
        } else {
            System.out.println("User ID does not match. Update operation aborted.");
            return;
        }

        Connection connection = null;
        Statement statement = null;

        try{
            statement = getConnection();
            _rowsAffected = statement.executeUpdate(updateQuery);

            if(_rowsAffected > 0) {
                System.out.println("User updated successfully.");
            } else {
                System.out.println("No rows affected. User not updated.");
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if(connection != null && statement != null) {
                    connection.close();
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void delete(String userId) {
        String deleteQuery = "DELETE FROM users WHERE user_id = '" + userId + "'";


        Connection connection = null;
        Statement statement = null;

        try{
            statement = getConnection();
            _rowsAffected = statement.executeUpdate(deleteQuery);

            if(_rowsAffected > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("No rows affected. User not deleted.");
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if(connection != null && statement != null) {
                    connection.close();
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void getAllUsers() {
        String selectQuery = "SELECT * FROM users";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = getConnection();
            resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String userId = resultSet.getString("user_id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("User ID: " + userId + ", Name: " + name + ", Email: " + email);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if(resultSet != null) resultSet.close();
                if(statement != null) statement.close();
                if(connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }
    //endregion
}
