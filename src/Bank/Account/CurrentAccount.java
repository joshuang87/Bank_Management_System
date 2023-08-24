package Bank.Account;

public class CurrentAccount extends Account implements Withdrawable {
    private double overdraftLimit;

    // Constructor to initialize current account details
    public CurrentAccount(String accountNumber, double overdraftLimit) {
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    // Override the withdraw method to handle overdraft and withdrawals
    @Override
    public void withdraw(double amount) {
        double newBalance = getBalance() - amount;
        if (newBalance >= -overdraftLimit) {
            System.out.println(amount + " withdrawn from Current Account. Remaining balance: " + newBalance);
            setBalance(newBalance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    // Getter method for retrieving the overdraft limit
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    // Setter method for modifying the overdraft limit
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}
