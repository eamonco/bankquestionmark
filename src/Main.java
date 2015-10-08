import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    static Scanner scan = new Scanner(System.in);

    public static String getAccountType()
    {
        String accountType;
        String typeAccount = null;

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
        int initialDeposit = -1;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the initial deposit in £");

        while (initialDeposit == -1)
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

    public static void makeDeposit(BankAccount bankAccount)
    {
        while (true)
        {
            System.out.println("Enter amount to deposit");

            try
            {
                int depositAmount = Integer.parseInt(scan.nextLine());

                if (depositAmount < 0)
                {
                    System.out.println("Please enter a positive number");
                }
                else
                {
                    bankAccount.deposit(depositAmount);
                    System.out.println("£" + depositAmount + " have been deposited. \n Your new balance is: " + bankAccount.getBalance());
                    break;
                }
            }
            catch(NumberFormatException error)
            {
                System.out.println("Please enter a numeric value");
            }
            catch (Exception error)
            {
                System.out.println(error.getMessage());
            }
        }
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
        boolean accountManagementChoice = true;
        boolean accountNumberIsValid = false;

        System.out.println("Which account do you wish to withdraw from or deposit to? \nEnter ID: ");

        BankAccount searchAccountNumberResult = null;

        while (!accountNumberIsValid)
        {
            try
            {
                accountChoice = scan.nextInt();
                scan.nextLine();

                accountNumberIsValid = true;

                for (BankAccount bankAccount : accounts)
                {
                    if (bankAccount.accountNumber == accountChoice)
                    {
                        searchAccountNumberResult = bankAccount;
                        break;
                    }
                }
            }
            catch (Exception notInt)
            {
                System.out.println("Please enter a valid number");
                break;
            }
        }

        if (searchAccountNumberResult == null)
        {
            System.out.println("There is no bank account associated with that ID");
        }
        else
        {
            System.out.println("Would you like to: \n 1. Withdraw money \n 2. Deposit money");
            while (accountManagementChoice)
            {
                try
                {
                    balanceChoice = scan.nextInt();
                    scan.nextLine();

                    if (balanceChoice == 1)
                    {
                        balance = searchAccountNumberResult.getBalance();

                        while(loop)
                        {
                            System.out.println("Available funds: £" + balance);
                            System.out.println("Enter amount to withdraw");
                            withdrawAmount = scan.nextInt();
                            scan.nextLine();

                            try
                            {
                                searchAccountNumberResult.withdraw(withdrawAmount);
                                System.out.println(" Amount withdrawn: " + withdrawAmount + "\n New balance: " + balance);
                                break;
                            }

                            catch (Exception error)
                            {
                                System.out.println(error.getMessage());
                            }
                        }
                    }

                    else if (balanceChoice == 2)
                    {
                        makeDeposit(searchAccountNumberResult);
                    }
                    else
                    {
                        System.out.println("Choose a valid option (1 or 2)");
                    }
                }
                catch (Exception notInt)
                {
                    System.out.println("Please enter a valid number");
                    break;
                }
                break;
            }
        }
    }

    public static void main(String[] args)
    {
        ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

        accounts.add(new BankAccount(1, "John", "Smith", "Saver", 400, 0));
        accounts.add(new BankAccount(2, "Jonny", "Moore", "Premium", 500, 3000));

        Scanner scan = new Scanner(System.in);

        int initialChoice;
        int overdraft = 0;
        int accountNumber;

        while (true)
        {
            System.out.println(" 1. Create account \n 2. List accounts \n 3. Account management \n 4. Exit");

            initialChoice = scan.nextInt();
            scan.nextLine();

            if (initialChoice <5 && initialChoice > 0)
            {
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

                        accountNumber = accounts.size() + 1;

                        int balance = InitialDeposits();

                        accounts.add(new BankAccount(accountNumber, firstName, surname, accountType, balance, overdraft));
                            break;
                    }

                    case 2:
                    {
                        for (BankAccount bankAccount : accounts)
                        {
                            System.out.println(bankAccount.getDescription());
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
            else
            {
                System.out.println("Please select an valid option");
            }
        }
    }
}
