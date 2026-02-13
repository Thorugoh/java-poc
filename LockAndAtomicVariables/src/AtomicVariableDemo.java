import java.util.concurrent.atomic.AtomicInteger;

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + " - Count:" + count.get());
    }
}
public class AtomicVariableDemo {
    public static void main(String[] args) {
        AtomicCounter counter = new AtomicCounter();

        Runnable task = () -> {
            for(int i = 0; i < 5; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}
