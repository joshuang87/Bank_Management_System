package Bank.Account;

import static Bank.Account.Account.DB_URL;
import static Bank.Account.Account.DB_USER;


import java.sql.*;

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

    public void deposit(double amount) {

        balance += amount;

        try(Connection connection = getConnection()) {

            Statement statement = connection.createStatement();

            String updateStatement = "UPDATE users SET balance=" + balance + " WHERE id=1";
            
            PreparedStatement preparedStatement = connection.prepareStatement(updateStatement);

            preparedStatement.executeUpdate();

            statement.close();
            connection.close();
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
