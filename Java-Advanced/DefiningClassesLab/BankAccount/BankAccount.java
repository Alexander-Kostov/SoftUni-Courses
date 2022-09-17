package JavaAdvance.DefiningClassesLab.BankAccount;

public class BankAccount {
    private static double interestRate = 0.02;
    private static int nextId = 1;

    private double balance;
    private int id;

    public BankAccount() {
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public static void setInterestRate (double interest){
        interestRate = interest;
    }

    public double getInterestRate (int years){
        return interestRate * years * this.balance;
    }

    public void deposit (double amount){
        this.balance += amount;
    }
}
