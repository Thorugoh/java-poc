import java.util.ArrayList;
import java.util.List;

public class LazyEvaluation {
    public static void imperativeDoublingAndFindExample(List<Integer> numbers) {
        System.out.println("- Imperative way -");
        List<Integer> doubled = new ArrayList<>();

        for(Integer n: numbers) {
            System.out.println("Doubling " + n);
            doubled.add(n * 2);
        }

        Integer result = null;
        for(Integer n: doubled) {
            if(n > 10) {
                result = n;
                break;
            }
        }
        System.out.println("Found: " + result);
    }

    public static void declarativeDoublingAndFindExample(List<Integer> numbers) {
        System.out.println("- Declarative way (Streams) -");

        Integer result = numbers.stream()
                .map(n -> {
                    System.out.println("Doubling " + n);
                    return n * 2;
                })
                .filter(n -> {
                    System.out.println("Filtering " + n);
                    return n > 10;
                })
                .findFirst()
                .orElse(null);

        System.out.println("Found: " + result);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        imperativeDoublingAndFindExample(numbers);
        declarativeDoublingAndFindExample(numbers);
    }
}
