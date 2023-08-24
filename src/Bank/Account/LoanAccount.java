package Bank.Account;

// Subclass representing a loan account
public class LoanAccount extends Account implements Withdrawable,Depositable {
    private double loanAmount;

    // Constructor to initialize loan account details
    public LoanAccount(String accountNumber, double loanAmount) {
        super(accountNumber);
        this.loanAmount = loanAmount;
    }

    // Getter method to retrieve the loan amount
    public double getLoanAmount() {
        return loanAmount;
    }

    // Setter method to modify the loan amount
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("RM"+ amount + " deposited into Loan Account. New balance: RM" + getBalance());
    }

    // Override the withdraw method to prevent withdrawals from loan account
    @Override
    public void withdraw(double amount) {
        System.out.println("Cannot withdraw from Loan Account.");
    }

    // Method to calculate interest for the loan account
    public double calculateInterest() {
        // Calculate and return interest based on the loan amount (placeholder calculation)
        return loanAmount * 3.6;
    }
}
