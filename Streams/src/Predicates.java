import java.util.function.Predicate;

public class Predicates {
    public static void main(String[] args) {
        Predicate<Order> isExpensive = order -> order.getPrice() > 500;
        Predicate<Order> isCancelled = order -> order.getStatus() == Status.CANCELLED;

        Predicate<Order> shouldAudit = isExpensive.and(isCancelled);
    }
}
