import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Predicates {
    public static void main(String[] args) {
        Predicate<Order> isExpensive = order -> order.getPrice() > 500;
        Predicate<Order> isCancelled = order -> order.getStatus() == Status.CANCELLED;

        Predicate<Order> shouldAudit = isExpensive.and(isCancelled);
        Predicate<Order> active = isCancelled.negate();

        List<Order> toAudit = Stream.of(
                new Order(600.0, Status.CANCELLED),
                new Order(300.0, Status.CANCELLED),
                new Order(800.0, Status.SENT)
        ).filter(shouldAudit).toList();

        System.out.println(toAudit);
    }
}
