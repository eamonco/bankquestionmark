public class accountcreation {

    public enum AccountType
    {
        Standard,
        Saver,
        Premium
    }

    public String firstName;
    public String surName;
    public int initialDeposit;
    public AccountType accountType;

    public accountcreation(String firstName, String surname, AccountType accountType, int initialDeposit)
    {
        this.firstName = firstName;
        this.surName = surname;
        this.accountType = accountType;
        this.initialDeposit = initialDeposit;
    }
}
