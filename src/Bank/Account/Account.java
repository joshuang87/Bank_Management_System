package Bank.Account;

public abstract class Account {
    private String accountNumber;
    private double balance;

    // Constructor to initialize account details
    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Abstract Method to deposit money into the account (to be implemented by subclasses)
    public abstract void deposit(double amount);

    // Abstract method for withdrawing money (to be implemented by subclasses)
    public abstract void withdraw(double amount);

    // Getter method to retrieve the account balance
    public double getBalance() {
        return balance;
    }

    // Setter method to modify the account balance
    protected void setBalance(double newBalance) {
        balance = newBalance;
    }

    // Getter method to retrieve the account number
    public String getAccountNumber() {
        return accountNumber;
    }
}
