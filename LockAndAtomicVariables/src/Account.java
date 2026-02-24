public class Account {
    private final int id;
    private double balance;
    private String name;

    public Account(double initialBalance) {
        this.id = -1;
        this.balance = initialBalance;
    }

    public Account(String name, double initialBalance) {
        this.id = -1;
        this.balance = initialBalance;
        this.name = name;
    }

    public Account(int id, String name, double initialBalance){
        this.id = id;
        this.name = name;
        this.balance = initialBalance;
    }

    public int getId(){
        return  id;
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