import java.util.function.UnaryOperator;

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