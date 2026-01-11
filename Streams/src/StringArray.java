import java.util.Arrays;
import java.util.stream.Stream;

public class StringArray {
    public static void main(String [] args) {
        String[] fruits = {"Apple", "Banana", "Cherry", "Orange"};
        Stream<String> stream = Arrays.stream(fruits);

        String[] fruitsWithB = stream
                .filter(b -> b.startsWith("B")).toArray(String[]::new);

        for(String fruit : fruitsWithB) {
            System.out.println(fruit);
        }
    }
}
