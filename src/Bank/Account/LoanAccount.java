package Bank.Account;

// Subclass representing a loan account
public class LoanAccount extends Account implements Withdrawable,Depositable {
    private double loanAmount;
    private static final double interestRate = 0.036;
    private int year;
    private int week = year * 12;

    // Constructor to initialize loan account details
    public LoanAccount(String accountNumber, double loanAmount, int year) {
        super(accountNumber);
        this.loanAmount = loanAmount;
        this.year = year;
    }

    // Getter method to retrieve the loan amount
    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getYear(){
        return year;
    }

    public int getweek(){
        return week;
    }

    public void setYear(int year){
        this.year = year;
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
        return getLoanAmount() * getInterestRate() * getYear();
    }

    public double calculateMonthlyPayment() {
        double principal = getLoanAmount();
        double annualInterestRate = getInterestRate();
        int numberOfMonths = getYear() * 12;
        double monthlyInterestRate = annualInterestRate / 12;
        double monthlyPayment = (principal + (principal * monthlyInterestRate * numberOfMonths)) / numberOfMonths;
        return monthlyPayment;
    }
}
