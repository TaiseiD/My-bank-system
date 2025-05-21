import java.util.Scanner;
public class mainBank 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        int choice;
        Double balance = 100000.00;
        
        String username = "admin";
        String password = "admin";
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("WELCOME TO BANKNET ");
            input.nextLine();
            System.out.print("Enter username: ");
            String inputUser = input.next();
            System.out.print("Enter password: ");
            String inputPass = input.next();

            if (!username.equals(inputUser) || !password.equals(inputPass)) {
            System.out.println("Invalid credentials. Try again.\n");
            } else {
            System.out.println("");
            System.out.println("Login successful!\n");
            loggedIn = true;
            }
        }
            while (true)
            {
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Please select an option: ");
                choice = input.nextInt();

                switch (choice) 
                {
                    case 1:
                        showBalance(balance);
                        continue;
                    case 2:
                        deposit(balance);
                        continue;
                    case 3:
                        withdraw(balance);
                        continue;
                    case 4:
                        System.out.println("Thank you for using Banknet. Goodbye!");
                        System.exit(choice);
                    default:
                        System.out.println("Invalid choice. Exiting...");
                        System.exit(choice);
                }
                input.close();
            }
    }

    private static void showBalance(Double balance) 
    {
        System.out.println("");
        System.out.println("Your current balance is PHP " + balance);
        System.out.println("");
    }

    private static double deposit (Double balance)
    {
        Scanner depositInput = new Scanner(System.in);
        double depositAmount;

         while(true)
        {
            System.out.println("");
            System.out.print("Enter amount to deposit: PHP ");
            depositAmount = depositInput.nextDouble();

            if (depositAmount >= 0)
            {
                balance += depositAmount;
                System.out.println("");
                System.out.println("Deposit successful! Your new balance is PHP " + balance);
                System.out.println("");
                break;
            }
            else
            {
                System.out.println("");
                System.out.println("Enter a valid amount to deposit");
                System.out.println("");
            }
        }
        return balance;
    }

    private static double withdraw (Double balance)
    {
        Scanner withdrawInput = new Scanner (System.in);
        Double withdrawAmount;

        while (true)
        {

            System.out.print("Please Enter Amount To Withdraw : ");
            withdrawAmount = withdrawInput.nextDouble();

            if (withdrawAmount > balance) 
            {
                System.out.println("Invalid Amount");
            } 
            else 
            {
                System.out.println("Withdrawal Sucessful");
                balance -= withdrawAmount;
                System.out.println("Your new balance is " + balance);
            }
            return balance;
        }
    }
}