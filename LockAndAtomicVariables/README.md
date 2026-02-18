
### 1. Using lock() - Will wait forever if busy
```java
transactionLock.lock();
try {
    // Perform critical transaction
    System.out.println("Got the lock, working...");
} finally {
    transactionLock.unlock();
}
```

### 2. Using tryLock() - Fails immediately if busy
```java

if (transactionLock.tryLock()) {
    try {
        // Perform critical transaction
        System.out.println("Got the lock, working...");
    } finally {
        transactionLock.unlock();
    }
} else {
    // Do something else instead of waiting
    System.out.println("Lock is busy! Moving on to another task.");
}
```

### 3. Using synchronized - Always waits forever if busy (just like lock())
```java
// ... inside some method ...
final Object transactionMonitor = new Object();
synchronized (transactionMonitor) {
    // Perform critical transaction
    System.out.println("Got the monitor lock, working...");
} // Automatically unlocks here, even if an exception is thrown
```