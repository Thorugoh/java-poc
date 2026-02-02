import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class UnaryOperatorExample implements UnaryOperator<String> {
    @Override
    public String apply(String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) {
        UnaryOperator<String> uo = new UnaryOperatorExample();
        String result = uo.apply("Victor Hugo");
        System.out.println(result);
    }
}

class UnaryOperatorInt {
    public static void main(String[] args) {
        UnaryOperator<Integer> incrementByOne = x -> x + 1;
        int originalValue = 5;

        int result = incrementByOne.apply(originalValue);

        System.out.println("Original value: " + originalValue);
        System.out.println("After incrementing by one: " + result);
    }
}

class UnaryOperatorIntWithStream {
    public static void main(String[] args) {
        UnaryOperator<Integer> incrementbyOne = x -> x + 1;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> results = numbers.stream().map(incrementbyOne).toList();

        System.out.println("Original numbers: " + numbers);
        System.out.println("Result: " + results);
    }
}

class UnaryOperatorLambda {
    public static void main(String[] args) {
        UnaryOperator<String> stringProcessor = s -> s.toUpperCase().trim();

        String inputText = "    hello world    ";

        String processedText = stringProcessor.apply(inputText);
        System.out.println(processedText);

        List<String> inputTexts = Arrays.asList("   example text   ", "   another example   ", "   one more example   ");
        List<String> processedTexts = inputTexts.stream()
                                               .map(stringProcessor)
                                               .collect(Collectors.toList());

        System.out.println("Original texts: " + inputTexts);
        System.out.println("Processed texts: " + processedTexts);
    }
}