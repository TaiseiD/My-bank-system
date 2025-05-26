import java.util.ArrayList;
import java.util.Scanner;

public class mainBank 
{
    static ArrayList<String> transactions = new ArrayList<>();

    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        int choice;
        Double balance = 100000.00;
        
        User user = new User("admin", "admin");
        admin admin = new admin("admin123");

        boolean loggedIn = false;

        while (true)
        {
            if (!loggedIn)
            {
                System.out.println("WELCOME TO BANKNET! ");
                input.nextLine();
                System.out.print("Enter username: ");
                String inputUser = input.next();
                System.out.print("Enter password: ");
                String inputPass = input.next();

                if (!user.username.equals(inputUser) || !user.password.equals(inputPass)) 
                    {
                        System.out.println("Invalid credentials. Try again.\n");
                        loggedIn = false;
                    }
                    else 
                    {
                        System.out.println("");
                        System.out.println("Login successful!\n");
                        loggedIn = true;
                    }
            }

            else
            {
                System.out.println("Please select an option:");
                System.out.println("1. Show Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Loan Money");
                System.out.println("5. Show Transactions");
                System.out.println("6. Change Pin");
                System.out.println("7. Log Out");
                System.out.print("Enter your choice: ");
                choice = input.nextInt();

                switch (choice) 
                    {
                        case 1:
                            showBalance(balance);
                            continue;
                        case 2:
                            balance = deposit(balance);
                            continue;
                        case 3:
                            balance = withdraw(balance);
                            continue;
                        case 4:
                            balance = loanMoney(balance);
                            continue;
                        case 5:
                            showTransactions();
                            continue;
                        case 6:
                            changePin(user);
                            continue;
                        case 7:
                            System.out.println("Logging Out...");
                            loggedIn = false;
                            continue;
                        case 0 : 
                            input.nextLine();
                            System.out.print("Enter the admin password : ");
                            String adminPasswordInput = input.nextLine();
                            if (admin.adminPassword.equals(adminPasswordInput))
                            {
                                System.out.println("Thank you for using Banknet. Goodbye!");
                                System.exit(0);
                            }
                            else
                            {
                                loggedIn = false;
                                continue;
                            }
                        default:
                            System.out.println("Invalid choice. Exiting...");
                            continue;
                    }
            }
        }
    }

    static class User 
    {
        String username;
        String password;

        User(String username, String password) 
        {
            this.username = username;
            this.password = password;
        }
    }

    static class admin
    {
        String adminPassword;

        admin (String adminPassword)
        {
            this.adminPassword = adminPassword;
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
                transactions.add("Deposited : PHP " + depositAmount);
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
                transactions.add("Withdrew : PHP " + withdrawAmount);
                System.out.println("Your new balance is " + balance);
            }
            return balance;
        }
    }

    private static Double loanMoney(Double balance)
    {
        Scanner loanMoneyInput = new Scanner(System.in);
        int choice;

        System.out.println(" ");
        System.out.println("1. Loan Money");
        System.out.println("2. Pay Loan");
        System.out.print("Enter your choice: ");
        choice = loanMoneyInput.nextInt();

        if (choice == 1) 
        {
            Double loanAmount, months;
            Double monthlyInterest = 0.05;

            System.out.println(" ");
            System.out.print("Enter Amount to Loan : ");
            loanAmount = loanMoneyInput.nextDouble();

            System.out.println(" ");
            System.out.print("Enter How Many Months To Pay The Loan : ");
            months = loanMoneyInput.nextDouble();

            if (months <= 0) 
            {
                System.out.println(" ");
                System.out.println("Invalid Months To Pay The Loan");
                return balance;
            } 
            else 
            {
                Double totalRepayment = loanAmount * Math.pow(1 + monthlyInterest, months);
                System.out.println(" ");
                System.out.println("You need to pay PHP " + totalRepayment);
                System.out.println("You need to pay your loan in months : " + months);

                Double monthlyPayment = totalRepayment / months;
                System.out.println("Monthly Payment: PHP " + monthlyPayment);

                balance += loanAmount;
                transactions.add("Loaned : PHP " + loanAmount + " (to repay : PHP " + totalRepayment + ")");
                System.out.println(" ");
                System.out.println("Your new balance is PHP " + balance);
            }
        } 
        
        else if (choice == 2) 
        {
            System.out.print("Enter total outstanding loan to pay: PHP ");
            double remainingLoan = loanMoneyInput.nextDouble();

            System.out.print("Enter amount to pay for the loan: PHP ");
            double payAmount = loanMoneyInput.nextDouble();

            if (payAmount > 0 && payAmount <= balance && payAmount <= remainingLoan) {
                remainingLoan -= payAmount;
                balance -= payAmount;
                transactions.add("Paid : PHP " + payAmount + " towards loan");
                System.out.println("Payment successful! Remaining loan: PHP " + remainingLoan);
                System.out.println("Your new balance is PHP " + balance);
            } else {
                System.out.println("Invalid payment amount.");
            }
        } 
        else 
        {
            System.out.println("Invalid choice.");
        }

        return balance;
    }

    private static void showTransactions ()
    {
        System.out.println("");
        if (transactions.isEmpty()) 
        {
            System.out.println("No transactions to show at this time.");
        } 
        else 
        {
            System.out.println("Transaction History:");
            for (String t : transactions) 
            {
                System.out.println(t);
            }
        }
        System.out.println("");
    }

    private static void changePin(User user) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter current username: ");
        String currentUser = input.next();
        System.out.print("Enter current password: ");
        String currentPass = input.next();

        if (!user.username.equals(currentUser) || !user.password.equals(currentPass)) 
        {
            System.out.println("Incorrect username or password. Pin change failed.");
            return;
        }

        System.out.print("Enter new password: ");
        String newPassword = input.next();
        System.out.print("Confirm new password: ");
        String confirmPassword = input.next();

        if (!newPassword.equals(confirmPassword)) 
        {
            System.out.println("Passwords do not match. Pin change failed.");
        } 
        else 
        {
            user.password = newPassword;
            System.out.println("Pin changed successfully!");
        }
    }

}
