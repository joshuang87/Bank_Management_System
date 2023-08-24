package Bank.Account;
import java.util.Date;
public class FixedDepositAccount extends Account implements Withdrawable {
    private Date maturityDate;

    // Constructor to initialize fixed deposit account details
    public FixedDepositAccount(String accountNumber, Date maturityDate) {
        super(accountNumber);
        this.maturityDate = maturityDate;
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
                System.out.println(amount + " withdrawn from Fixed Deposit Account. Remaining balance: " + newBalance);
                setBalance(newBalance);
            } else {
                System.out.println("Insufficient funds");
            }
        }
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

