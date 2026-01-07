import java.util.List;

public class StreamMap {
    public static void main(String[] args) {
        List<Double> originalPrices = List.of(100.0, 200.0, 300.0, 400.0, 500.0);

        List<Double> discountedPrices = originalPrices.stream()
                .map(price -> price * 0.9)
                .toList();

        System.out.println("Original Prices: " + originalPrices);
        System.out.println("Discounted Prices: "+ discountedPrices);
    }
}
