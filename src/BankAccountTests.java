import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class BankAccountTests {

    ArrayList<BankAccount> TestBankAccounts = new ArrayList<BankAccount>();

    BankAccount TestBankAccount1;
    BankAccount TestBankAccount2;
    BankAccount TestBankAccount3;

    @Before
    public void setup(){
        TestBankAccount1 = new BankAccount(1, "Jonny", "Moore", "Standard", 400, 500);
        TestBankAccount2 = new BankAccount(2, "Eamon", "Compston", "Premium", 15000, 3000);
        TestBankAccount3 = new BankAccount(3, "Peter", "Bonar", "Saver", 1000, 0);
    }

    @Test
    public void depositAmountCantBeNegative()
    {
        try
        {
            TestBankAccount1.deposit(-1);
            Assert.fail();
        }
        catch(Exception error)
        {
            Assert.assertEquals("Can't deposit a negative amount", error.getMessage());
        }
    }

    @Test
    public void depositWorks()
    {
        try
        {
            TestBankAccount1.deposit(100);
            Assert.assertEquals(500, TestBankAccount1.getBalance());
        }
        catch(Exception error)
        {
            Assert.fail();
        }
    }

    @Test
    public void withdrawAmountCantBeOver10000()
    {
        try
        {
            TestBankAccount2.withdraw(10001);
            Assert.fail();
        }
        catch(Exception error)
        {
            Assert.assertEquals("Can't withdraw a negative amount, more than £10000 in one transaction, or more than what is in your account and overdraft allow", error.getMessage());
        }
    }

    @Test
    public void withdrawAmountCantBeNegative()
    {
        try
        {
            TestBankAccount2.withdraw(-1);
            Assert.fail();
        }
        catch(Exception error)
        {
            Assert.assertEquals("Can't withdraw a negative amount, more than £10000 in one transaction, or more than what is in your account and overdraft allow", error.getMessage());
        }
    }

    @Test
    public void withdrawAmountCantBeMoreThanAmountInAccountAndOverdraft()
    {
        try
        {
            TestBankAccount1.withdraw(901);
            Assert.fail();
        }
        catch(Exception error)
        {
            Assert.assertEquals("Can't withdraw a negative amount, more than £10000 in one transaction, or more than what is in your account and overdraft allow", error.getMessage());
        }
    }

    @Test
    public void withdrawWorks()
    {
        try
        {
            TestBankAccount3.withdraw(500);
            Assert.assertEquals(499, TestBankAccount3.getBalance());
        }
        catch(Exception error)
        {
            Assert.fail();
        }
    }

    @Test
    public void checkIfListAccountsDisplaysInCorrectFormat()
    {
        TestBankAccount1.getDescription();
        Assert.assertEquals("3 (Saver) - Peter Bonar - £1000", TestBankAccount3.getDescription());
    }
}