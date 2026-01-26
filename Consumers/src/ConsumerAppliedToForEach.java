import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerAppliedToForEach {
    public static void main(String[] args) {
        Consumer<Integer> printDouble = a -> System.out.println(a * 2);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(printDouble);
    }
}
