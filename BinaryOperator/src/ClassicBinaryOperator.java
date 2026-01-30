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