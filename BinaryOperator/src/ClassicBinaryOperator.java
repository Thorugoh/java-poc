import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ClassicBinaryOperator implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer first, Integer second) {
        return first + second;
    }

    public static void main(String[] args) {
        ClassicBinaryOperator operator = new ClassicBinaryOperator();

        Integer result = operator.apply(5, 10);
        System.out.println("Result: " + result);
    }
}

class BinaryOperatorLambda {
    public static void main(String[] args) {
        BinaryOperator<Integer> divide = (a, b) -> {
            double divisionResult = (double) a / b;
            return (int) Math.round(divisionResult);
        };

        int divideResult = divide.apply(7, 3);
        System.out.println("Division Result: " + divideResult);
    }
}

class BinaryOperatorStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        BinaryOperator<Integer> add = (a, b) -> a + b;
        int sum = numbers.stream().reduce(0, add);

        int sum1 = numbers.stream().reduce(0, (a, b) -> a + b;);

        int sum2 = numbers.stream().reduce(0, Integer::sum);

        System.out.println("Sum: " + sum);
        System.out.println("Sum1: " + sum1);
        System.out.println("Sum2: " + sum2);
    }
}