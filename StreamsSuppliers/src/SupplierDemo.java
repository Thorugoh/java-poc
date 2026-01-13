import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo implements Supplier<LocalDateTime> {

    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }

    public static void main(String[] args) {
        Supplier<LocalDateTime> dateTimeSupplier = new SupplierDemo();
        System.out.println("Current Date and Time: " + dateTimeSupplier.get());
        System.out.println(productSupplier().get());
    }

    private static Supplier<List<Product>> productSupplier() {
        Supplier<List<Product>> supplier = () -> {
            List<Product> productList = new ArrayList<Product>();
            productList.add(new Product(1, "Laptop", 999.99f));
            productList.add(new Product(2, "Smartphone", 499.49f));
            productList.add(new Product(3, "Tablet", 299.29f));

            return productList;
        };

        return supplier;
    };
}