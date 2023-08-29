
/*
 Title: Bank Management System

 Fucntion
 All type account allow user deposit money into account.
 All type account can withdraw money from except
 */


import Bank.Account.CurrentAccount;
import Bank.Account.FixedDepositAccount;
import Bank.Account.LoanAccount;
import Bank.Account.SavingsAccount;
import java.util.Date;
import java.text.DecimalFormat;

public class App {

    public static void main(String[] args) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00"); //make result in two decimal
        // Create instances of different types of accounts
        CurrentAccount currentAccount = new CurrentAccount("C123", 1000.0);
        SavingsAccount savingsAccount = new SavingsAccount("S456");
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("FD789", new Date(System.currentTimeMillis() + 86400000)); //next day
        FixedDepositAccount fixedDepositAccount2 = new FixedDepositAccount("FD1289", new Date());
        LoanAccount loanAccount = new LoanAccount("L987", 45000.0,9);

        // Deposit, withdraw, and demonstrate behavior of different accounts
        System.out.println("Current Account");
        currentAccount.deposit(2000);
        currentAccount.withdraw(1500);
        System.out.println("");
        System.out.println("( if withdraw exceed overdraw limit )");
        currentAccount.withdraw(3500);
        System.out.println("-------------------------------------------------------------");
        System.out.println("");

        System.out.println("Savings Account");
        savingsAccount.deposit(1000);
        savingsAccount.withdraw(500);
        System.out.println("");
        System.out.println("Before adding interest:");
        System.out.println("Balance: RM" + savingsAccount.getBalance());

        System.out.println("\nAfter adding interest:");
        System.out.println("Interest: "+savingsAccount.getInterestRate());
        savingsAccount.addInterest();
        System.out.println("-------------------------------------------------------------");
        

        System.out.println("");
        System.out.println("Fixed Deposit Account (If withdraw before maturity Date)");
        fixedDepositAccount.deposit(5000);
        fixedDepositAccount.withdraw(2000);   //The maturity date is based on "new Date()" which is current time.
        System.out.println("");


        System.out.println("Fixed Deposit Account (If withdraw after maturity Date)");
        fixedDepositAccount2.deposit(5000);
        fixedDepositAccount2.withdraw(2000);
        System.out.println("");
        System.out.println("Before adding interest:");
        System.out.println("Balance: RM" + fixedDepositAccount2.getBalance());

        System.out.println("\nAfter adding interest:");
        System.out.println("Interest: "+fixedDepositAccount2.getInterestRate());
        fixedDepositAccount2.addInterest();// Add interest to the account
        System.out.println("-------------------------------------------------------------");
        System.out.println("");

        System.out.println("Loan Account");
        loanAccount.deposit(20000);
        loanAccount.withdraw(5000);
        System.out.println("The loan amount: RM" + loanAccount.getLoanAmount());
        System.out.println("Interest: " + loanAccount.getInterestRate());
        System.out.println("Total payment per month : RM" + decimalFormat.format(loanAccount.calculateMonthlyPayment()));
        System.out.println("Total Interest need to pay for "+ loanAccount.getYear() +" year: RM" + decimalFormat.format(loanAccount.calculateInterest()));
        System.out.println("");
    }


}
