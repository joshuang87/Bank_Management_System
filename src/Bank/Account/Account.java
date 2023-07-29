package Bank.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Account {
    
    //  MYSQL DATABASE URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/bank_management_system";
    //  MYSQL USERNAME
    private static final String DB_USER = "root";
    //  MYSQL PASSWORD
    private static final String DB_PASSWORD = "";

    private String username;
    private String password;
    private double balance;

    public Account(){

    }

    public Account(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    /** 
     * Returns a connection to the database. 
     *  
     * @return a connection object 
     * @throws SQLException if a database access error occurs 
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void createAccount() {

        //  CREATE A SCANNER OBJECT 
        Scanner inputScanner = new Scanner(System.in);

        //  USERNAME INPUT
        System.out.print("Enter Your Username : ");
        String userName = inputScanner.nextLine();

        //  USER PASSWORD INPUT
        System.out.print("Enter Your Password : ");
        String userPassword = inputScanner.nextLine();

        inputScanner.close();

        try(Connection connection = getConnection()) {

            Statement statement = connection.createStatement();

            String createStatement = "INSERT INTO `users` (`name`, `password`) VALUES ('" + userName + "','" + userPassword + "')";

            int create = statement.executeUpdate(createStatement);

            if(create > 0) {
                System.out.println("Account Created");
            }
            else {
                System.out.println("Account Create Failure");
            }

            statement.close();
            connection.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }

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

    public void withdraw(double amount) {

        if(balance >= amount) {

            try(Connection connection = getConnection()) {
                
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else {

        }
    }

}
