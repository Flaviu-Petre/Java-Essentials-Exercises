package models;

public class Electronics extends ShipmentOrder{
    //region variables
    private float dimensions;
    //endregion

    //region constructors
    public Electronics(String orderId, String origin, String destination, float weight, Customer customer, Status status, float dimensions) {
        super(orderId, origin, destination, weight, customer, status);
        this.dimensions = dimensions;
    }
    //endregion

    //region getters
    public float getDimensions() {
        return dimensions;
    }
    //endregion

    //region setters
    public void setDimensions(float dimensions) {
        this.dimensions = dimensions;
    }
    //endregion
}
