package Bank.Account;

public class CurrentAccount extends Account implements Withdrawable, Depositable {
    private double overdraftLimit;

    // Constructor to initialize current account details
    public CurrentAccount(String accountNumber, double overdraftLimit) {
        super(accountNumber);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("RM"+ amount + " deposited into Current Account. New balance: RM" + getBalance());
    }

    // Override the withdraw method to handle overdraft and withdrawals
    @Override
    public void withdraw(double amount) {
        double newBalance = getBalance() - amount;
        if (newBalance >= -overdraftLimit) {
            System.out.println("RM"+ amount + " withdrawn from Current Account. Remaining balance: " +"RM"+  newBalance);
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
