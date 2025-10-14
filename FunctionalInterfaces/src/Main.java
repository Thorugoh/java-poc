import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Main {
    public static byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsByte(array[i]);
        }

        return transformedArray;
    }

    public static void main(String[] args) {
        Map<String, Integer> nameMap = new HashMap<>();
        Integer value = nameMap.computeIfAbsent("John", String::length);
        System.out.println("Value for 'John': " + value + "\nMap: " + nameMap);

        Function<Integer, String> intToString = Objects::toString;
        Function<String, String> quote = s -> "'" + s + "'";
        Function<Integer, String> quoteIntToString = quote.compose(intToString);

        System.out.println("Quoted 5: " + quoteIntToString.apply(5));

        short[] array ={(short) 1, (short) 2, (short) 3};
        byte[] transformedArray = transformArray(array, s -> (byte) (s * 2));
        System.out.print("Transformed array: ");
        for (byte b : transformedArray) {
            System.out.print(b + " ");
        }
    }


}