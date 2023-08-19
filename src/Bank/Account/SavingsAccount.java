package Bank.Account;

public class SavingsAccount extends Account{
    
    private double interestRate;

    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getInteresRate(){
        return interestRate;
    }

    public void setInteresRate(double interestRate){
        this.interestRate = interestRate;
    }
}
