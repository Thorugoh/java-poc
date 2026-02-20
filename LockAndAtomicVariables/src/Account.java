public class Account {
    private double balance;
    private String name;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public Account(String name, double initialBalance) {
        this.balance = initialBalance;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}