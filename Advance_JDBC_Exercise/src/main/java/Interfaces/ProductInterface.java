package Interfaces;

import java.sql.SQLException;

public interface ProductInterface {
    void insertProduct(String productId, String name, double stock) throws SQLException;
    void addStock(String productId, double amount);
    boolean removeStock(String productId, double amount) throws SQLException;
    void getProduct(String productId) throws SQLException;
    void removeProduct(String productId) throws SQLException;
}
