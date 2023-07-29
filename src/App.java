import java.util.Scanner;
import Bank.*;
import Bank.Account.Account;

public class App {

    public static void main(String[] args) throws Exception {

        Account account = new Account();
        Login login = new Login();

        // Scanner inputScanner = new Scanner(System.in);
        // System.out.println("1 : Create Account ");        
        // System.out.println("2 : Login ");

        // int answer = inputScanner.nextInt();

        // if(answer == 1) {
        //     account.createAccount();
        // }
        // else if(answer == 2) {
            
        // }
        // else {
        //     System.out.println("Invalid Input");
        // }

        // login.accountValidation();

        // account.createAccount();
        account.deposit(1000);

    }


}
