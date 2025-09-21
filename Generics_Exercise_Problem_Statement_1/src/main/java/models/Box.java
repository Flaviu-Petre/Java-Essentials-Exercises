package models;

public  class Box<T> {
    //region Variables
    private T _content;
    //endregion

    //region Constructors
    public Box(T content) {
        this._content = content;
    }
    //endregion

    //region Getters And Setters
    public T getContent() {
        return _content;
    }

    public void setContent(T content) {
        this._content = content;
    }
    //endregion

    //region Methods
    public boolean inspect(Object object) {
        return (_content != null && _content.getClass().isInstance(object));
    }
    //endregion
}
