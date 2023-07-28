import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Account {
    
    //  MYSQL DATABASE URL
    private String dBUrl = "jdbc:mysql://localhost:3306/bank_management_system";
    //  MYSQL USERNAME
    private String dBUsername = "root";
    //  MYSQL PASSWORD
    private String dBPassword = "";

    private String userName;
    private String password;

    public Account(){

    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
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

        try  {

            Class.forName("com.mysql.cj.jdbc.Driver");

            //  MAKE CONNECTION WITH MYSQL DATABASE
            Connection connection = DriverManager.getConnection(dBUrl, dBUsername, dBPassword);

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
            System.out.println(e);
        }

    }

}
