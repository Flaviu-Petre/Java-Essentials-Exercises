package models;

public class PaymentService extends Thread{
    private String _name;

    public PaymentService(String name){
        this._name = name;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String name) {
        this._name = name;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

}

