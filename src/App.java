import java.util.Scanner;
import Bank.*;
import Bank.Account.Account;

public class App {

    public static void main(String[] args) throws Exception {

        Account account = new Account();
        Login login = new Login();
        boolean exit = false;

         Scanner inputScanner = new Scanner(System.in);

         while (!exit) {
            System.out.println("1 : Create Account ");
            System.out.println("2 : Login ");
            System.out.println("3 : Exit ");

            int answer = inputScanner.nextInt();



                 if (answer == 1) {

                    account.registerUser();

                }

                else if(answer==2){

                    login.accountValidation();

                    boolean backToMenu = true;

                    while(backToMenu){
                        System.out.println("1. Display Balance\n2. Save Money\n3. Withdraw Money\n4. Back to Menu");
                        int action = inputScanner.nextInt();

                        switch(action){
                            case 1:
                            break;

                            case 2:
                            break;

                            case 3:
                            break;

                            case 4:
                                backToMenu = false;

                            break;

                            default:
                                System.out.println("Invalid action");
                            break;
                        }
                    }

                }

                else if (answer == 3) {
                    exit = true;
                    System.out.println("Exiting the program.");
                }

                else {
                    System.out.println("Invalid choice.");
                }
            }

        // account.createAccount();
        //account.deposit(1000);

        inputScanner.close();

    }

}
