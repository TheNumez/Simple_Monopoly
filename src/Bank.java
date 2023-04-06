import javax.swing.*;

public class Bank
{
    private int balance;
    public Bank()
    {
        this.balance=10000;
        //Bank's initial balance is 10000, simplified version.
    }

    //Basic methods to withdraw/deposit money for the Bank class:
    public void withdraw(Player recipient, int amount)
    {
        recipient.addAmount(amount);
        this.balance=-amount;
    }
    public void deposit(int amount)
    {
        this.balance+=amount;
    }
    public int getBalance()
    {
        return this.balance;
    }

}
