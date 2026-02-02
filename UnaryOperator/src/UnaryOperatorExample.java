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