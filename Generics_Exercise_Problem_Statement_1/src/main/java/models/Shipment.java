package models;

import java.util.ArrayList;
import java.util.List;

public class Shipment<T>{
    //region Variables
    private List<Box<T>> _boxes;
    //endregion

    //region Constructors
    public Shipment() {
        this._boxes = new ArrayList<Box<T>>();
    }
    //endregion

    //region Getters And Setters
    public List<Box<T>> getBoxes() {
        return _boxes;
    }

    public void setBoxes(List<Box<T>> boxes) {
        this._boxes = boxes;
    }
    //endregion

    //region Methods
    public void addBox(Box box) {
        _boxes.add(box);
    }

    public boolean removeBox(Box box) {
        return _boxes.remove(box);
    }

    public <E> boolean inspectShipment(E object) {
        for (Box<T> box : _boxes) {
            if (box.inspect(object)) {
                return true;
            }
        }
        return false;
    }
    //endregion

}
