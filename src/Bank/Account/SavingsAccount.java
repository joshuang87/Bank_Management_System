package Bank.Account;


public class SavingsAccount extends Account implements Withdrawable,Depositable{
    private static final double interestRate = 0.006;

    // Constructor to initialize savings account details
    public SavingsAccount(String accountNumber) {
        super(accountNumber);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate;
        setBalance(getBalance() + interest);
        System.out.println("Interest added to Savings Account. New balance: RM" + getBalance());
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("RM"+ amount + " deposited into Savings Account. New balance: RM" + getBalance());
    }

    // Override the withdraw method to handle savings account withdrawals
    @Override
    public void withdraw(double amount) {

        double newBalance = getBalance() - amount;

        if (newBalance >= 0) {
            System.out.println("RM"+ amount + " withdrawn from Savings Account. Remaining balance: " +"RM"+  newBalance);
            setBalance(newBalance);
        } else {
            System.out.println("Insufficient funds");
        }

    }

}
