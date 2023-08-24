package Bank.Account;

// Subclass representing a loan account
public class LoanAccount extends Account {
    private double loanAmount;

    // Constructor to initialize loan account details
    public LoanAccount(String accountNumber, double loanAmount) {
        super(accountNumber);
        this.loanAmount = loanAmount;
    }

    // Override the withdraw method to prevent withdrawals from loan account
    @Override
    public void withdraw(double amount) {
        System.out.println("Cannot withdraw from Loan Account.");
    }

    // Getter method to retrieve the loan amount
    public double getLoanAmount() {
        return loanAmount;
    }

    // Setter method to modify the loan amount
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // Method to calculate interest for the loan account
    public double calculateInterest() {
        // Calculate and return interest based on the loan amount (placeholder calculation)
        return loanAmount * 0.1;
    }
}
