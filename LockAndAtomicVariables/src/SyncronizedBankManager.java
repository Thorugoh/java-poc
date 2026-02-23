public class SyncronizedBankManager {
    // Replaced ReentrantLock with a simple Object to act as the monitor lock
    private final Object transactionMonitor = new Object();

    public void transfer(Account fromAccount, Account toAccount, double amount) {
        // Lock the critical section using the monitor object
        System.out.println(Thread.currentThread().getName() + " - Waiting for the lock...");
        synchronized (transactionMonitor) {
            System.out.println(Thread.currentThread().getName() + " --- Acquired the lock! Processing...");

            try { Thread.sleep(50); } catch (InterruptedException e) {}

            if(fromAccount.getBalance() >= amount) {
                fromAccount.withdraw(amount);
                toAccount.deposit(amount);
                System.out.println(Thread.currentThread().getName() + " transferred " + amount + " from Account A to Account B");
            } else {
                System.out.println(Thread.currentThread().getName() + " - Insufficient funds for transfer");
            }
            System.out.println(Thread.currentThread().getName() + " --- Releasing the lock.\n");
        } // The lock is automatically released here! No need for try/finally.

    }

    public static void main(String[] args) {
        SyncronizedBankManager manager = new SyncronizedBankManager();
        Account accountA = new Account(1000);
        Account accountB = new Account(500);

        Runnable transferTask = () -> {
            for(int i = 0; i < 7; i++) {
                manager.transfer(accountA, accountB, 100);

                // Simulate some processing time outside the lock
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
            // Await for both threads to finish
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Balance AccountA: " + accountA.getBalance());
        System.out.println("Balance AccountB: " + accountB.getBalance());
    }
}