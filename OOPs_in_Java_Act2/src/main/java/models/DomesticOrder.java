package models;

public class DomesticOrder extends ShipmentOrder{
    //region variables
    private String pincode;
    //endregion

    //region constructors
    public DomesticOrder(String orderId, String origin, String destination, float weight, Customer customer, Status status, String pincode) {
        super(orderId, origin, destination, weight, customer, status);
        this.pincode = pincode;
    }
    //endregion

    //region getters
    public String getPincode() {
        return pincode;
    }
    //endregion

    //region setters
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
    //endregion

    //region methods

    @Override
    public void generateBill() {
        System.out.println("Generating bill for domestic order: " + getOrderId() + " to pincode " + getPincode());
    }

    //endregion
}
