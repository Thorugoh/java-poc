import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", String::length);
        System.out.println("Value for 'John': " + value + "\nMap: " + nameMap);

        Function<Integer, String> intToString = Objects::toString;
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        System.out.println("Quoted 5: " + quoteIntToString.apply(5));
    }
}