package Bank.Account;
import java.util.Scanner;
import java.sql.*;

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

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }
/* 
    public void createAccount() {

        //  CREATE A SCANNER OBJECT 
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Select your account type : 1.current, 2.fixed deposit, 3.saving ");
        int select = inputScanner.nextInt();
        String accountType = getAccountType(select);

        if(select == 1){
            System.out.print("Enter Your Username : ");
            String userName = inputScanner.nextLine();

            System.out.print("Enter Your Password : ");
            String userPassword = inputScanner.nextLine();

            inputScanner.close();

            try(Connection connection = getConnection()) {

                Statement statement = connection.createStatement();

                String createStatement = "INSERT INTO `users` (`userName`, `password`) VALUES ('" + userName + "','" + userPassword + "')";

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
        }*/

        public void registerUser() {
            try (Connection connection = getConnection()) {
                Scanner inputScanner = new Scanner(System.in);
                
                System.out.print("Select your account type: 1. Current Account, 2. Fixed Deposit, 3. Saving Table: ");
                int select = inputScanner.nextInt();
                String accountType = getAccountType(select);
                
                if (accountType != null) {
                    System.out.print("Enter username: ");
                    String username = inputScanner.next();
                    System.out.print("Enter password: ");
                    String password = inputScanner.next();
                    
                    // Insert into users table
                    String insertUserQuery = "INSERT INTO users (userName, password) VALUES (?, ?)";
                    PreparedStatement userStatement = connection.prepareStatement(insertUserQuery, Statement.RETURN_GENERATED_KEYS);
                    userStatement.setString(1, username);
                    userStatement.setString(2, password);
                    int affectedRows = userStatement.executeUpdate();
    
                    if (affectedRows == 0) {
                        throw new SQLException("Creating user failed, no rows affected.");
                    }
    
                    // Get the generated user ID
                    ResultSet generatedKeys = userStatement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int userId = generatedKeys.getInt(1);
                        // Insert into the selected account type table
                        String accountInsertQuery = getAccountInsertQuery(accountType);
                        if (accountInsertQuery != null) {
                            PreparedStatement accountStatement = connection.prepareStatement(accountInsertQuery);
                            accountStatement.setInt(1, userId);
                            // Set other account-specific parameters
                            int accountRowsAffected = accountStatement.executeUpdate();
                            if (accountRowsAffected == 0) {
                                throw new SQLException("Inserting into account table failed.");
                            }
                        } else {
                            throw new SQLException("Invalid account type.");
                        }
                    } else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
    
                    // Close resources
                    userStatement.close();
                    
                } else {
                    System.out.println("Invalid account type selection.");
                }
                
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
        private static String getAccountType(int selection) {
            switch (selection) {
                case 1:
                    return "CurrentAccount";
                case 2:
                    return "FixedDeposit";
                case 3:
                    return "SavingTable";
                default:
                    return null;
            }
        }
    
        private static String getAccountInsertQuery(String accountType) {
            switch (accountType) {
                case "CurrentAccount":
                    return "INSERT INTO currentaccount (user_id) VALUES (?)";
                case "SavingTable":
                    return "INSERT INTO savingaccount (user_id) VALUES (?)";
                case "FixedDeposit":
                    return "INSERT INTO fixeddepositaccount (user_id) VALUES (?)";
                default:
                    return null;
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


    public void withdraw(String username, double amount) {

        if(balance >= amount) {

            try(Connection connection = getConnection()) {

                String query = "UPDATE users SET balance = balance - ? WHERE username = ?";

                PreparedStatement statement = connection.prepareStatement(query);

                statement.setDouble(1, amount);

                statement.setString(2, username);

                statement.executeUpdate();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        else {

        }
    }

}
