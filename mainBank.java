import java.util.Scanner;
public class mainBank 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        String username, password;
        int choice;

        System.out.println("Welcome to Banknet!");
        input.nextLine();

        System.out.println("LOGIN YOUR ACCOUNT");
        System.out.print("Enter your username : ");
        username = input.nextLine();
        System.out.print("Enter your password : ");
        password = input.nextLine();

        if (username.equals("admin") && password.equals("admin")) 
        {
            System.out.println("Login successful!");
            System.out.println("Welcome to your account, " + username + "!");

            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            choice = input.nextInt();

            switch (choice) 
            {
                case 1:
                    showBalance(args);
                case 2:
                    deposit(args);
                case 3:
                    withdraw(args);
                case 4:
                    System.out.println("Thank you for using Banknet. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
        else 
        {
            System.out.println("Invalid username or password. Please try again.");
            mainBank.main(args);
        }

        input.close();
    }

    private static void showBalance (String[] args) 
    {
        //balance
    }

    private static void deposit (String[] args)
    {
        //deposit
    }

    private static void withdraw (String[] args)
    {
        //withdraw
    }
}