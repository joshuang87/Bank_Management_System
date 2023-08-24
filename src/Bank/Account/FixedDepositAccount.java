package Bank.Account;
import java.util.Date;
public class FixedDepositAccount extends Account implements Withdrawable,Depositable {
    private Date maturityDate;
    private static final double interestRate = 4.2;

    // Constructor to initialize fixed deposit account details
    public FixedDepositAccount(String accountNumber, Date maturityDate) {
        super(accountNumber);
        this.maturityDate = maturityDate;
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("RM"+ amount + " deposited into Fixed Deposit Account. New balance: RM" + getBalance());
    }

    // Override the withdraw method to prevent withdrawals before maturity
    @Override
    public void withdraw(double amount) {
        Date currentDate = new Date();
        if (currentDate.before(maturityDate)) {
            System.out.println("Cannot withdraw from Fixed Deposit Account before maturity date.");
        } else {
            double newBalance = getBalance() - amount;
            if (newBalance >= 0) {
                System.out.println("RM"+ amount + " withdrawn from Fixed Deposit Account. Remaining balance: RM" + newBalance);
                setBalance(newBalance);
            } else {
                System.out.println("Insufficient funds");
            }
        }
    }

    public void addInterest() {
        Date currentDate = new Date();
        if (currentDate.after(maturityDate)) {
            double interest = getBalance() * interestRate;
            setBalance(getBalance() + interest);
            System.out.println("Interest added to Fixed Deposit Account. New balance: RM" + getBalance());
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    // Getter method to retrieve the maturity date
    public Date getMaturityDate() {
        return maturityDate;
    }

    // Setter method to modify the maturity date
    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }
}

