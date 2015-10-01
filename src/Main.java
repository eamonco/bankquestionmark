import java.util.Scanner;

public class Main {

    public void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String firstName;
        String surname;
        String accountType;
        int initialDeposit;
        String typeAccount;

	    System.out.println("Please enter new account details:");
        firstName = scan.nextLine();
        System.out.println("Firstname:");
        surname = scan.nextLine();
        System.out.println("Surname:");
        accountType = scan.nextLine();
        System.out.println("Account type: \n 1. Saver \n 2. Standard \n 3. Premium");

        if (accountType == "saver" || accountType == "Saver" || accountType == "1")
        {
            typeAccount = "Saver";
        }
        else if (accountType == "standard" || accountType == "Standard" || accountType == "2")
        {
            typeAccount = "Standard";
        }
        else if (accountType == "premium" || accountType == "Premium" || accountType == "3")
        {
            typeAccount = "Premium";
        }
        else
            System.out.println("Please select a valid option");





    }
}
