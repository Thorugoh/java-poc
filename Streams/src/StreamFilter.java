import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamFilter {
    public static void imperativeFilterExample() {
        System.out.println("- Imperative way -");

        List<String> names = Arrays.asList("Victor", "Maria", "Valfredo", "Anna", "Mike");
        List<String> result = new ArrayList<>();

        for (String name : names) {
            if(name.startsWith("V")) {
                result.add(name);
            }
        }

        System.out.println("Imperative: Names starting with 'V': " + result);
    }

    public static void declarativeFilterExample() {
        System.out.println("- Declarative way (Streams)-");

        List<String> names = Arrays.asList("Victor", "Maria", "Valfredo", "Anna", "Mike");

        List<String> result = names.stream()
                .filter(name -> name.startsWith("V"))
                .toList();

        System.out.println("Declarative: Names starting with 'V': " + result);
    }

    public static void main(String[] args) {
        imperativeFilterExample();
        declarativeFilterExample();
    }
}
