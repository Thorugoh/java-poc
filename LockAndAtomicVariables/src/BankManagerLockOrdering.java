public class BankManagerLockOrdering {
    public void transfer(Account fromAccount, Account toAccount, double amount) {

        Account firstLock = fromAccount.getId() < toAccount.getId() ? fromAccount : toAccount;
        Account secondLock = fromAccount.getId() < toAccount.getId() ? toAccount : fromAccount;

        System.out.println(Thread.currentThread().getName() + " - Waiting to lock " + firstLock.getName());

        synchronized (firstLock) {
            System.out.println(Thread.currentThread().getName() + " - Locked " + firstLock.getName());

            try { Thread.sleep(50); } catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + " - Waiting to lock " + secondLock.getName());
            synchronized (secondLock) {
                System.out.println(Thread.currentThread().getName() + " - Locked " + secondLock.getName());
                try { Thread.sleep(2000); } catch (InterruptedException e) {}
                if(fromAccount.getBalance() >= amount) {
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                    System.out.println(Thread.currentThread().getName() + " - Transfer complete");
                } else {
                    System.out.println(Thread.currentThread().getName() + " - Insufficient funds for transfer");
                }

                System.out.println(secondLock.getName() + " lock released");
            }

            System.out.println(firstLock.getName() + " lock released");
        }
    }

    public static void main(String[] args) {
        BankManagerLockOrdering manager = new BankManagerLockOrdering();

        // Accounts now have unique IDs
        Account accountA = new Account(1,"AccountA", 1000);
        Account accountB = new Account(2, "AccountB", 500);
        Account accountC = new Account(3,"AccountC", 1000);
        Account accountD = new Account(4, "AccountD", 1000);

        // Thread 1: Transfers from A (ID 1) to B (ID 2)
        Thread t1 = new Thread(() -> manager.transfer(accountA, accountB, 100), "Thread-1");

        // Thread 2: Transfers from B (ID 2) to A (ID 1) - AT THE SAME TIME
        Thread t2 = new Thread(() -> manager.transfer(accountB, accountA, 100), "Thread-2");
        Thread t3 = new Thread(() -> manager.transfer(accountC, accountD, 100), "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
