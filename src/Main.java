import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static String getAccountType()
    {
        String accountType;
        String typeAccount = null;
        Scanner scan = new Scanner(System.in);

        while(typeAccount == null)
        {
            System.out.println("Account type: \n 1. Saver \n 2. Standard \n 3. Premium");
            accountType = scan.nextLine();

            if (accountType.toLowerCase().equals("saver") || accountType.equals("1"))
            {
                typeAccount = "Saver";
            }
            else if (accountType.toLowerCase().equals("standard") || accountType.equals("2"))
            {
                typeAccount = "Standard";
            }
            else if (accountType.toLowerCase().equals("premium") || accountType.equals("3"))
            {
                typeAccount = "Premium";
            }
            else
            {
                System.out.println("Please select a valid option");
            }
        }

        return typeAccount;
    }

    public static int InitialDeposits()
    {
        int balance = 0;
        int initialDeposit = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the initial deposit in £");

        while (initialDeposit == 0)
        {
            try
            {
                initialDeposit = Integer.parseInt(scan.nextLine());
                balance = balance + initialDeposit;
                if (initialDeposit < 0)
                {
                    System.out.println("Please enter a positive number");
                }
            }

            catch (Exception notInt)
            {
                System.out.println("Please enter a valid number");
            }
        }
        return balance;
    }


    public static void accountManagement(ArrayList<BankAccount> accounts)
    {
        Scanner scan = new Scanner(System.in);
        int accountChoice;
        int withdrawAmount;
        int balance;
        int depositAmount;
        int overdraft;
        int balanceChoice;
        boolean loop = true;

        System.out.println("Which account do you wish to withdraw from or deposit to? \nEnter ID: ");
        accountChoice = scan.nextInt();
        scan.nextLine();

        BankAccount searchAccountNumberResult = null;

        for (BankAccount bankAccount : accounts)
        {
            if (bankAccount.accountNumber == accountChoice)
            {
                searchAccountNumberResult = bankAccount;
            }
            else
            {
                System.out.println("There is no bank account associated with that ID");
            }
        }

        if (searchAccountNumberResult != null)
        {
            System.out.println("Would you like to: \n 1. Withdraw money \n 2. Deposit money");

            balanceChoice = scan.nextInt();
            scan.nextLine();

            if (balanceChoice == 1)
            {
                balance = searchAccountNumberResult.balance;
                overdraft = searchAccountNumberResult.overdraft;

                System.out.println("Available funds: £" + balance);
                System.out.println("Enter amount to withdraw");
                withdrawAmount = scan.nextInt();
                scan.nextLine();

                while(loop == true)
                {
                    if (withdrawAmount > balance + overdraft || withdrawAmount > 10000)
                    {
                        System.out.println("You cannot withdraw more than you have in your account or more than £10,000 in one transaction");
                    }
                    else
                    {
                        balance = balance - withdrawAmount - 1;
                        System.out.println(" Amount withdrawn: " + withdrawAmount + "\n New balance: " + balance);
                        loop = false;
                    }
                }
            }

            else if (balanceChoice == 2)
            {
                while (loop == true)
                {
                    balance = searchAccountNumberResult.balance;
                    System.out.println("Enter amount to deposit");

                    try
                    {
                        depositAmount = scan.nextInt();
                        scan.nextLine();
                        System.out.println("£" + depositAmount + " have been deposited. \n Your new balance is: " + balance + depositAmount);
                        searchAccountNumberResult.balance = balance + depositAmount;
                        loop = false;
                    }

                    catch (Exception notInt)
                    {
                        System.out.println("Choose a valid option (1 or 2)");
                        balanceChoice = 0;
                    }
                }
            }
        }
    }



    public static void main(String[] args)
    {
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

        accounts.add(new BankAccount(1, "john", "smith", "Saver", 400, 0));
        accounts.add(new BankAccount(1, "jonny", "Moore", "Premium", 500, 3000));

        Scanner scan = new Scanner(System.in);

        int initialDeposit = 0;
        int initialChoice;
        int overdraft = 0; // TODO: fix later
        int accountNumber;

        while (true)
        {
            System.out.println(" 1. Create account \n 2. List accounts \n 3. Account management \n 4. Exit");

            initialChoice = scan.nextInt();
            scan.nextLine();

            switch (initialChoice)
            {
                case 1:
                {
                    System.out.println("Please enter new account details:");
                    System.out.println("Firstname:");
                    String firstName = scan.nextLine();
                    System.out.println("Surname:");
                    String surname = scan.nextLine();

                    String accountType = getAccountType();

                    InitialDeposits();

                    accountNumber = accounts.size() + 1;

                    int balance = InitialDeposits();

                    accounts.add(new BankAccount(accountNumber, firstName, surname, accountType, balance, overdraft));
                        break;
                }

                case 2:
                {
                    for (BankAccount bankAccount : accounts)
                    {
                        System.out.println(bankAccount.accountNumber + " (" + bankAccount.accountType + ") - " + bankAccount.firstName + " " + bankAccount.surname + " - £" + bankAccount.balance);
                    }
                    break;
                }

                case 3:
                {
                    accountManagement(accounts);
                    break;
                }
                case 4:
                {
                    System.exit(0);
                }
            }
        }
    }
}


 /* {
        System.out.println("Enter the account number of the account you wish to view");

accountChoice = scan.nextInt();
scan.nextLine();

BankAccount searchAccountNumberResult;

for (BankAccount bankAccount : accounts)
        {
        if (bankAccount.accountNumber == accountChoice)
        {
        searchAccountNumberResult = bankAccount;
break;
}
        }



        break;
}
*/
