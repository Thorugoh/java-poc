import java.util.concurrent.*;

public class FutureTimeoutExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> slowTask = () -> {
            System.out.println("Starting to prepare order...");
            try{
                Thread.sleep(5000); // Simulate a long-running task
            } catch (InterruptedException e) {
                System.out.println("Order was cancelled");
                return null;
            }
            return "Order is ready!";
        };

        System.out.println("Placing order...");
        Future<String> futureDish = executor.submit(slowTask);
        System.out.println("Waiting for the order to be ready...");

        try {
            String dish = futureDish.get(2, TimeUnit.SECONDS);
            System.out.println(dish);

        } catch (TimeoutException e) {
            System.out.println("The order is taking too long.");
            futureDish.cancel(true);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Always remember to shut down the executor
            executor.shutdown();
        }
    }
}
