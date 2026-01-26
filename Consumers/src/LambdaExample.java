import java.util.function.Consumer;

public class LambdaExample {

    public static void main(String[] args) {
        Consumer<String> newStyle = name -> System.out.println("Hello, " + name + "!");

        newStyle.accept("Alice");
    }
}
