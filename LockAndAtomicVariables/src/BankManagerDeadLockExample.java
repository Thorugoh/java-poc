public class BankManagerDeadLockExample {
    public void transfer(Account fromAccount, Account toAccount, double amount) {
        System.out.println(Thread.currentThread().getName() + " - attempting to lock" +  fromAccount.getName());

        // thread locks the original account
        synchronized (fromAccount) {
            System.out.println(Thread.currentThread().getName() + " - locked Account " +  fromAccount.getName());

            // Sleep to guarantee other thread has time to start
            try { Thread.sleep(50); } catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + " - attempting to lock" +  toAccount.getName());

            synchronized (toAccount) {
                System.out.println(Thread.currentThread().getName() + " - locked Account " +  toAccount.getName());

                if(fromAccount.getBalance() >= amount) {
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + " transferred " + amount + " from Account A to Account B");
                }
            }
        }
    }

    public static void main(String[] args) {
        BankManagerDeadLockExample manager = new BankManagerDeadLockExample();
        Account accountA = new Account("Account A", 1000);
        Account accountB = new Account("Account B", 500);

        // t1 transfer from A to B
        Thread t1 = new Thread(() -> manager.transfer(accountA, accountB, 100), "Thread-1");
        // t2 transfer from B to A
        Thread t2 = new Thread(() -> manager.transfer(accountB, accountA, 100), "Thread-2");

        t1.start();
        t2.start();

    // Output:
    //        Thread-1 - attempting to lockAccount A
    //        Thread-1 - locked Account Account A
    //        Thread-2 - attempting to lockAccount B
    //        Thread-2 - locked Account Account B
    //        Thread-2 - attempting to lockAccount A
    //        Thread-1 - attempting to lockAccount B

    }
}
