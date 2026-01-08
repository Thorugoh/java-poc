import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamCollect {
    private static void groupByLength() {
        System.out.println("- GroupBy Length -");
        List<String> technologies = List.of("Java", "React", "Node", "JS", "Html");

        Map<Integer, List<String>> groupedByLength = technologies.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);
    }

    private static void groupByLengthUppercased() {
        System.out.println("- GroupBy Length Uppercased -");
        List<String> technologies = List.of("Java", "React", "Node", "JS", "Html");

        Map<Integer, List<String>> groupedByLength = technologies.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.mapping(String::toUpperCase, Collectors.toList())));

        System.out.println(groupedByLength);
    }

    public static void main(String[] args) {
        groupByLength();
        groupByLengthUppercased();
    }
}
