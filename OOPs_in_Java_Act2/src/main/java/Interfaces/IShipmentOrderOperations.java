package Interfaces;

import models.Status;

public interface IShipmentOrderOperations {
    void createOrder();
    void cancelOrder();
    Status getOrderStatus();
}
