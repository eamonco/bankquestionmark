import java.util.Scanner;

public class accountcreation {

    public String firstName;
    public String surname;
    public int initialDeposit;
    public String accountType;
    Scanner scanner = new Scanner(System.in);
    public int accountNumber;

    public accountcreation(String firstName, String surname, String accountType, int initialDeposit)
    {
        this.firstName = firstName;
        this.surname = surname;
        this.accountType = accountType;
        this.initialDeposit = initialDeposit;
    }

    public void showAccount()
    {
        System.out.println(" Account Number: " + "\n Account type: " + accountType + "\n Firstname: " + firstName + "\n Surname: " + surname + "\n Balance: " + initialDeposit);
    }
}
