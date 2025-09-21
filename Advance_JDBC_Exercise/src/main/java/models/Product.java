package models;

public class Product {
    //region Fiedls
    private String _productId;
    private String _Name;
    private double _stock;
    //endregion

    //region Constructors
    public Product() {
        this._productId = "";
        this._Name = "";
        this._stock = 0;
    }

    public Product(String productId, String name, double stock) {
        this._productId = productId;
        this._Name = name;
        this._stock = stock;
    }
    //endregion

    //region Getters

    public String get_productId() {
        return _productId;
    }

    public String get_Name() {
        return _Name;
    }

    public double get_stock() {
        return _stock;
    }

    //endregion

    //region Setters

    public void set_productId(String _productId) {
        this._productId = _productId;
    }

    public void set_stock(double _stock) {
        this._stock = _stock;
    }

    public void set_Name(String _Name) {
        this._Name = _Name;
    }

    //endregion


}
