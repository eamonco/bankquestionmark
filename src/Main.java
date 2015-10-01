import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        String firstName = "jim";
        String surname = "bill";
        String accountType = "fish";
        String typeAccount = "fish";
        int initialDeposit = -1;

	    System.out.println("Please enter new account details:");
        System.out.println("Firstname:");
        firstName = scan.nextLine();
        System.out.println("Surname:");
        surname = scan.nextLine();
        System.out.println("Account type: \n 1. Saver \n 2. Standard \n 3. Premium");
        accountType = scan.nextLine();

        while (typeAccount.equals("fish"))
        {
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
                System.out.println("Please select a valid option");
        }

        System.out.println("Enter the initial deposit in £");

        while (initialDeposit == -1)
        {
            try
            {
                initialDeposit = Integer.parseInt(scan.nextLine());
                if (initialDeposit < 0)
                {
                    break;
                }
            }
            catch (Exception notInt)
            {
                System.out.println("Please enter a valid number");
            }
        }

        accountcreation account1 = new accountcreation(firstName, surname, typeAccount, initialDeposit);



        account1.showAccount();










    }
}
