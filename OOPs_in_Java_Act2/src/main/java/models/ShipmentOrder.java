package models;

import Interfaces.IShipmentOrderOperations;

abstract class ShipmentOrder implements IShipmentOrderOperations {
    //region variables
    private String orderId;
    private String origin;
    private String destination;
    private float weight;
    private Customer customer;
    private Status status;
    //endregion

    //region constructors
    public ShipmentOrder(String orderId, String origin, String destination, float weight, Customer customer, Status status) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.orderId = orderId;
        this.customer = customer;
        this.status = status;
    }
    //endregion

    //region getters
    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    public float getWeight() {
        return weight;
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Status getStatus() {
        return status;
    }
    //endregion

    //region setters
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    //endregion

    //region methods
    public void displayShipmentDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Origin: " + origin);
        System.out.println("Destination: " + destination);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Custumer: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("Status: " + status + "\n");
    }

    @Override
    public String toString() {
        return "ShipmentOrder{" + "origin='" + origin + '\'' + ", destination='" + destination + '\'' + ", weight="
                + weight + '}' + " Order ID: " + orderId + ", Customer: " + customer.getFirstName() + " " + customer.getLastName() + ", Status:; " + status;
    }

    public static void checkOrderStatus(Status status) {
        switch (status) {
            case BOOKED:
                System.out.println("Order is booked.");
                break;
            case SHIPPED:
                System.out.println("Order is shipped.");
                break;
            case DELIVERED:
                System.out.println("Order is delivered.");
                break;
            case CANCELLED:
                System.out.println("Order is cancelled.");
                break;
            default:
                System.out.println("Unknown status.");
                break;
        }
    }

    public abstract void generateBill();

    @Override
    public void createOrder() {
        System.out.println("Creating air shipment order with ID: " + orderId + " from " + origin + " to " + destination);
        status = Status.BOOKED;
    }

    @Override
    public void cancelOrder() {
        System.out.println("Cancelling air shipment order with ID: " + orderId);
        status = Status.CANCELLED;
    }

    @Override
    public Status getOrderStatus(){
        return this.status;
    }
    //endregion
}
