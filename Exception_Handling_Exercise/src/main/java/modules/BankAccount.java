package modules;

public class BankAccount {
    private double _amount;

    public BankAccount() {
        this._amount = 0;
    }

    public double getAmount() {
        return _amount;
    }

    //region Methods
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        this._amount += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }

        if (amount > this._amount) {
            throw new IllegalArgumentException("Insufficient funds for withdrawal");
        }

        this._amount -= amount;
    }
    //endregion
}

