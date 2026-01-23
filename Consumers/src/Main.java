import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        // Consumer to display a number
        Consumer<Integer> display = a -> System.out.println("The number is: " + a);

        // Using the Consumer to display the number 10
        display.accept(10);

        Consumer<List<Integer>> modify = list -> {
            for(int i = 0; i < list.size(); i++) {
                list.set(i, 2 * list.get(i));
            };
        };

        // Consumer to display a list of numbers
        Consumer<List<Integer>> displayList = list -> list.stream().forEach(a -> System.out.print(a + " "));

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        modify.accept(list);

        displayList.accept(list);
    }
}