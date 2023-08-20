package Bank.Account;

public class SavingsAccount extends Account{
    
    private double interestRate = 0.6;
    private double balance; 

    public SavingsAccount(double interestRate, double balance) {
        this.interestRate = interestRate;
        this.balance = balance;
    }

    public double getInteresRate(){
        return interestRate;
    }

    public double getBalance(){
        return balance;
    }

    public void setInteresRate(double interestRate){
        this.interestRate = interestRate;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

}
