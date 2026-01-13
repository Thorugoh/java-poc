import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierDemo implements Supplier<LocalDateTime> {

    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }

    public static void main(String[] args) {
        Supplier<LocalDateTime> dateTimeSupplier = new SupplierDemo();
        System.out.println("Current Date and Time: " + dateTimeSupplier.get());
    }
}