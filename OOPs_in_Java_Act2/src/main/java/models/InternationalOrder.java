package models;

public class InternationalOrder extends ShipmentOrder {
    //region variables
    private String countryCode;;
    //endregion

    //region constructors
    public InternationalOrder(String orderId, String origin, String destination, float weight, Customer customer, Status status, String countryCode) {
        super(orderId, origin, destination, weight, customer, status);
        this.countryCode = countryCode;
    }
    //endregion

    //region getters
    public String getCountryCode() {
        return countryCode;
    }
    //endregion

    //region setters
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    //endregion

    //region methods
    @Override
    public void generateBill() {
        System.out.println("Generating bill for international order: " + getOrderId() + " to " + getCountryCode());
    }
    //endregion
}
