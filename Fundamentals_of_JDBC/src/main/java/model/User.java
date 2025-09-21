package model;

public class User {
    //region Fields
    private String _id;
    private String _name;
    private String _email;
    //endregion

    //region Constructors
    public User() {
        this._id = null;
        this._name = "";
        this._email = "";
    }

    public User(String id, String name, String email) {
        this._id = id;
        this._name = name;
        this._email = email;
    }
    //endregion

    //region getters

    public String get_id() {
        return _id;
    }

    public String get_email() {
        return _email;
    }

    public String get_name() {
        return _name;
    }

    //endregion

    //region setters

    public void set_id(String _id) {
        this._id = _id;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public void set_email(String _email) {
        this._email = _email;
    }

    //endregion
}
