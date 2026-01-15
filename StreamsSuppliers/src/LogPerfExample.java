import java.util.function.Supplier;

public class LogPerfExample {

    private static boolean isDebugEnabled = false;

    public static void main(String[] args) {
        int totalItems = 10_000;
        System.out.println("Starting supplier processing...");
        long startTime = System.currentTimeMillis();

        for(int i = 0; i < totalItems; i++) {
            int id = i;

            // Anonymous Supplier
            logDebug(() -> generateExpensiveSummary(id));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Processing completed in " + (endTime - startTime) + " ms");
    }

    public static void logDebug(Supplier<String> messageSupplier) {
        if(isDebugEnabled) {
            System.out.println("DEBUG: " + messageSupplier.get());
        }
    }

    private static String generateExpensiveSummary(int id) {
        // Simulate an expensive operation
        try {
            Thread.sleep(5); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return "Expensive summary generated. #" + id;
    }
}
