import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankManager {
    private final Lock transactionLock = new ReentrantLock();

    public void transfer(Account fromAccount, Account toAccount, double amount) {
        // lock the entire operation
        transactionLock.lock();
        try {
            if(fromAccount.getBalance() >= amount) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.println(Thread.currentThread().getName() + " transferred " + amount + " from Account A to Account B");
            } else {
                System.out.println(Thread.currentThread().getName() + " - Insufficient funds for transfer");
            }
        } finally {
            transactionLock.unlock();
        }
    }

    public static void main(String[] args) {
        BankManager manager = new BankManager();
        Account accountA = new Account(1000);
        Account accountB = new Account(500);

        Runnable transferTask = () -> {
            for(int i = 0; i < 7; i++) {
                manager.transfer(accountA, accountB, 100);

                // Simulate some processing time
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        };

        Thread t1 = new Thread(transferTask, "Thread-1");
        Thread t2 = new Thread(transferTask, "Thread-2");

        t1.start();
        t2.start();

        try {
            // await for both threads to finish
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Balance AccountA: " + accountA.getBalance());
        System.out.println("Balance AccountB: " + accountB.getBalance());

    }
}
