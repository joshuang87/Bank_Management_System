package Bank.Account;


public class SavingsAccount extends Account implements Withdrawable {
    // Constructor to initialize savings account details
    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    // Override the withdraw method to handle savings account withdrawals
    @Override
    public void withdraw(double amount) {

        double newBalance = getBalance() - amount;

        if (newBalance >= 0) {
            System.out.println(amount + " withdrawn from Savings Account. Remaining balance: " + newBalance);
            setBalance(newBalance);
        } else {
            System.out.println("Insufficient funds");
        }

    }

}
