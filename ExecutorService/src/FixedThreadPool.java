import java.util.concurrent.*;

public class FixedThreadPool {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(
                10,
                10,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(10));

        for(int i = 0; i < 200; i++) {
            final int taskId = i;
            try {
                es.execute(() -> {
                    System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
                });
            } catch (RejectedExecutionException e) {
                System.out.println("Task was rejected: " + e.getMessage());
            }
        }
    }

}
