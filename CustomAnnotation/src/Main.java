public class Main {
    public static void main(String[] args) {
        try {
            Person person = new Person("John", "Doe", "30");

            ObjectToJsonConverter converter = new ObjectToJsonConverter();
            String jsonResult = converter.convertToJson(person);

            System.out.println("Generated JSON: " + jsonResult);

        } catch (Exception e) {
            System.err.println("Error during JSON serialization: " + e.getMessage());
            e.printStackTrace();
        }
    }
}