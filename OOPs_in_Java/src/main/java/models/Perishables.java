package models;

public class Perishables extends ShipmentOrder {
    //region variables
    private String expirationDate;
    //endregion

    //region constructors
    public Perishables(String orderId, String origin, String destination, float weight, Customer customer, Status status, String expirationDate) {
        super(orderId, origin, destination, weight, customer, status);
        this.expirationDate = expirationDate;
    }
    //endregion

    //region getters
    public String getExpirationDate() {
        return expirationDate;
    }
    //endregion

    //region setters
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    //endregion
}
