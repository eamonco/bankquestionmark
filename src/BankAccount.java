
public class BankAccount
{
    public String firstName;
    public String surname;
    private int balance;
    public String accountType;
    private int overdraft;
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

    public int getBalance()
    {
        return this.balance;
    }

    public int getOverdraft()
    {
        return this.overdraft;
    }

    public void deposit(int amountToDeposit) throws Exception
    {
        if (amountToDeposit < 0)
        {
            throw new Exception("Can't deposit a negative amount");
        }

        this.balance += amountToDeposit;
    }

    public void withdraw(int amountToWithdraw) throws Exception
    {
        if (amountToWithdraw < 0 || amountToWithdraw > 10000 || amountToWithdraw > this.getBalance() + this.getOverdraft())
        {
            throw new Exception ("Can't withdraw a negative amount, more than £10000 in one transaction, or more than what is in your account and overdraft allow");
        }

        if (accountType == "Saver")
        {
            this.balance -= amountToWithdraw + 1;
        }
        else
        {
            this.balance -= amountToWithdraw;
        }
    }


}
