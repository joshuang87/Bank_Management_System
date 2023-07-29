package Bank;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {

    //  MYSQL DATABASE URL
    private String dBUrl = "jdbc:mysql://localhost:3306/bank_management_system";
    //  MYSQL USERNAME
    private String dBUsername = "root";
    //  MYSQL PASSWORD
    private String dBPassword = "";

    public Login() {

    }

    public void accountValidation() {

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

            String checkUsername = "SELECT * FROM users WHERE name='" + userName + "'";
            String checkPassword = "SELECT * FROM users WHERE password='" + userPassword + "'";

            ResultSet usernameSet = statement.executeQuery(checkUsername);

            if (usernameSet.next()) {

                ResultSet passwordSet = statement.executeQuery(checkPassword);

                if (passwordSet.next()) {

                    System.out.println("You Are Login Successfully");

                } else {

                    System.out.println("Login Failure");
                }

                passwordSet.close();

            }
            else {
                System.out.println("Login Failure");
            }

            usernameSet.close();
            statement.close();
            connection.close();

        }
        catch(Exception e) {
            System.out.println(e);
        }

    }

}
