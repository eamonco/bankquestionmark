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

    /*
    @Test
    public void depositsAddOntoBalance_ThrowsErrorMessageWhenAmountIsNegative()
    {
        Amount = -10;

        while (loop == true)
        {
            try
            {
                if (Amount < 0)
                {
                    System.out.println("Please enter a positive number");
                    break;
                }
                TestBankAccount1.balance = TestBankAccount1.balance + Amount;
                System.out.println("£" + Amount + " have been deposited. \n Your new balance is: " + TestBankAccount1.balance);
                loop = false;
            }

            catch (Exception notInt)
            {
                System.out.println("Choose a valid option (1 or 2)");
            }
        }
        Assert.assertEquals(400, TestBankAccount1.balance);
        TestBankAccount1.balance = 400;
        TestBankAccount2.balance = 15000;
    }

    @Test
    public void depositsAddOntoBalance_AcceptsValue()
    {
        Amount = 100;

        while (loop == true)
        {
            try
            {
                if (Amount < 0)
                {
                    System.out.println("Please enter a positive number");
                    break;
                }
                TestBankAccount1.balance = TestBankAccount1.balance + Amount;
                System.out.println("£" + Amount + " have been deposited. \n Your new balance is: " + TestBankAccount1.balance);
                loop = false;
            }

            catch (Exception notInt)
            {
                System.out.println("Choose a valid option (1 or 2)");
            }
        }
        Assert.assertEquals(500, TestBankAccount1.balance);
        TestBankAccount1.balance = 400;
        TestBankAccount2.balance = 15000;
    }

    @Test
    public void depositsAddOntoBalance_ThrowsErrorAmountIsLetter()
    {
        StringAmount = "hi";

        while (loop == true)
        {
            try
            {
                if (Amount < 0)
                {
                    System.out.println("Please enter a positive number");
                    break;
                }
                else if (StringAmount != null)
                {
                    System.out.println("Please enter a valid number");
                    break;
                }
                TestBankAccount1.balance = TestBankAccount1.balance + Amount;
                System.out.println("£" + Amount + " have been deposited. \n Your new balance is: " + TestBankAccount1.balance);
                loop = false;
            }

            catch (Exception notInt)
            {
                System.out.println("Choose a valid option (1 or 2)");
            }
        }
        Assert.assertEquals(400, TestBankAccount1.balance);
        TestBankAccount1.balance = 400;
    }

    @Test
    public void WithdrawAmount_ThrowsExceptionOver10000()
    {
        Amount = 10001;

        while(loop == true)
        {
            if (Amount > TestBankAccount2.balance + TestBankAccount2.overdraft || Amount > 10000)
            {
                System.out.println("You cannot withdraw more than you have in your account and overdraft combined, or more than £10,000 in one transaction");
                break;
            }
            else
            {
                TestBankAccount2.balance = TestBankAccount2.balance - Amount - 1;
                System.out.println(" Amount withdrawn: " + Amount + "\n New balance: " + TestBankAccount2.balance);
                loop = false;
            }
        }
        Assert.assertEquals(15000, TestBankAccount2.balance);
    }

    @Test
    public void WithdrawAmount_AcceptsExtremeValue()
    {
        Amount = 899;

        while(loop == true)
        {
            if (Amount > TestBankAccount1.balance + TestBankAccount1.overdraft || Amount > 10000)
            {
                System.out.println("You cannot withdraw more than you have in your account and overdraft combined, or more than £10,000 in one transaction");
                break;
            }
            else
            {
                TestBankAccount1.balance = TestBankAccount1.balance - Amount - 1;
                System.out.println(" Amount withdrawn: " + Amount + "\n New balance: " + TestBankAccount1.balance);
                loop = false;
            }
        }
        Assert.assertEquals(-500, TestBankAccount1.balance);
    }

    @Test
    public void WithdrawAmount_ThrowsExceptionOverAccountLimitAndOverdraft()
    {
        Amount = 5000;

        while(loop == true)
        {
            if (Amount > TestBankAccount1.balance + TestBankAccount1.overdraft || Amount > 10000)
            {
                System.out.println("You cannot withdraw more than you have in your account and overdraft combined, or more than £10,000 in one transaction");
                break;
            }
            else
            {
                TestBankAccount1.balance = TestBankAccount1.balance - Amount - 1;
                System.out.println(" Amount withdrawn: " + Amount + "\n New balance: " + TestBankAccount1.balance);
                loop = false;
            }
        }
        Assert.assertEquals(400, TestBankAccount1.balance);
    }

    @Test
    public void WithdrawAmount_ThrowsExceptionAmountIsLetter()
    {
        StringAmount = "hi";

        while(loop == true)
        {
            if (Amount > TestBankAccount1.balance + TestBankAccount1.overdraft || Amount > 10000)
            {
                System.out.println("You cannot withdraw more than you have in your account and overdraft combined, or more than £10,000 in one transaction");
                break;
            }
            else if (StringAmount != null)
            {
                System.out.println("Please enter a valid number");
                break;
            }
            else
            {
                TestBankAccount1.balance = TestBankAccount1.balance - Amount - 1;
                System.out.println(" Amount withdrawn: " + Amount + "\n New balance: " + TestBankAccount1.balance);
                loop = false;
            }
        }
        Assert.assertEquals(400, TestBankAccount1.balance);
    }



    @Test
    public void CheckAccountType_ThrowsExceptionIfSelectionIsNotAnOption()
    {
        String accountType = "hi";
        TestBankAccount3.accountType = null;

        while(TestBankAccount3.accountType == null)
        {
            if (accountType.toLowerCase().equals("saver") || accountType.equals("1"))
            {
                TestBankAccount3.accountType = "Saver";
            }
            else if (accountType.toLowerCase().equals("standard") || accountType.equals("2"))
            {
                TestBankAccount3.accountType = "Standard";
            }
            else if (accountType.toLowerCase().equals("premium") || accountType.equals("3"))
            {
                TestBankAccount3.accountType = "Premium";
            }
            else
            {
                System.out.println("Please select a valid option");
                break;
            }
        }
        Assert.assertEquals(null, TestBankAccount3.accountType);
    }

    @Test
    public void InitialDeposits_ThrowsErrorWhenNegativeValueIsInput()
    {
        TestBankAccount2.balance = 0;
        int initialDeposit = -10;

        TestBankAccount2.balance = TestBankAccount2.balance + initialDeposit;
        if (initialDeposit < 0)
        {
            System.out.println("Please enter a positive number");
        }
    }
    */
}