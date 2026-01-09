import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectPartitioningBy {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order(100.0, Status.SENT),
                new Order(200.0, Status.CANCELLED),
                new Order(50.0, Status.SENT),
                new Order(80.0, Status.PENDING)
        );

        Map<Boolean, List<Order>> cancelledOrders = orders.stream()
                .collect(Collectors.partitioningBy(o -> o.getStatus() == Status.CANCELLED));

        System.out.println("Cancelled Orders: " + cancelledOrders.get(true));
        System.out.println("Non-Cancelled Orders: " + cancelledOrders.get(false));
    }
}
