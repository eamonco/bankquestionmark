import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void enterAccountType()
    {
        String accountType;
        String typeAccount;
        int overdraft;
        Scanner scan = new Scanner(System.in);

        System.out.println("Account type: \n 1. Saver \n 2. Standard \n 3. Premium");
        accountType = scan.nextLine();

        if (accountType.toLowerCase().equals("saver") || accountType.equals("1"))
        {
            typeAccount = "Saver";
            overdraft = 0;
        }

        else if (accountType.toLowerCase().equals("standard") || accountType.equals("2"))
        {
            typeAccount = "Standard";
            overdraft = 500;
        }

        else if (accountType.toLowerCase().equals("premium") || accountType.equals("3"))
        {
            typeAccount = "Premium";
            overdraft = 3000;
        }

        else
        {
            System.out.println("Please select a valid option");
            enterAccountType();
        }
    }

    public static void InitialDeposits()
    {
        int balance = 0;
        int initialDeposit;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the initial deposit in £");

        try
        {
            initialDeposit = Integer.parseInt(scan.nextLine());
            balance += balance + initialDeposit;
            if (initialDeposit < 0)
            {
                System.out.println("Please enter a positive number");
                InitialDeposits();
            }
        }

        catch (Exception notInt)
        {
            System.out.println("Please enter a valid number");
            InitialDeposits();
        }
    }

    public static void listAllAccounts()
    {
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

        for (BankAccount bankAccount : accounts)
        {
            System.out.println(bankAccount.accountNumber + " (" + bankAccount.accountType + ") - " + bankAccount.firstName + " " + bankAccount.surname + " - £" + bankAccount.balance);

            if (bankAccount.firstName.equals(null))
            {
                System.out.println("Done");
            }
        }
    }

    public static void accountManagement()
    {
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
        Scanner scan = new Scanner(System.in);
        int accountChoice;
        int withdrawAmount =0;
        int balance;
        int depositAmount;
        int overdraft;
        int balanceChoice = 0;

        System.out.println("Which account do you wish to withdraw from or deposit to? \nEnter ID: ");
        accountChoice = scan.nextInt();
        scan.nextLine();

        BankAccount searchAccountNumberResult;

        for (BankAccount bankAccount : accounts)
        {
            if (bankAccount.accountNumber == accountChoice)
            {
                searchAccountNumberResult = bankAccount;
                balance = searchAccountNumberResult.balance;
            }

            else
            {
                System.out.println("There is no bank account associated with that ID");
                accountManagement();
            }

            System.out.println("Would you like to: \n 1. Withdraw money \n 2. Deposit money");

            balanceChoice = scan.nextInt();
            scan.nextLine();

            if (balanceChoice == 1)
            {
                System.out.println("Available funds: £" + balance);
                System.out.println("Enter amount to withdraw?");
                withdrawAmount = scan.nextInt();
                scan.nextLine();

                if (withdrawAmount > balance + overdraft || withdrawAmount > 10000)
                {
                    System.out.println("You cannot withdraw more than you have in your account or more than £10,000 in one transaction");
                    break;
                }

                else
                {
                    balance = balance - withdrawAmount - 1;
                    System.out.println(" Amount withdrawn: " + withdrawAmount + "\n New balance: " + balance);
                }
            }

            else if (balanceChoice == 2)
            {
                System.out.println("Enter amount to deposit");
                depositAmount = scan.nextInt();
                scan.nextLine();
                System.out.println("£" + depositAmount + " have been deposited. \n Your new balance is: " + balance + depositAmount);
            }

            else
            {
                System.out.println("Choose a valid option (1 or 2)");
                balanceChoice = 0;
            }
        }
        }
    }

    public static void main(String[] args)
    {
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

        Scanner scan = new Scanner(System.in);

        String firstName = "jim";
        String surname = "bill";
        String typeAccount = "fish";
        int initialDeposit = -1;
        int initialChoice;
        int overdraft = 0;
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
                    firstName = scan.nextLine();
                    System.out.println("Surname:");
                    surname = scan.nextLine();

                    enterAccountType();

                    InitialDeposits();

                    accountNumber = accounts.size() + 1;

                    accounts.add(new BankAccount(accountNumber, firstName, surname, typeAccount, initialDeposit, overdraft));
                        break;
                }

                case 2:
                {
                    listAllAccounts();
                }

                case 3:
                {
                    accountManagement();
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
} */