public class DataProcessor {
    static void processIfActive(boolean active, MyCustomProvider<String> provider) {
        if(active) {
            System.out.println("Processing: " + provider.provide());
        } else {
            System.out.println("System inactive. No processing done.");
        }
    }
}
