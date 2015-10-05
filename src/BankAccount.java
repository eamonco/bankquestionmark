
public class BankAccount
{
    public String firstName;
    public String surname;
    public int balance;
    public String accountType;
    public int overdraft;
    public int accountNumber;

    public BankAccount(int accountNumber, String firstName, String surname, String accountType, int balance, int overdraft)
    {
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.surname = surname;
        this.accountType = accountType;
        this.balance = balance;
        this.overdraft = overdraft;
    }

    public String getDescription()
    {
        return this.accountNumber + " (" + this.accountType + ") - " + this.firstName + " " + this.surname + " - £" + this.balance;
    }
}
