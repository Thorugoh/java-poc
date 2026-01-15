public class UnderTheHoodPOC {
    public static void main(String[] args) {
        boolean systemStatus = false;

        MyCustomProvider<String> manualProvider = new MyCustomProvider<String>() {
            @Override
            public String provide() {
                System.out.println("-- Operation in progress --");
                return "Data from Manual Provider";
            }
        };

        MyCustomProvider<String> lambdaProvider = () -> {
            System.out.println("-- Operation in progress --");
            return "Data from Lambda Provider";
        };

        System.out.println("Starting...");
        DataProcessor.processIfActive(systemStatus, lambdaProvider);
        System.out.println("Finished.");
    }
}
