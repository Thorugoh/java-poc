import java.time.LocalDateTime;
import java.util.function.Supplier;

public class AnonymousSupplierDemo {
    public static void main(String[] args) {
        Supplier<LocalDateTime> dateTimeSupplier = new Supplier<LocalDateTime>() {
            @Override
            public LocalDateTime get() {
                return LocalDateTime.now();
            }
        };

        Supplier<LocalDateTime> lambdaDateTimeSupplier = () -> LocalDateTime.now();


        System.out.println("Current Date and Time: " + dateTimeSupplier.get());
        System.out.println("Current Date and Time (Lambda): " + lambdaDateTimeSupplier.get());
    }
}
