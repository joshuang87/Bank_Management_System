
import Bank.Account.CurrentAccount;
import Bank.Account.FixedDepositAccount;
import Bank.Account.LoanAccount;
import Bank.Account.SavingsAccount;
import java.util.Date;

public class App {

    public static void main(String[] args) {
        // Create instances of different types of accounts
        CurrentAccount currentAccount = new CurrentAccount("C123", 1000.0);
        SavingsAccount savingsAccount = new SavingsAccount("S456");
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("FD789", new Date());
        LoanAccount loanAccount = new LoanAccount("L987", 5000.0);

        // Deposit, withdraw, and demonstrate behavior of different accounts
        currentAccount.deposit(2000);
        currentAccount.withdraw(1500);

        savingsAccount.deposit(1000);
        savingsAccount.withdraw(500);

        fixedDepositAccount.deposit(5000);
        fixedDepositAccount.withdraw(2000);

        loanAccount.deposit(10000);
        System.out.println("Interest: " + loanAccount.calculateInterest());
    }


}
